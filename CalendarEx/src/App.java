import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("년도 입력(-1이면 종료) >> ");
            int year = scanner.nextInt();
            if (year == -1) break;

            printCalendar(year);
        }

        scanner.close();
    }

    private static void printCalendar(int year)
    {
        for (int month = 1; month <= 12; month++) {
            printCalendarMonth(year, month);
            System.out.println("-----------------------");
        }
    }

    private static void printCalendarMonth(int year, int month)
    {
        System.out.println(year + "년 " + month + "월");
        System.out.println("일 월 화 수 목 금 토");

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        // 시작 요일에 따라서 공백을 출력
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        for (int j = 0; j < dayOfWeek; j++) {
            System.out.print("   ");
        }

        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= lastDay; i++) {
            System.out.printf("%2d ", i);
            if ((i + dayOfWeek) % 7 == 0)
                System.out.println("");
        }

        System.out.println("");
    }
}
