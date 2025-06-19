package IOStream;

import java.io.*;

public class BufferWr {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("1.markdown"));
        bufferedWriter.write("韩顺平教育");
        bufferedWriter.close();

    }
}
