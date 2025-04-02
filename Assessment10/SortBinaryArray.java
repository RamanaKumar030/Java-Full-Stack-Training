import java.util.Arrays;
public class SortBinaryArray {
    public static void sortBinary(int[] arr) {
        int count = 0;
        for (int num : arr) if (num == 0) count++;
        for (int i = 0; i < arr.length; i++) arr[i] = (i < count) ? 0 : 1;
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 0};
        sortBinary(arr);
        System.out.println(Arrays.toString(arr));
    }
}
