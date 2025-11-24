import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Dict dictionary = new Dict();
        dictionary.loadDictionary("/Users/kwonchanhui/code/Java/DicFind/eng_kor_words.txt");

        Scanner scanner = new Scanner(System.in, "UTF-8");

        while(true) {
            System.out.print("단어를 입력하세요 ('exit': 종료 / 'show all': 모든 단어 출력) : ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("종료합니다.");
                break;
            }
            else if (input.equals("show all")) {
                dictionary.showAllWords();
                continue;
            }

            String korTraslation = dictionary.translateToKorean(input);
            if (!korTraslation.isEmpty()) {
                System.out.println(input + ": " + korTraslation);
                continue;
            }

            String engTraslation = dictionary.translateToEnglish(input);
            if (!engTraslation.isEmpty()){
                System.out.println(input + ": " + engTraslation);
                continue;
            }

            System.out.println("존재하지않는 단어입니다.");
        }

        scanner.close();
    }
}