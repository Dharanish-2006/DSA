public class SearchDemo {
    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key)
                return i;
        return -1;
    }

    static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int key = 40;

        int linResult = linearSearch(arr, key);
        System.out.println(linResult == -1 ? "Not found (Linear)" : "Found at index " + linResult + " (Linear)");

        int binResult = binarySearch(arr, key);
        System.out.println(binResult == -1 ? "Not found (Binary)" : "Found at index " + binResult + " (Binary)");
    }
}
