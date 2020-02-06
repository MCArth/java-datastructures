import java.util.Arrays;

public class SortingTest {
	public static void main(String[] args) {
		//assert testSorting(new int[][]{{5}, {1}, {3}});
		printSortedArr(new int[][]{{5}, {1}, {3}});
		printSortedArr(new int[][]{{1}, {3}, {5}});
		printSortedArr(new int[][]{{5, 2}, {1, 10}, {5, 2}, {5, 3}, {5, 1}, {3, 5}});

		printSortedArr(new int[][]{{5, 2}, {1, 10}, {5, 2}, {10, 10}, {5, 1}, {1, 5}, {2, 5}, {20, 5}, {9, 1}, {10, 4}, {2, 50}, {30, 5}});
	}

	private static void printSortedArr(int[][] arr) {
		arr = Sorting.mergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static boolean testSorting(int[][] arr) {
		int[][] copy = new int[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}

		Arrays.sort(copy);
		Sorting.insertionSort(arr);

		if(copy.equals(arr)) return true;
		else return false;
	}
}
