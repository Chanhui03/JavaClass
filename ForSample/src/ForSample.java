public class ForSample {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                sum += i;
                System.out.print(i);
                if (i <= 19)
                    System.out.print("+");
                else {
                    System.out.print("=");
                    System.out.println(sum);
                }
            }
        }
    }
}
