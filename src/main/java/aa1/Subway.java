package aa1;

import java.util.Scanner;

public class Subway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Inf inf = new Inf();
        DatabaseManager dbManager = new DatabaseManager(); // DatabaseManager 객체 생성

        while (true) {
            System.out.println("숫자를 입력해주세요");
            System.out.println("1. 교통비입력 2. 교통비목록 3.종료");
            int n = scanner.nextInt();
            scanner.nextLine();

            if (n == 1) {
                System.out.println("이름을 입력하세요");
                String name = scanner.nextLine();
                System.out.println("목적지를 입력해주세요");
                String dsn = scanner.nextLine();
                System.out.println("월 입력해주세요");
                int date = scanner.nextInt();
                scanner.nextLine();
                System.out.println("금액을 입력해주세요");
                int price = scanner.nextInt();
                scanner.nextLine();



                // 데이터베이스에 저장
                dbManager.insertTransport(name, dsn, date, price);

            } else if (n == 2) {
                System.out.println("월을 입력해주세요");
                int month = scanner.nextInt();
                dbManager.getInf(month);
                scanner.nextLine();

            } else if (n == 3) {
                break;
            }
        }
        scanner.close();
    }
}
