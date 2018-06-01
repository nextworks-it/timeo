/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
/*
 * Copyright © 2015 Nextworks s.r.l. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra;

import java.util.*;

/**
 * A map which exposes a method to pull out the (one of the) key-value pair with the smallest value.
 *
 * The map is ordered according to a comparator provided at class creation time.
 * This kind of map does not accept null values, and throws IllegalArgumentException
 * if one is given as argument to the put method.
 *
 * @param <K> key type
 * @param <V> value type
 */
public class MapByValue<K, V> implements Map<K, V> {

    private Map<K, V> map = new HashMap<>();

    private NavigableMap<V, Set<K>> reverseMap;

    public MapByValue() {this.reverseMap = new TreeMap<>();}

    public MapByValue(Comparator<V> comparator){this.reverseMap = new TreeMap<>(comparator);}

    /**
     * Adds a new entry to the map.
     *
     * @param k The key of the entry
     * @param v The value associated with the key. Must not be null.
     * @return The previous element associated with the key, or null if
     * there was no entry with that key.
     *
     * @throws NullPointerException if the provided value is null.
     * @throws ClassCastException if either key or value cannot be cast to
     * the appropriate classes.
     */

    @Override
    public V put(K k, V v){

        //Null check on value
        if (v == null)
            throw new NullPointerException("Key " + k.toString() + "provided with null value");

        //Put into main map
        V outValue = map.put(k, v);

        //Remove old value from reverse map
        if (outValue != null) {
            reverseMap.get(outValue).remove(k);
            if (reverseMap.get(outValue).isEmpty()) reverseMap.remove(outValue);
        }
        reverseMap.putIfAbsent(v, new HashSet<>());
        reverseMap.get(v).add(k);

        return outValue;
    }

    /**
     * Removes and returns one of the pairs with the lowest value.
     *
     * @return A key value pair such that value is the minimum of map.values()
     */

    public Map.Entry<K, V> poll() {

        //aux is a pair (minimum value, set of its keys)
        Map.Entry<V, Set<K>> aux = reverseMap.firstEntry();

        if (aux == null) return null;

        //The pair which will be returned
        Iterator<K> iterator = aux.getValue().iterator();
        K outKey = iterator.next();
        iterator.remove();

        V outValue = aux.getKey();

        if (aux.getValue().isEmpty()) {
            reverseMap.remove(outValue);
            // Remove the stale entry from reverse map
        }

        //Removing the pair from non-reversed map
        map.remove(outKey, outValue);

        return new AbstractMap.SimpleEntry<>(outKey, outValue);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        //noinspection SuspiciousMethodCalls
        return reverseMap.containsKey(o);
    }

    @Override
    public V get(Object o) {
        return map.get(o);
    }

    @Override
    public V remove(Object o) {
        @SuppressWarnings("unchecked")
        K k = (K) o;
        V v = map.get(k);

        if (v == null) return null; //No mapping
        else {
            internalRemove(k, v);
            return v;
        }
    }

    /*
    * k and v _must_ be an actual entry of the map.
    */
    private void internalRemove(K k, V v){

        if (!map.remove(k,v))
            throw new IllegalStateException("Something messed up the state of the map.");

        if (!reverseMap.get(v).remove(k))
            throw new IllegalStateException("Something messed up the state of the map.");

        if (reverseMap.get(v).isEmpty()) reverseMap.remove(v);
    }

    @Override
    public void putAll(Map<? extends K,? extends V> map) {
        for (Entry<? extends K, ? extends V> entry : map.entrySet()){
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        map.clear();
        reverseMap.clear();
    }

    @Override
    public Set<K> keySet() {
        //Usually it would support removal. Needs more work to be done.
        // TODO support removal to respect MAP contract
        return Collections.unmodifiableSet(map.keySet());
    }

    @Override
    public Collection<V> values() {
        // TODO support removal to respect MAP contract
        return Collections.unmodifiableCollection(map.values());
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        // TODO support removal to respect MAP contract
        return Collections.unmodifiableSet(map.entrySet());
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
