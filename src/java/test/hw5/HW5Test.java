package test.hw5;

import java.util.*;

import main.hw5.HomeWork5;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HW5Test {
    HomeWork5 hw;

    @Before
    public void setup(){
        hw = new HomeWork5();
    }

    @Test
    public void testUniqueCollection(){
        Collection<String> resultOne = hw.getUniqueCollection(new ArrayList<>(Arrays.asList("1","2","3","3")));
        Collection<String> expectedCollectionOne = new ArrayList<>(Arrays.asList("1","2","3"));
        Collection<Integer> resultTwo = hw.getUniqueCollection(new ArrayList<>(Arrays.asList(1,2,3,4,3,1,4)));
        Collection<Integer> expectedCollectionTwo = new ArrayList<>(Arrays.asList(1,2,3,4));

        Assert.assertEquals(expectedCollectionOne.toString(), resultOne.toString());
        Assert.assertEquals(expectedCollectionTwo.toString(), resultTwo.toString());
    }

    @Test
    public void testInverse(){
        Map<String, String> mapOne = Map.ofEntries(
                Map.entry("1", "one"),
                Map.entry("2", "two"),
                Map.entry("3", "three")
        );

        Map<String, Collection<String>> expectedMapOne = Map.ofEntries(
                Map.entry("one", Collections.singletonList("1")),
                Map.entry("two", Collections.singletonList("2")),
                Map.entry("three", Collections.singletonList("3"))
        );
        Map<String, Collection<String>> resultMapOne = hw.inverse(mapOne);

        Map<String, String> mapTwo = Map.ofEntries(
                Map.entry("apple", "яблоко"),
                Map.entry("pear", "груша"),
                Map.entry("cherry", "вишня")
        );


        Map<String, Collection<String>> expectedMapTwo = Map.ofEntries(
                Map.entry("яблоко", Collections.singletonList("apple")),
                Map.entry("груша", Collections.singletonList("pear")),
                Map.entry("вишня", Collections.singletonList("cherry"))
        );

        Map<String, Collection<String>> resultMapTwo = hw.inverse(mapTwo);

        Assert.assertEquals(expectedMapOne, resultMapOne);
        Assert.assertEquals(expectedMapTwo, resultMapTwo);
    }
}
