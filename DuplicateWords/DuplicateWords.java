import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateWords
{

    public static void main(String[] args)
    {
        String inputStr;
        System.out.printf("Input Your String:");
        Scanner programInput = new Scanner(System.in);
        inputStr = programInput.nextLine();
        inputStr = inputStr.replaceAll("\\?|,|!","");
        System.out.println(inputStr);
        System.out.println("Part 1: Count Word");
        Map<String,Integer> wordCount = DuplicateWordsHead(inputStr);
        System.out.println("\nPart 2: Use TreeSet");
        TreeSetPrint(wordCount);
    }

    public static Map<String,Integer> DuplicateWordsHead(String targetStr)
    {
        String allLowerStr = targetStr.toLowerCase();
        Map<String,Integer> wordCount = new HashMap<>();
        String[] oneWord = allLowerStr.split(" ");
        for (String token:oneWord) {
            if (wordCount.containsKey(token)) {
                int currentCount = wordCount.get(token);
                wordCount.put(token, currentCount+1);
            }
            else
                wordCount.put(token, 1);
        }

        for (String displayWord:wordCount.keySet()) {
            System.out.printf("Words: %s: repeat %d times\n",displayWord,wordCount.get(displayWord));
        }

        return wordCount;
    }

    public static void TreeSetPrint(Map<String,Integer> wordCount)
    {
        Set<String> tokenSet = wordCount.keySet();
        TreeSet<String> tokenTreeSet = new TreeSet<>(tokenSet);
        Set<String> descendingWord = tokenTreeSet.descendingSet();


        for (String token:tokenTreeSet)
            System.out.printf("Words: %s: repeat %d times.\n",token,wordCount.get(token));
        
        System.out.println("\nSort words in descending order");

        for (String token:descendingWord)
            System.out.printf("Words: %s: repeat %d times.\n",token,wordCount.get(token));
    }
}