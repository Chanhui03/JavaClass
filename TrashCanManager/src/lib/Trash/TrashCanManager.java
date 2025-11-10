package lib.Trash;

import java.util.Scanner;

public class TrashCanManager {
    TrashCan[] trashCans;

    public TrashCanManager() {
        trashCans = new TrashCan[3];
        trashCans[0] = new PlasticTrashCan("플라스틱 쓰레기통");
        trashCans[1] = new BottleTrashCan("병/캔 쓰레기통");
        trashCans[2] = new GeneralTrashCan("일반쓰레기통");
    
        trashCans[0].addGarbage(new PlasticGarbage("칫솔", 12));
        trashCans[2].addGarbage(new PlasticGarbage("세제통", 12));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int menu = processMainMenu(scanner);
            if (menu == 0) break;
            else if (menu == 1) displayTrashCanContents();
            else if (menu == 2) processThrowGarbage(scanner);
        }

         scanner.close();
         System.out.println("프로그램을 종료합니다.");
    }

    /**
     * 메인 메뉴를 처리하는 함수
     * @param scanner 키보드 입력 스캐너
     * @return 선택한 메뉴 번호
     */
    public int processMainMenu(Scanner scanner) {
        System.out.println("-----------------------");
        System.out.println("기능을 선택하세요. (1: 쓰레기통 상태보기/ 2: 쓰레기 버리기/ 3: 쓰레기통 비우기 / 0: 종료)");
        
        while (true) {
            int menuItem = scanner.nextInt();
            if (menuItem >= 0 && menuItem <= 3) {
                return menuItem;
            }

            System.out.println("지원하지 않는 값입니다.");
            System.out.println("기능을 선택하세요. (1: 쓰레기통 상태보기/ 2: 쓰레기 버리기/ 3: 쓰레기통 비우기 / 0: 종료)");
        }
    }

    public void processThrowGarbage(Scanner scanner) {

    }

    /**
     * 모든 쓰레기통의 상태를 출력하는 함수
     */
    public void displayTrashCanContents() {
        System.out.println("-----------------------");
        System.out.println("[쓰레기통 상태 표시]");
        for (TrashCan trashCan : trashCans) {
            trashCan.displayContents();
        }
    }
}
