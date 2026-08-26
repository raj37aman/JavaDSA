package dsa.ds.collectionFramework.map;

import java.util.*;

public class LearnMap {

    public static void main(String[] args) {

        System.out.println("!!! Learn Map !!!");

        /*
        * Map does not implement Collection over it.
        * Stores data in Key-Value pair.
            keys should be unique.
            values can be duplicate.
        * HashMap has time complexity = O(1) of its methods, as it uses Hash.
        * LinkedHashMap has time complexity = O(n) for some of its methods, & constant for some.
        * TreeMap has time complexity = O(log n) for its methods.
        */

        Map<String, String> map = new HashMap<>();

        map.put("in", "India");
        map.put("in", "INDIA");// duplicate keys not allowed // replace value if key already present

        map.putIfAbsent("in", "IN");// put only if key not present // if key already present then it will neither add nor replace

        map.put("ind", "India");
        map.put("us", "United States");
        map.put("usa", "United States of America");
        map.put("np", "Nepal");
        map.put("sl", "Sri Lanka");

        System.out.println("map: " + map);

        System.out.println("map.containsKey(\"in\"): " + map.containsKey("in"));// return boolean if key is present
        System.out.println("map.containsValue(\"India\"): " + map.containsValue("India"));// return boolean if value is present

        System.out.println("map.get(\"in\"): " + map.get("in"));// get value of key // return null if key not present
        System.out.println("map.getOrDefault(\"ussr\", \"Russia\"): " + map.getOrDefault("ussr", "Russia"));// get value of key // return default if key not present

        map.replace("inaaa", "Indiaaaa");// finds key & replace its value // return old value // return null if key not present
        System.out.println("map: " + map);

        map.replace("ind", "India", "INDIA");// finds (key + matches old value) & then replace its value
        // return false if k,v does not find any match // return true if k,v pair is present & replaced
        System.out.println("map: " + map);

        map.remove("us");// remove map of key matches & return its value // return null if key not present
        System.out.println("map: " + map);

        map.remove("us", "United States of America");// return boolean if k,v pair is present & removed (else false)
        System.out.println("map: " + map);


        Set<String> keySet = new HashSet<>(map.keySet());// Set as it can follow uniqueness
        System.out.println("keySet: " + keySet);

        List<String> keys = new ArrayList<>(map.keySet());// Also can be type cast
        System.out.println("keys: " + keys);

        Collection<String> values = new ArrayList<>(map.values());// no uniqueness so not particularly Set
        System.out.println("values: " + values);


        for (Map.Entry<String, String> entry: map.entrySet()) {// to iterate whole Map
            System.out.print(entry.getKey());
            System.out.print(": ");
            System.out.println(entry.getValue());
        }
    }
}
