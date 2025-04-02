import java.util.Arrays;
public class ReverseKGroup {
    public static void reverseK(int[] arr, int k) {
        for (int i = 0; i < arr.length; i += k) {
            int left = i, right = Math.min(i + k - 1, arr.length - 1);
            while (left < right) {
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        reverseK(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
