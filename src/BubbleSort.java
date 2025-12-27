import java.util.Scanner;

public class BubbleSort {

   void swap(int arr[],int i,int j)
   {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;


   }


    void bubble_sort(int arr[],int n)
    {
        for (int i =0; i<n-1; i++)
        {
            for( int j=0; j<n-i-1; j++)
            {
                if(arr[j]>arr[j+1])
                {
                    swap(arr,j,j+1);
                }
            }
        }

    }


    public static void main(String[] args) {
        System.out.println("Enter the size of the array");
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        BubbleSort bs = new BubbleSort();
        bs.bubble_sort(arr,n);
        System.out.println("Sorted array");
        for (int i=0;i<n;i++)
        {
            System.out.println(arr[i]);
        }

    }
}
