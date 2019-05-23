package com.java.classic;

public class PrintScreenCalc {
	
	//결합도를 낮추기 위해서 주입해서 사용하도록 set메소드 만들었음.
	private Calculator calc;
	public void setCalc(Calculator calc) {
		this.calc = calc;
	}
	
	public void printSum(int a, int b) {
		
		System.out.println(calc.sum(a, b));
	}
	
	public void printSub(int a, int b) {
		
		System.out.println(calc.sub(a, b));
	}
	
	public void printMulti(int a, int b) {
		
		System.out.println(calc.multi(a, b));
	}
	
	public void printDiv(int a, int b) {
		
		System.out.println(calc.div(a, b));
	}
	
	public void printSum(float a, float b) {
		FloatCalculator fCalc = (FloatCalculator) calc;
		
		System.out.println(fCalc.sum(a, b));
	}
	
	public void printSub(float a, float b) {
		FloatCalculator fCalc = (FloatCalculator) calc;
		
		System.out.println(fCalc.sub(a, b));
	}
	
	public void printMulti(float a, float b) {
		FloatCalculator fCalc = (FloatCalculator) calc;
		
		System.out.println(fCalc.multi(a, b));
	}
	
	public void printDiv(float a, float b) {
		FloatCalculator fCalc = (FloatCalculator) calc;
		
		System.out.println(fCalc.div(a, b));
	}
}
