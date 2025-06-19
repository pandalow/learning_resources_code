package FileDealing;

import org.junit.Test;

import java.io.File;

public class FileExercise{
    @Test
    public void testFile() {
        File file = new File("IN_OUTStream.iml");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.exists());
    }
}