import java.util.HashSet;
import java.util.Random;

public class q4 {
	public static void main(String[] args) {
		q4 q = new q4();
		q.warmup();

		int n = 1000;
		int repeats = 5000;

		int l = 500;
		int h = 1500;
//		while(l<h-1) {
//			if(q.partATimeInsertion(n, repeats) > q.partATimeMerge(n, repeats)) {
//				h = n;
//				n = l + (h-l)/2;
//			}
//			else {
//				l = n;
//				n = l + (h-l)/2;
//			}
//		}
		//q.partBTimeInsertion(300, repeats);
		//q.partBTimeMerge(300, repeats);


//		repeats = 5000;
//
//		l = 10;
//		h = 300;
//
//		n = l + (h-l)/2;
//
//		while(l<h-1) {
//			if(q.partBTimeInsertion(n, repeats) > q.partBTimeMerge(n, repeats)) {
//				h = n;
//				n = l + (h-l)/2;
//			}
//			else {
//				l = n;
//				n = l + (h-l)/2;
//			}
//		}

		repeats = 5000;

		l = 0;
		h = 300;


		int t1, t2;
		t1 = l + (h-l)/3;
		t2 = h - (h-l)/3;
		n = t2+1;
		while(t1<t2-1) {
			t1 = l + (h-l)/3;
			t2 = h - (h-l)/3;
			if(q.partC(n, repeats, t1) < q.partC(n, repeats, t2)) {
				h = t2;
			}
			else {
				l = t1;
			}
		}


	}

	void warmup() {
		int[][] arr = partA(500);
		arr = partB(500);
		Sorting.mergeSort(arr);
		Sorting.insertionSort(arr);
		Sorting.hybridSort(arr, 50);
	}


	double partATimeInsertion(int n, int repeats) {
		long start = getTime();
		for(int i = 0; i < repeats; i++) {
			int[][] arr = partA(n);
			Sorting.insertionSort(arr);
		}
		return endTimeAndPrint(start, repeats, "insertion sort, n = " + n);
	}

	double partATimeMerge(int n, int repeats) {
		long start = getTime();
		for(int i = 0; i < repeats; i++) {
			int[][] arr = partA(n);
			Sorting.mergeSort(arr);
		}
		return endTimeAndPrint(start, repeats, "merge sort, n = " + n);
	}

	int[][] partA(int n) {
		int[][] list = new int[n][100];
		HashSet<Integer> set = new HashSet<Integer>();
		Random ran = new Random();
		int c = 0;

		while(c < n) {
			int newInt = ran.nextInt(1000);
			if(!(set.contains(newInt))) {
				list[c++][0] = newInt;
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < 100; j++) {
				list[i][j] = ran.nextInt(1000);
			}
		}

		return list;
	}

	double partBTimeInsertion(int n, int repeats) {
		long start = getTime();
		for(int i = 0; i < repeats; i++) {
			int[][] arr = partB(n);
			Sorting.insertionSort(arr);
		}
		return endTimeAndPrint(start, repeats, "insertion sort, n = " + n);
	}

	double partBTimeMerge(int n, int repeats) {
		long start = getTime();
		for(int i = 0; i < repeats; i++) {
			int[][] arr = partB(n);
			Sorting.mergeSort(arr);
		}
		return endTimeAndPrint(start, repeats, "merge sort, n = " + n);
	}



	int[][] partB(int n) {
		int[][] list = new int[n][100];
		HashSet<Integer> set = new HashSet<Integer>();
		Random ran = new Random();

		for(int j = 0; j < 99; j++) {
			int ranInt = ran.nextInt(1000);
			for(int i = 0; i < n; i++) {
				list[i][j] = ranInt;
			}
		}

		int c = 0;
		while(c < n) {
			int newInt = ran.nextInt(1000);
			if(!(set.contains(newInt))) {
				list[c++][99] = newInt;
			}
		}

		return list;
	}

	double partC(int n, int repeats, int threshold) {
		long start = getTime();
		for(int i = 0; i < repeats; i++) {
			int[][] arr = partB(n);
			Sorting.hybridSort(arr, threshold);
		}
		return endTimeAndPrint(start, repeats, "hybrid sort, threshold = " + threshold);
	}

	private double endTimeAndPrint(long startTime, int n, String desc) {
		System.out.println(((getTime()-startTime)/(1e9*n)) + " seconds for " + desc);
		return ((getTime()-startTime)/(1e9*n));
	}

	private long getTime() { return System.nanoTime(); }
}
