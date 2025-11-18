import java.util.*;

public class AccountManagementProgram {
    static BankManager bm = new BankManager();
    public static void main(String[] args) throws Exception {
        // 계좌 관리 프로그램
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("*** 한국해양은행에 오신 것을 환영합니다. ***");
        // 계좌를 담을 해쉬맵

        boolean running = true;

        while (running) { 
            int selectedMenu = getSelectedMenu(scanner);
            switch (selectedMenu) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
            }
            
        }

        scanner.close();
    }

    private static int getSelectedMenu(Scanner scanner) {
        return 0;
    }

    private static void processDeposit(Scanner scanner) {

    }

    private static void processWithdraw(Scanner scanner) {

    }

    private static void processInquiry(Scanner scanner) {

    }

    private static void processInquiryAll() {
        
    }
}
