package com.exp.test;

public class PhoneNumberFormat {

	public static void main(String[] args) {
		String S= "0 - 22 1985--324";
		S=S.replaceAll("-","").replaceAll(" ","");
        int len = S.length();

        if(len ==0 || len ==1 || len ==2 || len ==3){
            System.out.println(S);
        }
        StringBuffer sb = new StringBuffer(S);
        int i=3;
        while(len>4){
            sb.insert(i,"-");
            len -=3;
            i +=4;
        }
        while(len==4){
            i -=1;
            sb.insert(i,"-");
            len -=2;
        }
        System.out.println(sb.toString());
        
	}

}
