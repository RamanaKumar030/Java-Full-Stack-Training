public class MajorityElement {
    public static int findMajority(int[] arr) {
        int candidate = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            count += (arr[i] == candidate) ? 1 : -1;
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            }
        }
        return candidate;
    }
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 2, 2, 2};
        System.out.println("Majority Element: " + findMajority(arr));
    }
}
