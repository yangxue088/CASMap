package com.yangxue.paradigm.cas;

public interface CASListener<K, V> {

	public void onAddition(K k, V v);

	public void onEqual(K k, V v);

	public void onReplace(K k, V v, V ov);

	public void onRemoval(K k, V v);
}
