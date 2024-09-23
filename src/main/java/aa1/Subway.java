package aa1;

import java.util.Scanner;

public class Subway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = new DatabaseManager();

        while (true) {
            int n;
            do{
            System.out.println("숫자를 입력해주세요");
            System.out.println("1. 교통비입력 2. 교통비목록 3. 종료");
             n = scanner.nextInt();
            scanner.nextLine();}
            while (n<1 || n>3);

            if (n == 1) {
                System.out.println("이름을 입력하세요");
                String name = scanner.nextLine();
                System.out.println("목적지를 입력해주세요");
                String dsn = scanner.nextLine();

                int date;

                do {
                    System.out.println("월을 입력해주세요 (1 ~ 12 사이)");
                    date = scanner.nextInt();
                    scanner.nextLine();
                } while (date < 1 || date > 12);

                System.out.println("금액을 입력해주세요");
                int price = scanner.nextInt();
                scanner.nextLine();

                // 데이터베이스에 저장
                dbManager.insertTransport(name, dsn, date, price);

            } else if (n == 2) {
                int month;
                do {
                    System.out.println("월을 입력해주세요 (1 ~ 12 사이)");
                    month = scanner.nextInt();
                    scanner.nextLine();
                } while (month < 1 || month > 12);

                dbManager.getInf(month);

            } else if (n == 3) {
                break;
            }
        }
        scanner.close();
    }
}
