package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputPosMenuNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputFoodMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuCount() {
        System.out.println("## 메뉴의 수량을 입력하세요");
        return scanner.nextInt();
    }

    public static int inputPaymentNumber(int tableNumber) {
        System.out.printf("## %d 번 테이블의 결제를 시작합니다. \n## 신용카드는 1번, 현금은 2번\n", tableNumber);
        return scanner.nextInt();
    }

}
