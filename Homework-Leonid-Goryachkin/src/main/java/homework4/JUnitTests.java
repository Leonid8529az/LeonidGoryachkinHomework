package homework4;



import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JUnitTests {
    @Test
    public void test1() {
        int first = 10;
        int second = 20;
        int total = first+second;
        int actual = 35;
        try {
            Assert.assertEquals(total, actual);
            System.out.println("Test 1 passed");
        } catch (Exception e) {
            Assert.fail("Test 1 failed");
        }

    }
    @Test
    public void test2() {
        int root = 256;
        int sqrt = 4;
        double tester1 = Math.sqrt(root);
        double  tester2 = Math.pow(sqrt, 2);

        try {
            Assert.assertEquals(tester1, tester2, 16);
            System.out.println("Test 2 passed");
        } catch (Exception e) {
            Assert.fail("Test 2 failed");
        }

    }
    @Test
    public void test3() {
        String theBigString = "Walmart";
        String anotherOne = "Walgreens";

        try {
            Assert.assertTrue(theBigString.contains(anotherOne.substring(0,3)));
            System.out.println("Test 3 passed");
        } catch (Exception e ) {
            Assert.fail("Test 3 failed");
        }
    }
    @Test
    public void test4() {
        String country1 = "Canada";
        String country2 = "Denmark";

        try {
            Assert.assertTrue(country1.contains(country2.substring(0,4)));
            System.out.println("Test 4 passed");
        } catch (Exception e) {
            Assert.fail("Test 4 failed");
        }
    }
    @Test
    public void test5() {
        List<Integer> listOfIntegers = new ArrayList<Integer>();
        listOfIntegers.add(0);
        listOfIntegers.add(6);
        listOfIntegers.add(2);
        listOfIntegers.add(8);
        listOfIntegers.add(9);
        boolean valueOfOdd = false;
        for (int i = 0; i<listOfIntegers.size(); i++) {
            if (listOfIntegers.get(i)%2!=0) {
                valueOfOdd = true;
            }
        }
        try {
            Assert.assertTrue(valueOfOdd);
            System.out.println("Test 5 passed") ;
        } catch (Exception e) {
            Assert.fail("Test 5 failed");
        }
    }
    @Test
    public void test6() {
        String name = "Josh";
        List<String> listOfNames = new ArrayList<>();
        listOfNames.add("Robert");
        listOfNames.add("Alex");
        listOfNames.add("Josh");
        listOfNames.add("Mike");
        listOfNames.add("Steve");

        try {
            Assert.assertTrue(listOfNames.contains(name));
            System.out.println("Test 6 passed");

        } catch (Exception e) {
            Assert.fail("Test 6 failed");
        }
    }
    @Test
    public void test7() {
        String carName = "Toyota";
        List<String> cars = new ArrayList<String>();
        cars.add("Audi");
        cars.add("Volvo");
        cars.add("Kia");
        cars.add("Tesla");

        try {
            Assert.assertEquals(cars.get(2), carName);
            System.out.println("Test 7 passed");
        } catch (Exception e) {
            Assert.fail("Test 7 failed");
        }
    }
    @Test
    public void test8() {
        Map<String, Integer> incredibleMap = new LinkedHashMap<String, Integer>();
        incredibleMap.put("Zero", 0);
        incredibleMap.put("One", 1);
        incredibleMap.put("Two", 2);
        incredibleMap.put("Three", 3);
        incredibleMap.put("Four", 4);

        try {
            Assert.assertTrue(incredibleMap.containsValue(4));
            System.out.println("Test 8 passed");

        } catch (Exception e){
            Assert.fail("Test 8 failed");
        }
    }
    @Test
    public void test9() {
        Map<String, String> weather = new LinkedHashMap<String, String>();
        weather.put("Monday", "Sunny");
        weather.put("Tuesday", "Rain");
        weather.put("Wednesday", "Cloudy");
        weather.put("Thursday", "Windy");
        weather.put("Friday", "Sunny");

        try {
            Assert.assertEquals(weather.get("Monday"),weather.get("Friday"));
            System.out.println("Test 9 passed");

        } catch (Exception e) {
            Assert.fail("Test 9 failed");
        }
    }
    @Test
    public void test10() {
        Map<Character, String> chemicalElements = new LinkedHashMap<Character, String>();
        chemicalElements.put('H', "Hydrogen");
        chemicalElements.put('S', "Sulfur");
        chemicalElements.put('O', "Oxygen");
        chemicalElements.put('H', "Hydrogen");
        chemicalElements.put('P', "Phosphorus");

        try {
            Assert.assertFalse(chemicalElements.containsValue("Flourine"));
            System.out.println("Test 10 passed");
        } catch (Exception e) {
            Assert.fail("Test 10 failed");
        }
    }



}