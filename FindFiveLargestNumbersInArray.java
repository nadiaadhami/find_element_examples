package nadiatests;

import java.util.*;
public class FiveLargestNumbersInArray {
    static int n = 3;
    public static void main(String args[]){
        Integer[] numbers = {1,5,99,8,5,78,99,99,67,33,99,78,67,33,45,67,99,43,77,83,52};
        Integer[] numbers2 = Arrays.copyOf(numbers, numbers.length);
        Integer[] numbers3 = Arrays.copyOf(numbers, numbers.length);
        fiveLargestNumbers1(numbers, n);
        fiveLargestNumbers2(numbers2, n);
        fiveLargestNumbers3(numbers2, n);
        countNumberFrequency(numbers3, n);
    }
    public static void fiveLargestNumbers3(Integer[] array, int n) {
        System.out.println(n+" largest numbers using PQ 3");
        // GOOD
        // 1 - insert to set to remove duplicates
        Set<Integer> set = new HashSet<>(Arrays.asList(array)); //GOOD convert array to list
        // 2 - add to priority queue with reverse order flag - default sort order is in ascending order  GOOD
        PriorityQueue pq = new PriorityQueue(array.length, Collections.reverseOrder());
        pq.addAll(set);
        // 3 - poll (pop) pq to see the top elements
        for (int i=0; i<n && i<pq.size() ; i++) {
            System.out.println(pq.poll());
        }
    }
    public static void fiveLargestNumbers1(Integer[] array, int n) {
        System.out.println(n+" largest numbers using PQ");
        Set<Integer> set= new HashSet<Integer>();
        Collections.addAll(set, array);   //GOOD - remove duplicates and convert array to set
        PriorityQueue pq = new PriorityQueue(set.size(), Collections.reverseOrder());  //GOOD
        pq.addAll(set);
        System.out.println("Five largest numbers:");
        for (int i=0; i<n && i<pq.size() ; i++) {
            System.out.println(pq.poll());
        }
        // 2b - add to priority queue with no flag - default is ascending
        PriorityQueue pq2 = new PriorityQueue();
        pq2.addAll(set);
        //Collections.addAll(pq, set) ;
        System.out.println("Five smallest numbers:");
        // 3b - poll regular pq to see the smallest elements
        for (int i=0; i<n && i<pq2.size() ; i++) {
            System.out.println(pq2.poll());
        }
    }
    public static void fiveLargestNumbers2(Integer[] array, int n) {
        System.out.println(n+" largest numbers using Arrays.sort");
        // 1 - remove dup - convert array to set
        Set<Integer> set= new HashSet<Integer>();
        // option a
        Collections.addAll(set, array);
        // option b
        set = new HashSet<Integer>(Arrays.asList(array));
        // 2 - convert set to Array
        Object[] sortedArray = set.toArray();
        // 3 - sort
        Arrays.sort(sortedArray);
        // 4 - print last n elements (largest)
        for (int i=0 ; i<sortedArray.length && i<n ; i++) {
            System.out.println(sortedArray[sortedArray.length - 1 - i]);
        }
    }
    public static void countNumberFrequency(Integer[] array, int n) {
        System.out.println("countNumberFrequency using HashMap");
        // 1 - add to TreeMap with a count
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        // GOOD
        System.out.println("Keys:");
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Keys:");
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            System.out.println(key);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        System.out.println("option 1 - entrySet:");
        Iterator<Map.Entry<Integer, Integer>> iterator2 = entries.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator2.next();
            System.out.println(pair.getKey() + ":" + pair.getValue());
        }

        System.out.println("option 2 - entrySet:");
        for (Map.Entry<Integer, Integer> pair : entries) {
            System.out.println(pair.getKey() + ":" + pair.getValue());
        }
    }
}
