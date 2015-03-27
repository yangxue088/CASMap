package com.yangxue.paradigm.cas;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.Maps;
import com.yangxue.paradigm.cas.CASListener;
import com.yangxue.paradigm.cas.CASMap;
import com.yangxue.paradigm.cas.CASMapBuilder;

public class test {
	public static void main(String[] args) {
		CASMap<String, String> casMap = CASMapBuilder
				.<String, String> newBuilder()
				.listener(new CASListener<String, String>() {

					@Override
					public void onAddition(String k, String v) {
						System.out.println(String
								.format("addition %s=%s", k, v));
					}

					@Override
					public void onRemoval(String k, String v) {
						System.out.println(String.format("removal %s=%s", k, v));
					}

					@Override
					public void onReplace(String k, String v, String ov) {
						System.out.println(String.format("replace %s=%s(%s)",
								k, v, ov));
					}

					@Override
					public void onEqual(String k, String v) {
						System.out.println(String.format("equal %s=%s", k, v));

					}

				}).build();

//		casMap.put("1", "1");
//		casMap.put("1", "1");
//		casMap.put("1", "2");
//		casMap.remove("1");

		Random random = new Random();
		Map<String, String> map = Maps.newHashMap();
		for (int i = 0; i < 100; ++i) {
			casMap.put("" + random.nextInt(100), "" + random.nextInt(100));
			map.put("" + random.nextInt(100), "" + random.nextInt(100));
		}

		System.out.println("----------------------------");
		casMap.putAll(map);
		
		System.out.println("+++++++++++++++++++++++++++++");
		casMap.clear();
	}
}
