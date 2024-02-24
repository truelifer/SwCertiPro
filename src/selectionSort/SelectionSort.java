package selectionSort;

public class SelectionSort {
	public static void main(String[] args) {
		int[] array = {4,2,6,7,3};
		printArray(array);
		selectionSort(array);
		printArray(array);
	}
	
	public static void printArray(int[] array) {
		for(int i=0; i < array.length; i++) {
			System.out.print(array[i]);
			System.out.print(",");
		}
		System.out.println();
	}
	
	public static void selectionSort(int[] array) {
		for(int i=0; i <= array.length-2; i++) {
			int minIndex = i;
			for(int j=i+1; j <= array.length-1; j++) {
				if(array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			if(i != minIndex) {
				int tmp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = tmp;
			}
		}
	}

}
