public class DoWhileSample {
    public static void main(String[] args) throws Exception {
        char c = 'A';

        do {
            System.out.print(c);
            c = (char)(c + 1);
        } while (c <= 'z');
    }
}
