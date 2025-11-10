package app;
import lib.Trash.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("쓰레기 관리 시스템입니다.");

        TrashCanManager manager = new TrashCanManager();
        // 라이브러리에 f12를 누르면 정의된 클래스로 이동함
        manager.run();
    }
}
