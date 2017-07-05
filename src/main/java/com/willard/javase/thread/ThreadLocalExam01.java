package com.willard.javase.thread;

public class ThreadLocalExam01 {
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread (mr);
		Thread t2 = new Thread(mr);
		t1.start();
		t2.start();
	}
	
	static class MyRunnable implements Runnable{
		MyBean mb  = new MyBean();
		@Override
		public void run() {
			mb.setAge((int)(Math.random()*100D));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(mb.getAge());
		}
		
	}
}


class MyBean{
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}