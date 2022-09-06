package org.kimfri.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class OneTest {

    private Map<String, String> tempMap = new HashMap<>();
    private Set<String> mySet = new HashSet<>();

    public OneTest() {
//        tempMap.put("4000", "");
//        mySet.add("4000");
    }

    public boolean isNeedlePresentInList(List<String> values, String needle) {
        final Optional<String> needleFound = values.stream()
                .filter(it -> it.equals(needle))
                .findAny();
        if (needleFound.isPresent()) {
            return false;
        }
        values.add(needle);
        return true;
    }

    public boolean isNeedlePresentInList2(List<String> values, String needle) {
        if(tempMap.containsKey(needle)) {
            System.err.println("insede 2 needle exist: " + needle);
            return false;
        }
        if("4000".equals(needle)) {
            System.err.println("4k found, in tmpMap: " + tempMap.containsKey(needle));
        }
        tempMap.put(needle, "");
        values.add(needle);
        return true;
    }

    public boolean isNeedlePresentInList3(List<String> values, String needle) {

        if(mySet.contains(needle)) {
            System.err.println("insede 3 needle exist: " + needle);
            return false;
        }
        mySet.add(needle);
        values.add(needle);
        return true;
    }
}
