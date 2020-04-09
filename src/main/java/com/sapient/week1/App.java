package com.sapient.week1;

import com.sapient.week1.CheckEven;

public class App 
{
    public static void main( String[] args )
    {
    	CheckEven checkEven = new CheckEven();
    	int number1 = 6;
    	if(checkEven.check(number1)){
    		System.out.println("Number is even");
    	}else{
    		System.out.println("Number is odd");
    	}
    }
}
