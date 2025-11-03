public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("쓰레기 관리 시스템입니다.");

        TrashCanManager manager = new TrashCanManager();
        manager.run();
    }
}
