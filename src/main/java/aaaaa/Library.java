package aaaaa;
import java.util.ArrayList;
// 지정되지 않은 배열을 위해 어레이리스트 사용//
public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // 책 추가  에드북을 이용하여 북스에 전달받은 내용을 북스에 담음
    public void addBook(Book book) {
        books.add(book);
    }

    // 책 판매  타이틀 수량을 받아서 강화된 for 문을 사용해 books에 있는모든 책들을 getTitle매소드로
    // 책이름을 타이틀과 비교 sellBook 메소드를통해 수량을 받아 판매
    public void sellBook(String title, int quantity) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.sellBook(quantity);
                return; //
            }
        }
        System.out.println("해당 제목의 책을 찾을 수 없습니다.");
    }

    // 모든 책 정보 출력 메서드
    public void showAllBooks() {
        System.out.println("도서 목록:");
        for (Book book : books) { //강화포문을 이용해서 모든책을 출력
            System.out.println(book.getDetails());
        }
    }

    // 책 찾기 메서드
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) { // 책이름 과 대조해서 리턴을 사용해 책의 데이터반환
                return book;
            }
        }
        return null;
    }
}
