public class FindIndexOfString {
    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        
        int result = strStr(haystack, needle);
        System.out.println(result);
    }

    public static int strStr(String haystack, String needle) {
        // if(haystack.length() == needle.length()) {
        //     if(haystack.equals(needle)) return 0;
        //     else return -1;
        // }

        int l = 0;
        int r = needle.length();

        System.out.println(r);

        while (r <= haystack.length()) {
            System.out.println(haystack.substring(l, r));
            if(haystack.substring(l, r).equals(needle)) return l;

            l++;
            r++;
        }

        return -1;
    }
}
