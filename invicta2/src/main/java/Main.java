import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.BreakIterator;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String fileName = "invictaExercise.csv";
//        saveFile(fileName);
        csvFile csvFile = new csvFile("csvFile.csv");
        xmlFile xmlFile = new xmlFile("xmlFile.xml");
//        saveFileCSV(csvFile.getFileName());
        saveFileXML(xmlFile.getFileName());

//        splitSentences("Im testing a method. Second test");
//        splitWords("I'm testing method split words, result is");

    }

    private static void saveFileXML(String fileName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell us your sentence please: ");
        String userSentence = scanner.nextLine();
        System.out.println("Your sentence: " + userSentence);
        splitWords(userSentence);

        try {
            PrintWriter out = new PrintWriter(fileName);
            System.out.println("<?xml version=\"1.0\" kodowanie=\"UTF-8\" standalone=\"tak\"?>");
            out.println("<?xml version=\"1.0\" kodowanie=\"UTF-8\" standalone=\"tak\"?>");
            out.println("<text>");
            System.out.println("<text>");
            out.println("<sentence>");
            System.out.println("<sentence>");
            out.println(sortString(sortString(userSentence)));
            out.println("</sentence>");


            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, cannot create file!");
        }
        scanner.close();
    }

    private static void saveFileCSV(String fileName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell us your sentence please: ");
        String userSentence = scanner.nextLine();
        splitWords(sortString(sortString(userSentence)));
        System.out.println("Your sentence: " + userSentence);

        try {
            PrintWriter out = new PrintWriter(fileName);
            out.println(userSentence);
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, cannot create file!");
        }
        scanner.close();
    }

//    private static void saveFileXML(String fileName) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Tell us your sentence please: ");
//        String userSentence = scanner.nextLine();
//        System.out.println("Your sentence: " + userSentence);
//        splitWords(userSentence);
//        ArrayList<String> userWords = new ArrayList<>();
//        for (String userWord : userWords) {
//        }
//        try {
//            PrintWriter out = new PrintWriter(fileName);
//            System.out.println("<?xml version=\"1.0\" kodowanie=\"UTF-8\" standalone=\"tak\"?>");
//            out.println("<?xml version=\"1.0\" kodowanie=\"UTF-8\" standalone=\"tak\"?>");
//            out.println("<text>");
//            System.out.println("<text>");
//            out.println("<sentence>");
//            System.out.println("<sentence>");
//            out.println(userSentence);
//            out.println("</sentence>");
//            out.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Sorry, cannot create file!");
//        }
//        scanner.close();
//    }

    private static void splitWords(String word) {
        String[] words = word.split(" ");
        for (String aWord : words) {
            System.out.println(aWord + ", ");
        }
    }


    private static void splitSentences(String sentence) {
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(sentence);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            System.out.println(sentence.substring(start, end));
        }

    }

    public static String sortString(String s) {

        String[] strArray = s.split("\\s+");
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            sb.append(strArray[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

}