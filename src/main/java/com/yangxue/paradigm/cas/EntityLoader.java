package com.yangxue.paradigm.cas;

import java.util.Map;

public interface EntityLoader<K, V> {

	public Map<K, V> loadAll();

	public V load(K k);
}
