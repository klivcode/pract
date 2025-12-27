import java.util.Scanner;

public class IterationsBinarySearch {

    // before reading the given array in binary search we hae to sorted
    // we choose the bubble sort
    void swap(int arr[], int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void bubblesort(int arr[],int n)
    {
        for(int i =0; i<n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    int Binary_Search_Iteratively(int arr[], int left, int right, int key) {

        for ( ; left <= right ; ) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] > key)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        IterationsBinarySearch ob = new IterationsBinarySearch();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elements in the array");
        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("GIVEN ARRAY IS SORTING...............!");
        ob.bubblesort(arr,n);
        for (int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        int left= 0;
        int right=arr.length-1;
        System.out.println("\nEnter the key elements to find in the array");
        int key=sc.nextInt();
        int res=ob.Binary_Search_Iteratively(arr,left,right,key);
        System.out.println("at index "+res);
    }
}
