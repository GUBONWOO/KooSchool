package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TodoRegisterFrame extends JFrame {
    private String todoItem;


    public TodoRegisterFrame() {

        setSize(300, 100);
        setTitle("TODO 등록");
        setLocationRelativeTo(null);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("TODO");
        JTextField t1 = new JTextField(10);
        JButton b1 = new JButton("등록");

        // 버튼 클릭 시 텍스트 필드의 내용을 가져오고 필드를 비우는 로직
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedWriter bw = null;
                // 각종 check

                // file에 쓰기를 실행
                String todoItem = t1.getText();


                try {
                    File file = new File("./src/file","test.csv");
                    FileWriter writer = new FileWriter(file, true);
                    bw = new BufferedWriter(writer);

                    bw.write(todoItem);
                    bw.newLine();
//                    bw.flush();
                    bw.close();
                    dispose();

                    MainFrame.loadTodosFromFile();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }  finally {
                    try{
                        if(bw != null){
                            bw.flush();
                            bw.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }


            }
        });

        p1.add(l1);
        p1.add(t1);
        p1.add(b1);

        add(p1);

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 설정
        setVisible(true);
    }

//    }
    public static void main(String[] args) {

        new TodoRegisterFrame(); // 실행
    }
}
