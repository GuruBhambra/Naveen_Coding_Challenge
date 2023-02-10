package PracticeSelenium;

import java.util.Scanner;

public class AllAnimal extends Animal{

	public static void main(String[] args) {
		
		AllAnimal all = new AllAnimal();
		all.AnimalSound();
		all.animalColour();
		all.typeAnimal();
		
	}

	@Override
	public void AnimalSound() {
		int sum;
		int num2;
		int num;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter num1 ");
	 num	= sc.nextInt();
	System.out.println("Enter num2 ");
	num2 = sc.nextInt();
	sum =num+num2;
	System.out.println(sum);
		System.out.println("Bruno barks");
	}

	@Override
	public void typeAnimal() {
		
		System.out.println("Bruno is a dog");
	}

	@Override
	public void animalColour() {
		
		System.out.println("Bruno is golden colour");
	}

}
