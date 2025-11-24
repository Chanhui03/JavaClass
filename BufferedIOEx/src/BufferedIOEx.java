import java.io.*;
import java.util.Scanner;

public class BufferedIOEx {
    public static void main(String[] args) throws Exception {
        FileReader fin = null;
        int c;
        try {
            fin = new FileReader("/Users/kwonchanhui/code/Java/BufferedIOEx/test.txt");
            BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
            while ((c = fin.read()) != -1) {
                out.write(c);
            }

            new Scanner(System.in).nextLine();
            out.flush();
            fin.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 출력이 깨지는 이유 = 바이트 단위로 읽어서 한글 바이트 중간에 출력되기에 깨짐