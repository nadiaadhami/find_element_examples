package nadiatests;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.util.Arrays;

/*
  Find Largest and Smallest Number in an Array Example
  This Java Example shows how to find largest and smallest number in an
  array.
*/
public class FindLargestSmallestNumbersInArray {

    public static void main(String[] args) {

        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};

        //assign first element of an array to largest and smallest
        int smallest = numbers[0];
        int largest = numbers[0];
        for(int i=1; i< numbers.length; i++)
        {
            if(numbers[i] > largest)
                largest = numbers[i];
            else if (numbers[i] < smallest)
                smallest = numbers[i];
        }
        System.out.println("Largest Number is : " + largest);
        System.out.println("Smallest Number is : " + smallest);
        Arrays.sort(numbers);
        System.out.println("Largest Number is : " + numbers[numbers.length-1]);
        System.out.println("Smallest Number is : " + numbers[0]);

        // can not convert array of primitive types to List because asList does not to autoboxing,
        // we can convert array of objects to list
        String[] names = new String[]{"John", "Amy", "Matt","Tony","John"};
        List<String> lst = Arrays.asList(names);
        System.out.println("min:"+ Collections.min(lst));
        System.out.println("max:"+ Collections.max(lst));
        System.out.println("frequency:"+ Collections.frequency(lst, "John"));

    }

}