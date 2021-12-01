package days;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day16 {
    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    };
    public void fastSort(String[] strings){
        int i = 0;
        int j = strings.length-1;
        while (i<j){
            while (comparator.compare(strings[i],strings[j]) >= 0 && i<j) j--;
            while (comparator.compare(strings[i],strings[j]) <= 0 && i<j) i++;
            String t = strings[i];
            strings[i] = strings[j];
            strings[j] = t;
        }
    }
    public String minNumber(int[] nums) {
        String[] strings = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);



        //Arrays.sort(strings,comparator);
        fastSort(strings);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
        }
        return builder.toString();
    }
}
