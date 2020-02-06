public class SortTest {
    public static void main(String[] args) {
	    int [][]arr = {{1,2},{4,5},{4,3},{2,3}};
        System.out.println("Unsorted row 0 is "+arr[0][0]+","+arr[0][1]);
        System.out.println("Unsorted row 1 is "+arr[1][0]+","+arr[1][1]);
        System.out.println("Unsorted row 2 is "+arr[2][0]+","+arr[2][1]);
        System.out.println("Unsorted row 3 is "+arr[3][0]+","+arr[3][1]);
        // Display the string.
        int[][] arr2=Sorting.mergeSort(arr);
            System.out.println("Sorted row 0 is "+arr2[0][0]+","+arr2[0][1]);
            System.out.println("Sorted row 1 is "+arr2[1][0]+","+arr2[1][1]);
            System.out.println("Sorted row 2 is "+arr2[2][0]+","+arr2[2][1]);
            System.out.println("Sorted row 3 is "+arr2[3][0]+","+arr2[3][1]);
        Sorting.insertionSort(arr);
            System.out.println("Sorted row 0 is "+arr[0][0]+","+arr[0][1]);
            System.out.println("Sorted row 1 is "+arr[1][0]+","+arr[1][1]);
            System.out.println("Sorted row 2 is "+arr[2][0]+","+arr[2][1]);
            System.out.println("Sorted row 3 is "+arr[3][0]+","+arr[3][1]);
    }	
}
