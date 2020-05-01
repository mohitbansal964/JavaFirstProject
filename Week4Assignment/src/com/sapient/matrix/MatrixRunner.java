package com.sapient.matrix;

public class MatrixRunner {

	public static void main(String[] args) {
		int[][] mat1 = { { 11, 24, 3 }, { 57, 1, 0 }, { 14, 5, 57 } };
		int[][] mat2 = { { 17, 21, 23 }, { 40, 15, 7 }, { 0, 18, 25 } };
		int[][] mat3 = { { 2, 0, 0 }, { 0, 2, 0 }, { 0, 0, 2 } };
		Matrix matrix1 = new Matrix(mat1);
		//		matrix1.readMatrix();
		System.out.println("Matrix 1:");
		matrix1.display();
		System.out.println("Scalar = " + matrix1.checkScalar());

		Matrix matrix2 = new Matrix(mat2);

		System.out.println("\nMatrix 2:");
		matrix2.display();

		Matrix addMatrix = matrix1.add(matrix2);
		System.out.println("\nAdd Matrix: ");
		addMatrix.display();

		Matrix mulMatrix = matrix1.multiply(matrix2);
		System.out.println("\nMultiply Matrix: ");
		mulMatrix.display();




	}

}
