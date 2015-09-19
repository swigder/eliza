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

    /**
     * Adds a key and list value to the map to be built
     * @param key key to be added to the map, will overwrite earlier values for the same key
     * @param values list of values to be added for the key
     * @return this builder
     */
    public ScalarListMapBuilder<K, V> put(K key, List<V> values) {
        map.put(key, values);
        return this;
    }

    /**
     * Adds a key and arbitrary number of values to the map to be built
     * @param key key to be added to the map, will overwrite earlier values for the same key
     * @param values arbitrary number of values to be added to the key
     * @return this builder
     */
    public ScalarListMapBuilder<K, V> put(K key, V ... values) {
        map.put(key, Lists.newArrayList(values));
        return this;
    }

    /**
     * Builds the map
     * @return map of the keys and values provided by add(), in order of insertion
     */
    public Map<K, List<V>> build() {
        return map;
    }
}
