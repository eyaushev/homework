package test.hw5;

import java.util.*;

public class HomeWork5 {
    public static void main(String[] args) {
        Collection<String> list1 = new ArrayList<>(Arrays.asList("1","2","3","3"));
        Collection<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,3,1,4));

        System.out.println(getUniqueCollection(list1));
        System.out.println(getUniqueCollection(list2));

    }

    public static <T> Collection<T> getUniqueCollection(Collection<T> collection) {
        return new HashSet<>(collection);
    }
}
