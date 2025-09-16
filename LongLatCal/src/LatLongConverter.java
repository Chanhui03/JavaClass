// 이 코드는 직접 작성하였습니다.

// 스캐너 라이브러리
import java.util.Scanner;

// 클래스 이름 "LatLongConverter"
public class LatLongConverter {
    // main 함수
    public static void main(String[] args) {
        // 스캐너 생성, 값 선택 문구 출력, 스캐너 입력 -> answer 변수에 저장
        Scanner scanner = new Scanner(System.in);
        System.out.println("변환할 값을 선택하세요. (LON:경도, LAT:위도)");
        String answer = scanner.next();

        switch (answer) {
            case "LON": // Longtitude = 경도
                // 경도 값 입력, 허용 값인지 체크, 계산 전 미리 경도 값 출력(양수, 음수 보존)
                System.out.println("변환할 경도 값을 입력하세요.");
                double LON = scanner.nextDouble(); // double 타입으로 리턴
                if ((LON < -180) || (LON > 180)) { // 경도의 허용 값은 -180 ~ 180 사이
                    System.out.println("허용되지 않는 값입니다.");
                    break;
                }
                
                System.out.print("경도" + LON + "도는 ");

                // 양수 음수 판단
                char dirLON;
                // +
                if (LON >= 0) {
                    dirLON = 'E';
                }
                // -
                else {
                    dirLON = 'W';
                    LON = -LON;
                }

                // 변환식
                int intLON = (int)LON;
                double LONMinutes = (LON - intLON) * 60;
                int intLONMinutes = (int)LONMinutes;
                double LONSeconds = (LONMinutes - intLONMinutes) * 60;
                
                // 최종경도 값 출력
                System.out.printf("%02d도 %02d분 %07.4f초 %c입니다.%n", intLON, intLONMinutes, LONSeconds, dirLON);

                break;
            case "LAT": // Latitude = 위도
                System.out.println("변환할 위도를 입력하세요.");
                double LAT = scanner.nextDouble();
                if ((LAT < -90.0) || (LAT > 90.0)) { // 위도의 허용 값은  -90 ~ 90 사이
                    System.out.println("허용되지 않는 값입니다.");
                    break;
                }

                System.out.print("위도" + LAT + "도는 ");

                char dirLAT;
                // +
                if (LAT >= 0) {
                    dirLAT = 'N';
                }
                // -
                else {
                    dirLAT = 'S';
                    LAT = -LAT;
                }

                int intLAT = (int)LAT;
                double LATMinutes = (LAT - intLAT) * 60;
                int intLATMinutes = (int)LATMinutes;
                double LATSeconds = (LATMinutes - intLATMinutes) * 60;

                System.out.printf("%02d도 %02d분 %07.4f초 %c입니다.%n", intLAT, intLATMinutes, LATSeconds, dirLAT);

                break;
            default:
            System.out.println("허용되지 않는 값입니다.");

        }

        scanner.close();
    }
}
