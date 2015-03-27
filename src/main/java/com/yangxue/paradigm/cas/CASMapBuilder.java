package com.yangxue.paradigm.cas;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CASMapBuilder<K, V> implements ICASParadigm<K, V> {

	private CASMap<K, V> casMap = null;

	public static <K, V> CASMapBuilder<K, V> newBuilder() {
		CASMapBuilder<K, V> builder = new CASMapBuilder<K, V>();
		builder.casMap = new CASMap<K, V>();
		return builder;
	}

	public CASMap<K, V> build() {
		this.casMap.wrap(new ConcurrentHashMap<K, V>());
		return this.casMap;
	}

	public CASMap<K, V> build(Map<K, V> map) {
		this.casMap.wrap(map);
		return this.casMap;
	}

	@Override
	public CASMapBuilder<K, V> build(EntityLoader<K, V> entityLoader) {
		this.casMap.build(entityLoader);
		return this;
	}

	@Override
	public CASMapBuilder<K, V> equaler(EntityEqualer<V> entityEqualer) {
		this.casMap.equaler(entityEqualer);
		return this;
	}

	@Override
	public CASMapBuilder<K, V> listener(CASListener<K, V> casListener) {
		this.casMap.listener(casListener);
		return this;
	}

}
