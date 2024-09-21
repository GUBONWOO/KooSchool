package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFrame extends JFrame {

    private static JPanel todoPanel;

    public MainFrame() {
        setSize(500, 500);
        setTitle("Main");
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 1));

        // 현재 날짜와 등록 버튼
        JPanel p1 = new JPanel(new GridLayout(1, 3));
        Date now = new Date();
        String yyyyMM = new SimpleDateFormat("yyyy년MM월").format(now);

        JLabel l1 = new JLabel("현재날짜 : " + yyyyMM);
        JButton b1 = new JButton("TODO 등록");
        JButton refreshButton = new JButton("갱신"); // 갱신 버튼 추가

        // TODO 등록 버튼을 클릭하면 새로운 프레임을 엽니다.
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TodoRegisterFrame();  // 새로운 Todo 등록 프레임 열기
            }
        });

        // 갱신 버튼 클릭 시 TODO 리스트 새로고침
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTodoList();  // TODO 리스트 새로고침
            }
        });

        p1.add(l1);
        p1.add(b1);
        p1.add(refreshButton); // 패널에 갱신 버튼 추가

        // TODO 버튼을 추가할 패널
        todoPanel = new JPanel(new GridLayout(0, 1));
        JScrollPane sp = new JScrollPane(todoPanel);

        add(p1);
        add(sp);

        // 파일에서 TODO 아이템을 불러옵니다.
        loadTodosFromFile();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // 파일에서 TODO 아이템을 불러오는 메서드
    public static void loadTodosFromFile() {
        File file = new File("./src/file/test.csv");
        todoPanel.removeAll();  // 이전 내용을 제거
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    addTodoButton(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        todoPanel.revalidate(); // 패널 갱신
        todoPanel.repaint();    // 패널 다시 그리기
    }

    // 패널에 TODO 버튼 추가
    private static void addTodoButton(String todoItem) {
        JButton todoButton = new JButton(todoItem);
        todoButton.setBackground(Color.GRAY);
        todoPanel.add(todoButton);
        todoPanel.revalidate(); // Refresh the panel
        todoPanel.repaint();    // Repaint the panel
    }

    // 파일에서 TODO 리스트를 다시 로드하여 새로고침
    public void refreshTodoList() {
        loadTodosFromFile();  // 파일을 다시 불러와서 TODO 리스트를 갱신
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
