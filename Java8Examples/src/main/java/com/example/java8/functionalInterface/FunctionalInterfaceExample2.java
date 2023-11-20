package com.example.java8.functionalInterface;

@FunctionalInterface
interface FunctionalInterfaceEx2{
	public abstract void myNewMethod();
}

public class FunctionalInterfaceExample2 {
	
	public static void main(String[] args) {
		
		FunctionalInterfaceEx2 example2 = () -> {
			System.out.println("Hello People");
	};
	
	
	example2.myNewMethod();
		
	}

}
