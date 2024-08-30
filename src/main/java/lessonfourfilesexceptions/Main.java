package lessonfourfilesexceptions;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        File dir = new File(".");
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };
        File[] files = dir.listFiles((f) -> f.isFile());

        for (File f: files){
                System.out.println(file.getName());
        }
    }
}
