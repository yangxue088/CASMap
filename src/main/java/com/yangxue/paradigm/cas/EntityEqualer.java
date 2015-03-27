package com.yangxue.paradigm.cas;


public interface EntityEqualer<O> {
	
	public boolean checkEqual(O o1, O o2);
	
}
