import java.io.*;

public class File {
    public static void main(String[] args) throws Exception {
        // InputStreamReader in = null;
        FileReader fin = null;

        try {
            fin = new FileReader("/Users/kwonchanhui/code/Java/finout/test.txt");
            // in = new InputStreamReader(fin,"UTF-8");

            int c;

            while ((c = fin.read()) != -1) {
                System.out.print((char)c);
            }

            // in.close();
            fin.close();

        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
