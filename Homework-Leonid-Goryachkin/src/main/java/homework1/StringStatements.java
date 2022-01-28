package homework1;

import java.util.stream.IntStream;

public class StringStatements {

	public static void main(String[] args) {
		char[] mine = {'a', 'b', 'c'};
		String name = " Leonid Goryachkin 8529AZ ";
		//I assume concat just adds the string below to the string above
		String test = name.concat(" is cool");
		System.out.println(test);
		//This one just repeats same string n (2) times

		System.out.println(test);
		//Replaces the chosen char with a new one
		test = name.replace('i', 'o');
		System.out.println(test);
		//Simply replaces the string with different one
		test = name.replace("Leo", "A");
		System.out.println(test);
		//Dont know yet
		test = name.replaceAll("Gor", "P");
		System.out.println(test);
		//Does the same thing
		test = name.replaceFirst(name, test);
		System.out.println(test);
		//If there is a space at the beginning and ending of the string, it will remove it

		System.out.println(test);
		//This one removes space only at the beginning

		System.out.println(test);
		//This removes the one a the end

		System.out.println(test);
		//Cuts the string and gives you the result without the cut part
		test = name.substring(7);
		System.out.println(test);
		//Brings string to lower case
		test = name.toLowerCase();
		System.out.println(test);
		//I believe just a method overriding
		test = name.toString();
		System.out.println(test);
		//Brings to upper case
		test = name.toUpperCase();
		System.out.println(test);
		//Removes spaces too
		test = name.trim();
		System.out.println(test);
		//It looks like it combines all characters from char array and transform it into string
		test = name.copyValueOf(mine);
		System.out.println(test);
		//Same, but with the offset 1 and end 2
		test = name.copyValueOf(mine, 1, 2);
		System.out.println(test);
		//Dont know yet
		test = name.format(name, 2);
		System.out.println(test);
		//Weird thing
		test = name.join(name,"Again");
		System.out.println(test);
		//Just false
		test = name.valueOf(false);
		System.out.println(test);
		//May be transforms char into string
		test = name.valueOf('o');
		System.out.println(test);
		//May be transforms char array into string
		test = name.valueOf(mine);
		System.out.println(test);
		//Transforms the double into the string
		test = name.valueOf(1.22222);
		System.out.println(test+test);
		//Transforms int into string
		test = name.valueOf(9);
		System.out.println(test+test);
		//Takes single char from the string
		char hello = name.charAt(8);
		System.out.println(hello);
		//May be returns the string in numbers somehow
		IntStream hello1 = name.chars();
		System.out.println(hello1.count());
		//Counts the code of the char at the chosen position
		int w = name.codePointAt(2);
		System.out.println(w);
		//Compares 2 strings and returns it as an int???
		test = "hello";
		w = name.compareTo(test);
		System.out.println(w);
		//Tests if the string contains something in it
		boolean what = name.contains("Leo");
		System.out.println(what);
		//Tests if the string ends with something
		what = name.endsWith("AZ ");
		System.out.println(what);
		char[] okay = name.toCharArray();
		System.out.println(okay.length);
		
			
	}

}
