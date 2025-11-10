import java.util.*;

public class MyCalendar {
    // index 0 = JANUARY, 1 = FEBRUARY, ..., 11 = DECEMBER
    enum Month { JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER }
    
    public static void printCalendar(int year) {
        // 1월부터 12월까지 반복
        for (Month month : Month.values()) {
            System.out.println(year + "년 " + (month.ordinal() + 1) + "월");
            System.out.println(" 일 월 화 수 목 금 토");

            Calendar cal = Calendar.getInstance();
            cal.clear();
            // 월은 0부터 시작하므로 month.ordinal() 사용
            cal.set(year, month.ordinal(), 1);
            // 첫 날의 요일 계산
            int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            // 해당 월의 총 일수 계산
            int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

            // 첫 주의 공백 출력
            for (int i = 1; i < firstDayOfWeek; i++) {
                System.out.print("   ");
            }

            // 날짜 출력
            for (int day = 1; day <= lastDay; day++) {
                System.out.printf("%2d ", day);
                // 토요일마다 줄 바꿈
                if ((firstDayOfWeek + day - 1) % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println("\n");
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 년도 입력받기
            System.out.print("년도 입력(-1이면 종료) >> ");
            int year = scanner.nextInt();

            // -1 입력 시 종료
            if (year == -1) {
                System.out.println("프로그램 종료");
                scanner.close();
                return;
            }

            // 해당 년도 캘린더 출력
            printCalendar(year);
        }
    }
}
