package com.sapient.tictoc;


public class TicToc {
	public void tic() throws InterruptedException {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Tic");
				wait();
				notify();
			}
		}
	}

	public void toc() throws InterruptedException {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Toc");
				notify();
				wait();
			}
		}
	}

}
