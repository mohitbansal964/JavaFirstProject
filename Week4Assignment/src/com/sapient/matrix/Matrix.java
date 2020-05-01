package com.sapient.matrix;

import java.util.Scanner;

public class Matrix {
	private int row, col;
	private int[][] mat;

	public Matrix() {
		this.row = this.col = 3;
		this.mat = new int[this.row][this.col];
	}

	public Matrix(int row, int col) {
		this.row = row;
		this.col = col;
		this.mat = new int[row][col];
	}

	public Matrix(int[][] mat) {
		this.row = mat.length;
		this.col = mat[0].length;
		this.mat = mat.clone();
		for(int i=0; i<row; i++) {
			this.mat[i] = mat[i].clone();
		}

	}

	public Matrix(Matrix that) {
		this.row = that.row;
		this.col = that.col;
		this.mat = that.mat.clone();
		for (int i = 0; i < row; i++) {
			this.mat[i] = that.mat[i].clone();
		}
	}

	public void readMatrix() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter numbers:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				mat[i][j] = scan.nextInt();
			}

		}
		scan.close();
	}

	public void display() {
		System.out.println("Displaying Numbers: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean checkScalar() {
		int val = mat[0][0];
		for(int i=0; i<row; i++) {

			for(int j=0; j<col; j++) {
				if (i != j && mat[i][j] != 0) {
					return false;
				} else if (i == j && mat[i][i] != val) {
					return false;
				}
			}
		}
		return true;
	}

	public Matrix add(Matrix that) {
		Matrix addMat = new Matrix(this.row, this.col);
		if (row != that.row) {
			return addMat;
		} else if (col != that.col) {
			return addMat;
		}
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				addMat.mat[i][j] = this.mat[i][j] + that.mat[i][j];
			}
		}
		return addMat;
	}

	public Matrix multiply(Matrix that) {
		Matrix mulMat = new Matrix(this.row, that.col);
		if (col != that.row) {
			return mulMat;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < that.col; j++) {
				for (int k = 0; k < col; k++) {
					mulMat.mat[i][j] += this.mat[i][k] * that.mat[k][j];
				}

			}
		}
		return mulMat;
	}

}
