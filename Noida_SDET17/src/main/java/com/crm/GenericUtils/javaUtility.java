package com.crm.GenericUtils;

import java.util.Random;


/**
 * this class contains java specific generic properties
 * @author arpita
 *
 */

public class javaUtility {
	
	/**
	 * generic random number
	 * @return
	 */
	
	public static String getRandomData() {
		
		Random r=new Random();
		int ran=r.nextInt(1000);
		return "_"+ran;
		
	
	}
		
	
		
	

}
 