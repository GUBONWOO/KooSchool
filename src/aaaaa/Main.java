package aaaaa;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //스캐너사용준비
        Library library = new Library(); // 인스턴트생성

        // 책 추가하기
        System.out.println("도서관에 추가할 책의 개수를 입력하세요:");
        int numBooks = scanner.nextInt(); //스캐너로 받아온인트값을 대입
        scanner.nextLine(); // 개행문자 처리

        for (int i = 0; i < numBooks; i++) { //포문으로 입력받은 넘버까지 돌림
            System.out.println("책 제목을 입력하세요:");
            String title = scanner.nextLine();
            System.out.println("저자를 입력하세요:");
            String author = scanner.nextLine();
            System.out.println("가격을 입력하세요:");
            double price = scanner.nextDouble();
            System.out.println("재고 수량을 입력하세요:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // 개행문자 처리

            Book book = new Book(title, author, price, quantity); //받은정보들을 book에 입력
            library.addBook(book); //addBook을 이용하여 받은값을 라이브러리에 저장
        }

        // 도서관에 있는 모든 책 정보 출력
        System.out.println("\n현재 도서 목록:");
        library.showAllBooks();

        // 책 판매
        System.out.println("\n판매할 책의 제목을 입력하세요:");
        String sellTitle = scanner.nextLine();
        System.out.println("판매할 수량을 입력하세요:");
        int sellQuantity = scanner.nextInt();
        library.sellBook(sellTitle, sellQuantity); //입력받은값은 값을 메소드를이용
        scanner.nextLine(); // 개행문자 처리

        // 재고 추가
        System.out.println("\n재고를 추가할 책의 제목을 입력하세요:");
        String addStockTitle = scanner.nextLine();
        Book bookToAddStock = library.findBookByTitle(addStockTitle); //책이름 비교
        if (bookToAddStock != null) {
            System.out.println("추가할 재고 수량을 입력하세요:");
            int addStockQuantity = scanner.nextInt();
            bookToAddStock.addStock(addStockQuantity); //입력받은값을
        } else {
            System.out.println("해당 제목의 책을 찾을 수 없습니다.");
        }

        // 최종 도서 목록 출력
        System.out.println("\n최종 도서 목록:");
        library.showAllBooks();
    }
}
