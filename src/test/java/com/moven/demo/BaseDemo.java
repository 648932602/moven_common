package com.moven.demo;

import com.moven.common.cache.JedisUtil;

public class BaseDemo {
	public static void main(String[] args) {
		JedisUtil.set("a", 1);
		System.out.println(JedisUtil.get("a"));
	}
}
