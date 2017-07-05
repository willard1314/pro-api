package com.willard.javase.thread;

/**
 * <p>Title: ThreadLocalExample </p>
 * <p>Description: 下面的例子创建了一个MyRunnable实例，并将该实例作为参数传递给两个线程。
 * 两个线程分别执行run()方法，并且都在ThreadLocal实例上保存了不同的值。
 * 如果它们访问的不是，ThreadLocal对象修饰的，则第二个线程会覆盖掉第一个线程设置的值。
 * 但是，由于它们访问的是一个ThreadLocal对象，因此这两个线程都无法看到对方保存的值。也就是说，它们存取的是两个不同的值。</p>
 * Date: 2017年7月5日下午10:11:28
 * @author zl
 * @version 1.0 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月5日           zl        创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        @SuppressWarnings("rawtypes")
		private ThreadLocal threadLocal = new ThreadLocal();
        private MyBean01 mb = new MyBean01();

        @SuppressWarnings("unchecked")
		@Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            mb.setAge((int) (Math.random() * 100D));
            try {
            Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.out.println(threadLocal.get());
            System.out.println("age:"+mb.getAge());
        }
    }

    public static void main(String[] args) {
         MyRunnable sharedRunnableInstance = new MyRunnable();
         Thread thread1 = new Thread(sharedRunnableInstance);
         Thread thread2 = new Thread(sharedRunnableInstance);
         thread1.start();
         thread2.start();
    }

}



class MyBean01{
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}