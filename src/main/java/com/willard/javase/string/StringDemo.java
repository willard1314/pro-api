package com.willard.javase.string;

public class StringDemo {
	
//	@Test
	public static void main(String[] args) {
		String str = "TDNR,CDGT,CREL,CTOT,CPTK,CPUI,PNRR,PXNM,DAIS,TIOT,AGTN/ALON,VLNC,BOON,BISO,POIS,TISO,";
		System.out.println(str.substring(0, str.length()-1));
	    String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        System.out.println("中".hashCode());
	}

}
