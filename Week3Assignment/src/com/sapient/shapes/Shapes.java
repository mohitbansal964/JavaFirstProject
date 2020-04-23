package com.sapient.shapes;

class Circle {
	private int radius;
	private double area;

	Circle(int radius) {
		this.radius = radius;
	}

	public void calculateArea() {
		area = 3.14 * radius * radius;
		System.out.println("The Area of the Circle is " + area);
	}
}

class Triangle {
	private int sideLength;
	private double area;

	Triangle(int sideLength) {
		this.sideLength = sideLength;
	}

	public void calculateArea() {
		area = 0.433 * sideLength * sideLength;
		System.out.println("The Area of the Triangle is " + area);
	}
}

class Square {
	private int sideLength;
	private int area;

	Square(int sideLength) {
		this.sideLength = sideLength;
	}

	public void calculateArea() {
		area = sideLength * sideLength;
		System.out.println("The Area of the Square is " + area);
	}
}

public class Shapes {

	private static void calculateShapeArea(int numberOfSides, int sideLength) {
		if (numberOfSides == 1) {
			Circle circle = new Circle(sideLength);
			circle.calculateArea();
		} else if (numberOfSides == 3) {
			Triangle triangle = new Triangle(sideLength);
			triangle.calculateArea();
		} else if (numberOfSides == 4) {
			Square square = new Square(sideLength);
			square.calculateArea();
		} else {
			System.out.println("No Shapes Present");
		}
	}
	public static void main(String[] args) {
		int numberOfSides = 3;
		int sideLength = 12;
		calculateShapeArea(numberOfSides, sideLength);

		numberOfSides = 4;
		sideLength = 15;
		calculateShapeArea(numberOfSides, sideLength);

		numberOfSides = 5;
		sideLength = 15;
		calculateShapeArea(numberOfSides, sideLength);
	}

}
