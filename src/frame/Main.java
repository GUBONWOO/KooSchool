package frame;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int count = 0;


        while (count < 3) {
            try {

                    System.out.println("==============");
                    System.out.println("이름을 입력해주세요");
                    String name = scanner.nextLine();
                    System.out.println("학번을 입력해주세요");
                    int studentId = scanner.nextInt();
                    System.out.println("수학 과학 영어 점수를 입력해주세요");
                    int mathScore = scanner.nextInt();
                    int scienceScore = scanner.nextInt();
                    int englishScore = scanner.nextInt();
                    scanner.nextLine();


                    Student student = new Student(name, studentId, mathScore, scienceScore, englishScore);
                    students.add(student);
                    student.getAverage();
                    count++;


            }

            catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요");
                scanner.nextLine();


            }
        }

            System.out.println("모든 학생:");
            for (Student student : students) {
                student.printStudentInfo();

            }

            Student topStudent = null;

            for (Student student : students) {
                if (topStudent == null || student.getAverage() > topStudent.getAverage()) {
                    topStudent = student;
                }
            }

            // 결과 출력
            if (topStudent != null) {
                System.out.println("가장 높은 평균 점수를 가진 학생:" + topStudent.getName());

                System.out.println("평균 점수: " + topStudent.getAverage());
            } else {
                System.out.println("학생 정보가 없습니다.");
            }


            scanner.close();



    }}
