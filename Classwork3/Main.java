package Classwork3;

public class Main {

	public static void main(String[] args) {
		String name = "John Doey";
		Pair<String, Integer> person = new Pair<>(name, 32);
		System.out.println(name.hashCode());//this is calc for each diff string
		System.out.println(person.hashCode());//this is mem location, does not really change

	}

}
//1023487453
