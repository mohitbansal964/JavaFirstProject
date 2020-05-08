package com.sapient.tictoc;

public class TicTocRunner {

	public static void main(String[] args) {
		final TicToc tictoc = new TicToc();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					tictoc.tic();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					tictoc.toc();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}

}
