package code401Challenges.repeatedword;

import java.util.HashSet;

public class RepeatedWord {
    public static String repeatedWord(String str) {
        // split string into words
        String[] words = str.split("\\W+");
        // HashSet to store words
        HashSet<String> wordTable = new HashSet<>();
        for(String word : words) {
            //check if word in table
            if(wordTable.contains(word)) return word;
            else {
                // add to table if not
                wordTable.add(word);
            }
        }
        return null;
    }
}
