package nadiatests;

import java.util.Iterator;
import java.util.LinkedList;

//https://www.careercup.com/question?id=2996

public class FifthElementFromEnd {
    public static void main(String[] args) {

        LinkedList<Integer> nodes = getTestData();
        System.out.println(nodes);
        Integer element = findNthElementFromEnd(nodes, 2);
        System.out.println("element at position 2 from the end is "+element);
        Integer element2 = findNthElementFromEnd(nodes, 4);
        System.out.println("element at position 4 from the end is "+element2);
    }
    public static LinkedList<Integer> getTestData() {
        LinkedList<Integer> nodes = new LinkedList<>();
        nodes.add(1); nodes.add(2); nodes.add(3); nodes.add(4); nodes.add(2);
        nodes.add(6); nodes.add(7); nodes.add(8); nodes.add(9); nodes.add(10);
        nodes.add(11); nodes.add(12); nodes.add(13); nodes.add(14); nodes.add(15);
        return nodes;
    }
    public static Integer findNthElementFromEnd(LinkedList<Integer> linkedList, int position) {
        Iterator<Integer> iterator1 = linkedList.iterator();
        Iterator<Integer> iterator2 = linkedList.iterator();

        int counter = 0;
        // step 1 - move iterator1 n positions forward
        while (iterator1.hasNext() && counter<position) {
            counter++;
            iterator1.next();
        }
        //step 2 - continue to the end of the list
        while (iterator1.hasNext()) {
            iterator1.next();
            iterator2.next();
        }
        return iterator2.next();
    }
}
