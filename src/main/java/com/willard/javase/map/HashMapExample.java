package com.willard.javase.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * HashMap���ʹ��˵��
 * @author zl
 *
 */
public class HashMapExample {
	
	/**
	 * ���̻߳�����cpu��ﵽ100%
	 * @throws InterruptedException
	 */
	private static void hashMapThreadExcep() throws InterruptedException{
		final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
 
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                        	String key = UUID.randomUUID().toString();
                            map.put(key, "");
                            System.out.println("ִ����"+map.get(key));
                        }
 
                    }, "ftf" + i).start();
 
                }
 
            }
      }, "ftf");
        t.start();
        t.join();
	}


	/**
	 * ��ȡkey��Ӧ��hashֵ
	 */
	public static void getHashCode(String key){
		System.out.println(key.hashCode());
	}
	
	public static void sameHashCode(){
		String a = new String("abc");
		String b = new String("abc");
		//��ab�洢��hashMap��
//		HashMap<String, String> hash = new HashMap<String,String>();
//		hash.put(key, value);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//hashMapThreadExcep();
        //�õ�key��hashֵ
		getHashCode("12");
		
		
		
	}

}
