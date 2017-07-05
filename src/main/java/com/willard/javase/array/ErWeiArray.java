package com.willard.javase.array;

public class ErWeiArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//二维数组.length 是行的长度
		String arr[][] = new String[2][4] ;
		arr[0][0] = "00" ;
		arr[0][1] = "01" ;
		arr[1][0] = "10" ;
		arr[1][1] = "11";
		
		System.out.println(arr.length);
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.println(arr[i][j]);
			}
		}
	}

}
