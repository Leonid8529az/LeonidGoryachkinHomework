package homework4;

import java.util.*;

public class MapsThree {
    public static void main(String[] args) {
        List<String> metals = new ArrayList<String>();
        metals.add("Li");
        metals.add("Na");
        metals.add("Ca");
        metals.add("Fe");

        List<String> nonmetals = new ArrayList<String>();
        nonmetals.add("S");
        nonmetals.add("Cl");
        nonmetals.add("C");
        nonmetals.add("P");

        List<String> nobleGases = new ArrayList<String>();
        nobleGases.add("He");
        nobleGases.add("Ne");
        nobleGases.add("Ar");
        nobleGases.add("Kr");

        Map<String, List<String>> pereodicTable = new LinkedHashMap<String, List<String>>();
        pereodicTable.put("Metals", metals);
        pereodicTable.put("Nonmetal", nonmetals);
        pereodicTable.put("Noble Gases", nobleGases);

        List<Integer> odd = new ArrayList<Integer>();
        odd.add(1);
        odd.add(3);
        odd.add(5);
        odd.add(7);

        List<Integer> even = new ArrayList<Integer>();
        even.add(2);
        even.add(4);
        even.add(6);
        even.add(8);

        List<Integer> negativeOdd = new ArrayList<Integer>();
        negativeOdd.add(-3);
        negativeOdd.add(-7);
        negativeOdd.add(-11);
        negativeOdd.add(-13);

        List<Integer> negativeEven = new ArrayList<Integer>();
        negativeEven.add(-2);
        negativeEven.add(-6);
        negativeEven.add(-8);
        negativeEven.add(-10);

        Map<String, List<Integer>> numbers = new LinkedHashMap<String, List<Integer>>();
        numbers.put("Odd", odd);
        numbers.put("Even", even);
        numbers.put("Negative Odd", negativeOdd);
        numbers.put("Negative Even", negativeEven);

        List<String> mainDish = new ArrayList<String>();
        mainDish.add("Steak");
        mainDish.add("Pasta");
        mainDish.add("Seafood");
        mainDish.add("Chicken");

        List<String> dessert = new ArrayList<String>();
        dessert.add("Cheesecake");
        dessert.add("Ice cream");
        dessert.add("White chocolate");
        dessert.add("Yogurt");

        List<String> drinks = new ArrayList<String>();
        drinks.add("Water");
        drinks.add("Coffee");
        drinks.add("Soda");
        drinks.add("Juice");

        Map<String, List<String>> restaurant = new LinkedHashMap<String, List<String>>();
        restaurant.put("Main course", mainDish);
        restaurant.put("Dessert", dessert);
        restaurant.put("Drinks", drinks);

        for (Map.Entry entry: pereodicTable.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("---------------------------------------------");

        for (Map.Entry entry: numbers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("---------------------------------------------");

        for (Map.Entry entry: restaurant.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("---------------------------------------------");
    }
}
