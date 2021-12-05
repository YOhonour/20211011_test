package days;

import java.util.*;

public class Day16 {

    public int compare(String o1, String o2) {
        String s1 = o1 + o2;
        String s2 = o2 + o1;
        return (s2).compareTo(s1);
    }
    public void fastSort(String[] strings,int n,int m){
        if (n>=m) return;
        int i = n;
        int j = m;
        String t;
        while (i<j){
            while (compare(strings[i],strings[j]) >= 0 && i<j) j--;
            while (compare(strings[j],strings[i]) <= 0 && i<j) i++;
            t = strings[i];
            strings[i] = strings[j];
            strings[j] = t;
        }
        fastSort(strings,n,j-1);
        fastSort(strings,i+1,m);
    }
    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    };
    public String minNumber(int[] nums) {
        String[] strings = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strings,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        //fastSort(strings,0,strings.length-1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
        }
        return builder.toString();
    }
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (nums[i]==0) i++;
        int zeros = i;
        int gap = 0;
        while (i < nums.length-1){
            gap = nums[i+1]-nums[i]-1;
            if (gap<0) return false;
            zeros-=gap;
            if (zeros<0) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5};
        Day16 day16 = new Day16();
        day16.isStraight(ints);
    }
    public static void main1(String[] args) {
        String[] strings;
        Day16 day16 = new Day16();

        strings = new String[]{"3","30","34","5","9"};
        day16.fastSort(strings,0,strings.length-1);
        System.out.println(Arrays.toString(strings));

        System.out.println(day16.compare("3","30"));
        Integer[] ints = {2, 8, 9, 4, 6, 3, 1, 7, 5, 1};
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < ints.length; i++) {
            integers.add(ints[i]);
        }
        ;
    }
}
