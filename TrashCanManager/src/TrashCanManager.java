import java.util.Scanner;

public class TrashCanManager {
    TrashCan[] trashCans;
    public TrashCanManager() {
        trashCans = new TrashCan[3];
        trashCans[0] = new PlasticTrashCan("플라스틱");
        trashCans[1] = new BottleTrashCan("병/캔");
        trashCans[2] = new GeneralTrashCan("일반");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = processMainMenu();
            switch (choice) {
                case 1:
                    // 쓰레기통 상태보기
                    displayTrashCanContents();
                    break;
                case 2:
                    // 쓰레기 버리기
                    System.err.println("[쓰레기 버리기]");
                    break;
                case 3:
                    // 쓰레기통 비우기
                    System.err.println("[쓰레기통 비우기]");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    public int processMainMenu() {
        System.out.println("기능을 선택하세요. (1: 쓰레기통 상태보기/ 2: 쓰레기 버리기/ 3: 쓰레기통 비우기/ 0: 종료)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        return choice;
    }

    public void displayTrashCanContents() {
        System.err.println("--------------------------------");
        System.err.println("[쓰레기통 상태보기]");
        for (TrashCan trashCan : trashCans) {
            trashCan.displayContents();
        }
        System.out.println();
    }

    // 쓰레기 버리기
    public void disposeGarbage(Garbage garbage) {
        // 쓰레기통 선택
        System.err.println("[쓰레기 버리기]");
        System.err.println("쓰레기통을 선택하세요 1: 플라스틱 / 2: 병/캔 / 3: 일반 / 0: 이전");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        switch (choice) {
            // 플라스틱 쓰레기통
            case 1:
                System.err.println("[플라스틱 쓰레기통]");
                // 쓰레기 목록 출력
                System.err.print("버릴 쓰레기를 선택하세요: ");
                for (Garbage g : trashCans[0].getGarbages()) {
                    g.displayDetails();
                    System.err.print(" ");
                }
                System.err.println();
                break;
            // 병/캔 쓰레기통
            case 2:
                System.err.println("[병/캔 쓰레기통]");
                // 쓰레기 목록 출력
                System.err.print("버릴 쓰레기를 선택하세요: ");
                for (Garbage g : trashCans[1].getGarbages()) {
                    g.displayDetails();
                    System.err.print(" ");  
                }
                System.err.println();
                break;
            // 일반 쓰레기통
            case 3:
                System.err.println("[일반 쓰레기통]");
                // 쓰레기 목록 출력
                System.err.print("버릴 쓰레기를 선택하세요: ");
                for (Garbage g : trashCans[2].getGarbages()) {
                    g.displayDetails();
                    System.err.print(" ");
                }
                System.err.println();
                break;  

            case 0:
                // 이전 메뉴로 돌아가기
                return;
            default:
                System.out.println("잘못된 선택입니다.");  
        }
        
    }
}
