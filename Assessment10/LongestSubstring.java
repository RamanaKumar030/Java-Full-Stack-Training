import java.util.HashSet;
public class LongestSubstring {
    public static int longestUniqueSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (!set.add(s.charAt(right))) set.remove(s.charAt(left++));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("abcabcbb"));
    }
}
