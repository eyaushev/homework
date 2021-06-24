package main.hw5;

import java.util.*;

public class HomeWork5 {
    public <T> Collection<T> getUniqueCollection(Collection<T> collection) {
        return new HashSet<>(collection);
    }

    public <K, V> Map<V, Collection<K>> inverse(Map<K, V> map){
        Map<V, Collection<K>> result = new HashMap<>();
        Set<K> keys = map.keySet();
        for (K key: keys){
            result.put(map.get(key), Collections.singletonList(key));
        }
        return result;
    }
}
