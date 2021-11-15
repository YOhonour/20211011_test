package days;

public class Day03 {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        for (int n = 0; n < len ; n ++) {
            if (s.charAt(n) == ' '){
                builder.append("%20");
            }else
            {
                builder.append(s.charAt(n));
            }
        }
        return builder.toString();
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        for (int i = n; i < len ; i ++) {
            builder.append(s.charAt(i));
        }
        for (int i = 0; i < n ; i ++) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
    public String reverseLeftWords2(String s, int n) {
        StringBuilder builder = new StringBuilder();
        int length = s.length();
        builder.append(s.subSequence(n,length));
        builder.append(s.subSequence(0,n));
        return builder.toString();
    }
    public static void main(String[] args) {

    }
}
