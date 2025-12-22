import java.util.Scanner;

public class Insertion {
    void insertion_sort(int arr[], int n)
    {
        for(int i=1;i<n;i++)
        {
            int key=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }


    public static void main(String[] args) {
        Insertion in=new Insertion();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n= sc.nextInt();
        int arr[]=new int[n];
        int count=0;

        do{
            System.out.println("Enter the elements in the array");
            arr[count]=sc.nextInt();
            count++;

        }while(count<n);

        in.insertion_sort(arr,n);
        System.out.println("Sorted array");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
