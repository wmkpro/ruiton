package com.ruiton;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ruiton.utils.MD5Util;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void getMD5(){
		System.out.println(MD5Util.getMD5("123456"));
	}
}
