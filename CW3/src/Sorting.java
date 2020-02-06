public class Sorting {
	public static void insertionSort (int[][] data) {
		for(int i = 1; i < data.length; i++) {
			int j = i;
			while(j > 0 && compareLines(data[j], data[j-1]) < 0) {
				int[] temp = data[j];
				data[j] = data[j-1];
				data[j-1] = temp;
				j--;
			}
		}
	}

	public static int[][] mergeSort(int[][] data) {
		int[][] toSort = new int[data.length][data[0].length];
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				toSort[i][j] = data[i][j];
			}
		}
		splitAndMerge(toSort, 0, toSort.length-1, 1);
		return toSort;
	}

	private static void splitAndMerge(int[][] data, int left, int right, int threshold) {
		if(left < right && right-left+1 > threshold) {
			int mid = (right + left) / 2;
			//System.out.println(mid);
			splitAndMerge(data, left, mid, threshold);
			splitAndMerge(data, mid+1, right, threshold);

			int len1 = mid-left+1;
			int len2 = right-mid;
			int[][] leftTemp = new int[len1][data[0].length];
			int[][] rightTemp = new int[len2][data[0].length];

			for(int i = 0; i < len1; i++) {
				leftTemp[i] = data[i+left];
			}
			for(int i = 0; i < len2; i++) {
				rightTemp[i] = data[i+mid+1];
			}

			int i = 0, j = 0, k = left;
			while(k < right+left && i < len1 && j < len2) {
				if(compareLines(leftTemp[i], rightTemp[j]) <= 0) {
					data[k++] = leftTemp[i++];
				}
				else {
					data[k++] = rightTemp[j++];
				}
			}

			while(i < len1) {
				data[k++] = leftTemp[i++];
			}
			while(j < len2) {
				data[k++] = rightTemp[j++];
			}
		}
		else if (left < right) {
			for(int i = left+1; i <= right; i++) {
				int j = i;
				while(j > left && compareLines(data[j], data[j-1]) < 0) {
					int[] temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
					j--;
				}
			}
		}
	}


	public static int[][] hybridSort (int[][] data, int threshold) {
		int[][] toSort = new int[data.length][data[0].length];
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				toSort[i][j] = data[i][j];
			}
		}
		splitAndMerge(toSort, 0, toSort.length-1, threshold);
		return toSort;
	}

	static int compareLines(int[] a,int[] b) {  // You may make this public if you wish
		int n=a.length;
		if (n != b.length)
			return (a[b.length-1]+b[a.length-1]);  // this gives an error
		int i=0;
		while (i<n && a[i]==b[i])
			i++;   // skip equal elements
		if (i==n)
			return 0;
		if (a[i]<b[i])
			return -1;
		else return 1;
	}

}