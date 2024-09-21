package aaaaa;
public class Book {
    // 멤버 변수정의
    private String title;
    private String author;
    private double price;
    private int quantity;

    // 생성자 정의  this를 사용하여  맴버변수
    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    // 책 정보를 반환하는 메서드
    public String getDetails() {
        return "제목: " + title + ", 저자: " + author + ", 가격: " + price + ", 재고: " + quantity;
    }

    // 책 판매
    public void sellBook(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            System.out.println("'" + title + "'의 남은 재고: " + this.quantity);
        } else {
            System.out.println("'" + title + "'의 재고가 부족합니다.");
        }
    }

    // 재고 추가 메서드
    public void addStock(int quantity) {
        this.quantity += quantity; //원래기존 수치에서 입력받은값을 더함
        System.out.println("'" + title + "'의 남은 재고: " + this.quantity);
    }

    // 책 제목 반환
    public String getTitle() {
        return title;
    }
}
