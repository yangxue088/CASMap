package com.yangxue.paradigm.cas;

import com.google.common.collect.ForwardingMap;

public abstract class CASParadigm<K, V> extends ForwardingMap<K, V> implements
		ICASParadigm<K, V> {

	protected CASParadigm() {
	}

	protected EntityEqualer<V> entityEqualer = null;

	public ICASParadigm<K, V> equaler(EntityEqualer<V> entityEqualer) {
		checkState(entityEqualer == null);

		CASParadigm<K, V> me = (CASParadigm<K, V>) this;
		me.entityEqualer = entityEqualer;
		return me;
	}

	protected EntityLoader<K, V> entityLoader = null;

	public ICASParadigm<K, V> build(EntityLoader<K, V> entityLoader) {
		checkState(entityLoader == null);

		CASParadigm<K, V> me = (CASParadigm<K, V>) this;
		me.entityLoader = entityLoader;
		return me;
	}

	protected CASListener<K, V> casListener = null;

	public ICASParadigm<K, V> listener(CASListener<K, V> casListener) {
		checkState(casListener == null);

		CASParadigm<K, V> me = (CASParadigm<K, V>) this;
		me.casListener = casListener;
		return me;
	}

	public static void checkState(boolean expression) {
		if (expression) {
			throw new IllegalStateException();
		}
	}
}
