package com.yangxue.paradigm.cas;

public interface ICASParadigm<K,V> {

	public ICASParadigm<K, V> build(EntityLoader<K, V> entityLoader);
	
	public ICASParadigm<K, V> equaler(EntityEqualer<V> entityEqualer);
	
	public ICASParadigm<K, V> listener(CASListener<K, V> casListener);
}
