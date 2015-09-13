package com.swigder.nlp.eliza.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class to make it neater to build complex data structures (in this case, Map<K, List<V>>).
 * Maintains order of insertion.
 */
public class ScalarListMapBuilder<K, V> {
    LinkedHashMap<K, List<V>> map = Maps.newLinkedHashMap();

    public ScalarListMapBuilder<K, V> put(K key, List<V> values) {
        map.put(key, values);
        return this;
    }

    public ScalarListMapBuilder<K, V> put(K key, V ... values) {
        map.put(key, Lists.newArrayList(values));
        return this;
    }

    public Map<K, List<V>> build() {
        return map;
    }
}
