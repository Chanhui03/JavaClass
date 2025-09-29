import java.util.Random;
import java.util.Scanner;

public class UpDown {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) { 
            Random r = new Random();
            int min = 0;
            int max = 99;
            int count = 1;

            int k = r.nextInt(max + 1);
            System.out.println("수를 결정하였습니다. 맞추어 보세요");
            int answer;


            while (true) { 
                System.out.println(min + "-" + max);
                System.out.print(count + ">>");
                answer = scanner.nextInt();
                if(answer == k) break;
                if(answer < k) {
                    System.out.println("더 높게");
                    min = answer + 1;
                    count++;
                }
                if(answer > k) {
                    System.out.println("더 낮게");
                    max = answer - 1;
                    count++;
                }
            }
            System.out.println("맞았습니다.");
            System.out.print("다시하시겠습니까(y/n)>>");
            String text = scanner.next();
            if(text.equals("n")) break;
        }
        scanner.close();
    }
}
