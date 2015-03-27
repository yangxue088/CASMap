package com.yangxue.paradigm.cas;

import java.util.Map;

public class CASMap<K, V> extends CASParadigm<K, V> {

	protected CASMap() {
	}

	protected CASMap<K, V> wrap(Map<K, V> map) {
		checkState(map == null);
		this.map = map;
		return this;
	}

	private Map<K, V> map = null;

	@Override
	protected Map<K, V> delegate() {
		return map;
	}

	@Override
	public V put(K key, V value) {
		V ov = delegate().put(key, value);

		if (ov == null) {
			if (this.casListener != null) {
				this.casListener.onAddition(key, value);
			}
		} else {
			boolean equal = false;
			if (this.entityEqualer != null) {
				equal = this.entityEqualer.checkEqual(value, ov);
			} else {
				equal = ov.equals(value);
			}

			if (!equal) {
				if (this.casListener != null) {
					this.casListener.onReplace(key, value, ov);
				}
			} else {
				if (this.casListener != null) {
					this.casListener.onEqual(key, value);
				}
			}
		}

		return ov;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public V remove(Object key) {
		V ov = delegate().remove(key);

		if (ov != null) {
			if (this.casListener != null) {
				this.casListener.onRemoval((K) key, ov);
			}
		}

		return ov;
	}

	@Override
	public void clear() {
		for (K key : delegate().keySet()) {
			remove(key);
		}
	}

}
