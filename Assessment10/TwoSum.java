import java.util.HashMap;
public class TwoSum {
    public static int[] findPair(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) return new int[]{map.get(target - arr[i]), i};
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = findPair(arr, target);
        System.out.println(result[0] + ", " + result[1]);
    }
}
