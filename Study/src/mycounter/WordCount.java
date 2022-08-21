package mycounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;



public class WordCount {

    private String inFile = "readme.txt";
    private String outFile;

 //   private static String testString = "Have no fear of perfection, you’ll never reach it.";
      private static String testString;
    
    Hashtable words = new Hashtable();

    public Hashtable getWords() {
        return words;
    }

    public WordCount(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    void countWords() {
        int num = 0;
        try {
            Reader reader;
            if (inFile == null) {
                reader = new StringReader(testString);
            } else {
                reader = new FileReader(inFile);
            }

            BufferedReader br = new BufferedReader(reader);

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                StringTokenizer st = new StringTokenizer(line, "  \t\n\r\f.,;:\"");
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if (!words.containsKey(token)) {
                        words.put(token, 1);
                        num++;
                    } else {
                        Object val = words.get(token);
                        int n = (int) val;
                        n++;
                        words.put(token, n);
                    }
                }
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        };
    }

    public static void main(String[] args) {
         SimpleParser sp=new SimpleParser();  
   //  SimpleParser sp = new SimpleParser(" readme"," Name2",
       //        new String []{"?", "r", "w"},new String []{"/", "-"});
        sp.Parse(args);
        
        

      //  WordCount wc = new WordCount(null, null);
        WordCount wc=new WordCount(sp.getInFile(), null);
        wc.countWords();

        Enumeration keys = wc.getWords().keys();
        while (keys.hasMoreElements()) {
            String w = keys.nextElement().toString();
            int n = (int) wc.getWords().get(w);
            System.out.println(w + "   " + n);
        }
    }
}
    

