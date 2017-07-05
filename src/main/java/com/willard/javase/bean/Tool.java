package com.willard.javase.bean;

public class Tool<Q> {
	private Q q;

	public Q getObj() {
		return q;
	}

	public void setObj(Q q) {
		this.q = q;
	}
	
	public<T> void show(T t) {				//���������������ķ���һ��
		System.out.println(t);				//�����һ��,��Ҫ�ڷ����������÷���
	}
	
	public static<W> void print(W w) {		//��̬�������������Լ��ķ���
		System.out.println(w);
	}
	
}
