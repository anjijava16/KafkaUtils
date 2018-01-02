package com.iws.kafka.utils;

import org.apache.kafka.common.utils.Utils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println(Utils.murmur2("anji".getBytes()));
    	
    	//2124191072
    }
}
