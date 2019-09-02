package nadiatests;

import java.util.*;

public class FindMaxFrequency {

    public static void main(String[] args) {
        int maxFrequency = 0;
        String maxWord = "";
        String[] words = {"one", "two", "three", "one", "one", "four", "two","two","two"};
        List<String> arrayList2 = Arrays.asList(words); //can convert array of objects to list (not primitive types)
        System.out.println(arrayList2);

        // GOOD - convert to arrayList so we can use collection methods
        // one step:  List<String> arrayList = Arrays.asList(words);
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(words));
        // option 1 - count frequencies and keep track of the highest frequency as you insert to map
        Map< String, Integer> map = new HashMap<>();
        for (String word : arrayList) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count+1);
                if (count+1>maxFrequency) {
                    maxFrequency = count+1;
                    maxWord = word;
                }
            } else {
                map.put(word,1);
            }
        }
        System.out.println(map);
        System.out.println("maxWord:"+maxWord+" maxFrequency="+maxFrequency);

        // option 2
        ArrayList<Integer> frequencies = new ArrayList<Integer>();
        /* get the frequency of all words and put all frequencies into an array called frequencies */
        for (int i = 0; i < arrayList.size(); i++) {
            // get the frequency of each word for each position
            // i=0 arrayList[0]=one frequency = 3
            // Collections.frequency(arrayList, arrayList.get(i)) => frequency of arrayList.get(i)
            frequencies.add(Collections.frequency(arrayList, arrayList.get(i)));
        }
        System.out.println("frequencies = "+frequencies);
        //find max frequency
        maxFrequency = Collections.max(frequencies);
        System.out.println("max frequency="+maxFrequency); // 4
        // get the index of the most frequent word
        int index = frequencies.indexOf(maxFrequency);
        System.out.println("index of max frequency="+index);  //1

        System.out.print("element at this position="+arrayList.get(index));   //2
    }
}
