package com.example.java8.functionalInterface;

@FunctionalInterface
interface FunctionalInterfaceEx{
	public abstract void myMethod();
}

public class FunctionalInterfaceExample1 {
	
	public static void main(String[] args) {
		FunctionalInterfaceEx ex = new FunctionalInterfaceEx() {
			
			@Override
			public void myMethod() {
				// TODO Auto-generated method stub
				System.out.println("Hello");
			}
		};
		ex.myMethod();
	}

}
