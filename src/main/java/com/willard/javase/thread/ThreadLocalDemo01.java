package com.willard.javase.thread;

public class ThreadLocalDemo01 {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLocalD td = new ThreadLocalD();
		Thread t = new Thread(td);
		Thread t1 = new Thread(td);
		t.start();
		t1.start();
		
		
	}

}

class ThreadLocalD implements Runnable{
	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 10 ;
		}
	};
	
	@Override
	public void run() {
		while(true){
			if(tl.get()==0){
			System.out.println("线程【"+Thread.currentThread().getName()+"】10个任务取完了：");
			break ;
			}
			System.out.println("当前线程"+Thread.currentThread().getName()+"取了第"+tl.get()+"个");
			tl.set(tl.get()-1);
		}
	}
	
}