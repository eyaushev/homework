package test.hw5;

import main.hw5.HomeWork5;

import java.util.*;

public class HW5Test {
    public static void main(String[] args) {

        HomeWork5 hw = new HomeWork5();

        Collection<String> list1 = new ArrayList<>(Arrays.asList("1","2","3","3"));
        Collection<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,3,1,4));

        System.out.println(hw.getUniqueCollection(list1));
        System.out.println(hw.getUniqueCollection(list2));

        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");

        System.out.println(hw.inverse(map));

    }
}
