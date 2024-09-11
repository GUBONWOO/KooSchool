package frame;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxProducts = 10;
        String[] productName = new String[maxProducts];
        int [] productPrice = new int[maxProducts];
        int [] productQuantity = new int[maxProducts];
        int productCount = 0;

        while (true) {
            System.out.println("1. 상품등록 | 2. 상품 목록 | 3. 종료\n");
            int menu = sc.nextInt();
            sc.nextLine();
            if (menu == 1) {
                if (productCount >= maxProducts) {
                    System.out.println("Full");
                    continue;
                }
                System.out.println("이름을 입력하세요");
                productName[productCount] = sc.nextLine();
                System.out.println("가격을 입력하세요");
                productPrice[productCount] = sc.nextInt();
                System.out.println("수량을 입력하세요");
                productQuantity[productCount] = sc.nextInt();
                productCount++;
            } else if (menu == 2) {
                if(productCount ==0){
                    System.out.println("Empty");
                    continue;
                } else if (productCount !=0){
                    for (int i =0; i<productCount; i++)
                    System.out.println(productName[i] + productPrice[i]+"원"+ productQuantity[i]+"개");
                }




            } else if (menu == 3) {
                break;
            }
            else if (menu !=1 && menu !=2 && menu !=3) {
                System.out.println("잘못 입력하셨습니다");
                continue;
            }

        }sc.close();

    }
}
