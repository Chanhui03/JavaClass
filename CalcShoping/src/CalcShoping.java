import java.util.*;

public class CalcShoping {
    public static void main(String[] args) throws Exception {
        System.out.println("쇼핑 비용을 계산해 드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        Map<String, Integer> items = new HashMap<>();
        items.put("고추장", 3000);
        items.put("만두", 500);
        items.put("새우깡", 1500);
        items.put("콜라", 600);
        items.put("참치캔", 2000);
        items.put("치약", 1000);
        items.put("연어", 2500);
        items.put("삼겹살", 2500);
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.print("[" + entry.getKey() + ", " + entry.getValue() + "]");
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in, "UTF-8");

        // 무한 루프를 돌면서 사용자 입력을 받음
        while (true) {  
            System.out.print("물건과 개수를 입력하세요 >> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            String itemName = parts[0];

            // 예외들
            // "그만" 입력 시 종료
            if (itemName.equals("그만")) {
                break;
            }

            // 입력이 [이름, 개수] 쌍이 아닌 경우 다시 입력 받음
            if (parts.length % 2 != 0) {
                System.out.println("입력에 문제가 있습니다.");
                continue;
            }

            // 상품이 존재하는지 확인
            // 존재하지 않는 상품이 있을 시 다시 입력 받음
            boolean isInHashMap = true;
            for (int i = 0; i < parts.length; i += 2) {
                String name = parts[i];
                if (!items.containsKey(name)) {
                    System.out.println(name + "은(는) 없는 물건입니다.");
                    isInHashMap = false;
                }
            }
            if (!isInHashMap) {
                continue;
            }

            // 총 비용 계산 및 출력
            int totalCost = 0;
            for(int i = 0; i < parts.length; i += 2) {
                String currentItemName = parts[i];
                int quantity = Integer.parseInt(parts[i + 1]);
                if (items.containsKey(currentItemName)) {
                    totalCost += items.get(currentItemName) * quantity;
                }
            }
            System.out.println("전체 비용은 " + totalCost + "원 입니다.");
        }

        scanner.close();
    }
}
