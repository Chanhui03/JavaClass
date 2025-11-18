import java.util.Scanner;

public class AccountManagementProgram {
    static BankManager bm = new BankManager();
    static Scanner scanner = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) throws Exception { 
        boolean running = true;       
        System.out.println("*** 한국해양은행에 오신 것을 환영합니다. ***");

        while (running) { 
            int selectedMenu = getSelectedMenu(scanner);
            switch (selectedMenu) {
                case 1: // 입금
                    processDeposit(scanner);
                    break;
                case 2: // 출금
                    processWithdraw(scanner);
                    break;
                case 3: // 조회
                    processInquiry(scanner);
                    break;
                case 4: // 전체 조회
                    processInquiryAll();
                    break;
                case 5: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    break;
            }
            
        }

        scanner.close();
    }

    /**
     * 메뉴 선택
     * @param scanner
     * @return 
     */
    private static int getSelectedMenu(Scanner scanner) {
        System.out.print("입금:1, 출금:2, 조회:3, 전체 조회:4, 종료:5 >> ");
        return scanner.nextInt();
    }

    /**
     * 
     * @param scanner
     */
    private static void processDeposit(Scanner scanner) {
        System.out.print("계좌명과 액수 >> ");
        String name = scanner.next();
        int amount = scanner.nextInt();
        bm.deposit(name, amount);

    }

    private static void processWithdraw(Scanner scanner) {
        System.out.print("계좌명과 액수 >> ");
        String name = scanner.next();
        int amount = scanner.nextInt();
        if (bm.withdraw(name, amount) < 0) {
            System.out.println("잔액이 부족하여 출금할 수 없음!!");
        }
    }

    private static void processInquiry(Scanner scanner) {
        System.out.print("계좌명 >> ");
        String name = scanner.next();
        System.out.println(bm.getBalanceString(name));
    }

    private static void processInquiryAll() {
        String[] balances = bm.getAllBalanceString();
        for (String s : balances) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
}
