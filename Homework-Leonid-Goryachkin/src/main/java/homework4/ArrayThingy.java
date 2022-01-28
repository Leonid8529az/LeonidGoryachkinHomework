package homework4;

import sun.awt.image.ImageWatched;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import java.sql.SQLOutput;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayThingy {
    public static void main(String[] args) {
        int[] array1 = {1,3,2,4,8,9,0};
        int[] array2 = {1,3,7,5,4,0,7,5};

        Set<Integer> newSet = new LinkedHashSet<Integer>();

        Set<Integer> overSet = new LinkedHashSet<Integer>();
        Set<Integer> overSetTwo = new LinkedHashSet<Integer>();

        for (int i = 0; i < array1.length; i++) {
            overSet.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            overSetTwo.add(array2[i]);
        }

        System.out.println(overSet);
        System.out.println(overSetTwo);
        System.out.println("------------------------------------");
        System.out.println("This is union of two arrays: ");
        twoArraysUnion(array1, array2);
        System.out.println("------------------------------------");
        System.out.println("This is intersection of two arrays: ");
        letsMakeAnIntersection(array1, array2);
        System.out.println("------------------------------------");
        System.out.println("This is symmetric difference of two arrays: ");
        symmetricDifferenceWow(array1, array2);


    }
    public static void twoArraysUnion (int[] first, int[] second) {
        Set<Integer> union = new LinkedHashSet<Integer>();
        for (int i = 0; i <first.length; i++) {
            union.add(first[i]);
        }
        for (int i = 0; i<second.length; i++) {
            union.add(second[i]);
        }
        System.out.println(union);
    }
    public static void letsMakeAnIntersection (int[] anotherOne, int[] andAnotherOne) {
        Set<Integer> theOneToBeReturned = new LinkedHashSet<Integer>();

        for (int i = 0; i<anotherOne.length; i++) {
            for (int j = 0; j<andAnotherOne.length; j++) {
                if (anotherOne[i] == andAnotherOne[j]) {
                    theOneToBeReturned.add(anotherOne[i]);
                }
            }
        }
        System.out.println(theOneToBeReturned);
    }
    public static void symmetricDifferenceWow (int[] storedValue, int[] cupOfCoffee) {
        Set<Integer> theDifferentOne = new LinkedHashSet<Integer>();
        for (int k = 0; k<storedValue.length; k++) {
            theDifferentOne.add(storedValue[k]);
        }
        for (int op = 0; op<cupOfCoffee.length; op++) {
            theDifferentOne.add(cupOfCoffee[op]);
        }

        for (int i = 0; i<storedValue.length; i++) {
            for (int j = 0; j<cupOfCoffee.length; j++) {
                if (storedValue[i] == cupOfCoffee[j]) {
                    theDifferentOne.remove(storedValue[i]);
                }
            }
        }
        System.out.println(theDifferentOne);


    }

}