package nadiatests;

import java.util.*;

public class FindDictionaryWords {
    public static void main(String[] args) {
        //assume all of the words and dictionary are in lower case
        String[] dictionary = {"go","dog", "baseball", "all", "call", "tall", "mall", "car",
                "top", "fall","program","gram","pro","grown","arm"};
        System.out.println("dictionary: "+dictionary);
        findMatch("all", dictionary);
        findMatch2("programmer", dictionary);
        findMatch3("log", dictionary);
        findMatch3("promise", dictionary);
        findMatch3("programmer", dictionary);
        findMatch3("pot", dictionary);
        findMatch4("programmer", dictionary);
        findMatch3("graorpm", dictionary);  //program scrambled
        findMatch3("go", dictionary);  //program scrambled

        StringTokenizer st = new StringTokenizer("this is a test");   //GOOD
        while (st.hasMoreTokens()) {
            System.out.print(st.nextToken());
        }
    }
    // all => call, fall, tall
    public static void findMatch(String word, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String s: dictionary) {
            if (s.contains(word)) {
                set.add(s);
            };
        }
        System.out.println("findMatch  " +word+": "+set);
    }
    // programmer => pro + gram + program
    // can use word.indexOf(s)
    public static void findMatch2(String word, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String s: dictionary) {
            if (word.contains(s)) {
                set.add(s);
            };
        }
        System.out.println("findMatch2  " +word+": "+set);
    }
    public static void findMatch4(String word, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String s: dictionary) {
            if (word.indexOf(s) != -1) {
                set.add(s);
            };
        }
        System.out.println("findMatch4  " +word+": "+set);
    }
    // "go" => dog, program, grown
    public static void findMatch3(String word, String[] dictionary) {
        List<String> dictionaryList = new ArrayList<String>(Arrays.asList(dictionary));
        // convert word to char array
        char[] characters = word.toCharArray();
        List<String> validWords = findMatchingWords(characters, dictionaryList);
        System.out.println("findMatch3 " +word+": "+validWords);
    }
    public static List<String> findMatchingWords(char letters[], List<String> dict){
        // count number of each character
        int[] avail = new int[26];
        for(char c : letters){
            int index = c - 'a';
            avail[index]++;
        }
        // what ever is in the dictionary word, has to appear in our target word
        List<String> result = new ArrayList();
        for(String word: dict){
            int []count = new int[26];
            boolean ok = true;
            for(char c : word.toCharArray()){
                int index = c - 'a';
                count[index]++;
                if(count[index] > avail[index]){
                    ok = false;
                    break;
                }
            }
            if(ok){
                result.add(word);
            }
        }
        return result;
    }
}
