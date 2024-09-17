
public class VeerWajeArray {
	private int[] array;

	public VeerWajeArray() {
		array = new int[10];
	}
	
	public void veerWajeInsertionSort() {
		int n = array.length;
	    for (int i = 1; i < n; i++) {
	        int key = array[i];
	        int j = i - 1;
	        while (j >= 0 && array[j] > key) {
	            array[j + 1] = array[j];
	            j--;
	        }
	        array[j + 1] = key;
	    }
	}
	
	public void veerWajeBubbleSort() {
		int n = array.length;
	    for (int i = 0; i < n - 1; i++) {
	        boolean swapped = false;
	        for (int j = 0; j < n - i - 1; j++) {
	            if (array[j] > array[j + 1]) {
	                // Swap elements at j and j+1
	                int temp = array[j];
	                array[j] = array[j + 1];
	                array[j + 1] = temp;
	                swapped = true;
	            }
	        }
	        // If no two elements were swapped in the inner loop, the array is already sorted
	        if (!swapped) {
	            break;
	        }
	    }
	}
	
	public static void veerWajeMergeSort(int[] array) {
		veerWajeMergeSort1(array, 0, array.length - 1);
	}

	private static void veerWajeMergeSort1(int[] array, int left, int right) {
	    if (left < right) {
	        int mid = (left + right) / 2;
	        veerWajeMergeSort1(array, left, mid);
	        veerWajeMergeSort1(array, mid + 1, right);
	        veerWajeMergeSort2(array, left, mid, right);
	    }
	}

	private static void veerWajeMergeSort2(int[] array, int left, int mid, int right) {
	    int n1 = mid - left + 1;
	    int n2 = right - mid;

	    int[] leftArray = new int[n1];
	    int[] rightArray = new int[n2];

	    System.arraycopy(array, left, leftArray, 0, n1);
	    System.arraycopy(array, mid + 1, rightArray, 0, n2);

	    int i = 0, j = 0, k = left;
	    while (i < n1 && j < n2) {
	        if (leftArray[i] <= rightArray[j]) {
	            array[k] = leftArray[i];
	            i++;
	        } else {
	            array[k] = rightArray[j];
	            j++;
	        }
	        k++;
	    }

	    while (i < n1) {
	        array[k] = leftArray[i];
	        i++;
	        k++;
	    }

	    while (j < n2) {
	        array[k] = rightArray[j];
	        j++;
	        k++;
	    }
	}
	
	public static void veerWajeQuickSort(int[] array) {
		veerWajeQuickSort1(array, 0, array.length - 1);
	}

	private static void veerWajeQuickSort1(int[] array, int low, int high) {
	    if (low < high) {
	        int partitionIndex = veerWajeQuickSort2(array, low, high);
	        veerWajeQuickSort1(array, low, partitionIndex - 1);
	        veerWajeQuickSort1(array, partitionIndex + 1, high);
	    }
	}

	private static int veerWajeQuickSort2(int[] array, int low, int high) {
	    int pivot = array[high];
	    int i = low - 1;

	    for (int j = low; j < high; j++) {
	        if (array[j] < pivot) {
	            i++;
	            // Swap elements at i and j
	            int temp = array[i];
	            array[i] = array[j];
	            array[j] = temp;
	        }
	    }

	    // Swap the pivot element into its correct position
	    int temp = array[i + 1];
	    array[i + 1] = array[high];
	    array[high] = temp;

	    return i + 1;
	}
	
	public void veerWajePrint() {
		 System.out.print("ARRAY=[");
	        for (int i = 0; i < array.length - 1; i++) {
	            System.out.print(array[i] + ", ");
	        }
	        System.out.println(array[array.length - 1] + "]");
	}
	
	public void veerWajeSortAlgorithmComplexit() {
		System.out.println("veerWajeInsertionSort complexity: O(n^2)");

		System.out.println("veerWajeBubbleSort complexity: O(n^2)");

		System.out.println("veerWajeMergeSort complexity: O(n log n)");

		System.out.println("veerWajeQuickSort complexity: O(n log n)");
		
		System.out.println("Quick Sort is generally considered the best sorting method for most scenarios, including this one, due to its average-case time complexity of O(n log n) and its in-place sorting property, which reduces memory usage");
	}
}
