public class MergeSort {
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Array is already sorted or empty
        }
        
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }
    
    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left >= right) {
            return; // Base case: subarray has 0 or 1 element
        }
        
        int mid = left + (right - left) / 2;
        mergeSort(array, temp, left, mid); // Sort left subarray
        mergeSort(array, temp, mid + 1, right); // Sort right subarray
        merge(array, temp, left, mid, right); // Merge the sorted subarrays
    }
    
    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        
        int i = left; 
        int j = mid + 1; 
        int k = left; 
        
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        
        while (i <= mid) {
            array[k] = temp[i];
            i++;
            k++;
        }
    }
}
