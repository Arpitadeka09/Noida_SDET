package com.crm.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtility {
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream file=new FileInputStream("./Data/commondata.properties");
		Properties p=new Properties();
		p.load(file);
		return p.getProperty(key);
	}

}
