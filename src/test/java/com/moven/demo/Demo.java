package com.moven.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moven.common.utils.PropUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:conf/spring/spring-context.xml" })
public class Demo {
	@Test
	public void test() {
		long startTime = System.currentTimeMillis();
		long startNum = 1609010001;
		long endNum = 1609019999;
		List<Long> cardNums = new ArrayList<Long>();
		for (long index = startNum; index <= endNum; index++) {
			cardNums.add(index);
		}
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000);
	}
	
	@Test
	public void test1(){
		System.out.println(PropUtil.getPropValue("mybatis", "jdbc.url"));
	}
}
