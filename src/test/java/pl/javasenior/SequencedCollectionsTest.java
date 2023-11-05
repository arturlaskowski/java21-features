package pl.javasenior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

class SequencedCollectionsTest {

    @Test
    void sequencedCollectionsList() {
        //when
        List<String> list = List.of("A", "B", "C");
        //then
        Assertions.assertEquals("A", list.getFirst());
        Assertions.assertEquals("C", list.getLast());
    }

    @Test
    void sequencedCollectionsSet() {
        //when
        LinkedHashSet<String> set = new LinkedHashSet<>(List.of("A", "B", "C"));
        //then
        Assertions.assertEquals("A", set.getFirst());
        Assertions.assertEquals("C", set.getLast());
    }

    @Test
    void sequencedCollectionsMap() {
        //when
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("K1", "V1");
        linkedHashMap.put("K2", "V2");
        linkedHashMap.put("K3", "V3");

        //then
        Assertions.assertEquals("K1", linkedHashMap.firstEntry().getKey());
        Assertions.assertEquals("V3", linkedHashMap.lastEntry().getValue());
    }
}
