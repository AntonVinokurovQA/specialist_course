package labfourfiles;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCount {
    public static String testString = "test 11231314dsjk, dskdj , dsajd, psod test";
    Map<String, Integer> words = new HashMap<>();
    private String inFile;
    private String outFile;

    public WordCount(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void countWords() {
        Reader reader = null;
        File file = new File(inFile);
        if (file.exists() && file.isFile()) {
            try {
                reader = new FileReader(inFile);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            reader = new StringReader(testString);
        }

        try (BufferedReader br = new BufferedReader(reader)) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                StringTokenizer st = new StringTokenizer(line, " .,/;:");
                String token;
                while (st.hasMoreTokens()) {
                    token = st.nextToken();
                    words.merge(token, 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<String, Integer> getWords() {
        return words;
    }
}
