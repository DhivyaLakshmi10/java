import java.util.*;
class Maximum extends Thread{
    private Integer [] arr;
    public Maximum(Integer[] ar)
    {
        this.arr = new Integer[ar.length];
        for (int i=0;i<arr.length;i++)
        {
            this.arr[i]=ar[i];
        }
    }
    @Override
    public void run()
    {
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        System.out.println("Maximum in array is "+max);
    }
}
class Minimum extends Thread{
    private Integer [] arr;
    public Minimum(Integer[] arr)
    {
        this.arr = new Integer[arr.length];
        for (int i=0;i<arr.length;i++)
        {
            this.arr[i]=arr[i];
        }
    }
    @Override
    public void run()
    {
        int min = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<min)
            {
                min=arr[i];
            }
        }
        System.out.println("Minimum in array is "+min);
    }
}
class Average extends Thread{
    private Integer [] arr;
    public Average(Integer[] arr)
    {
        this.arr = new Integer[arr.length];
        for (int i=0;i<arr.length;i++)
        {
            this.arr[i]=arr[i];
        }
    }
    @Override
    public void run()
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        System.out.println("Average in array is "+sum/ arr.length);
    }
}
public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of input in the array: ");
        Integer n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Maximum m1 = new Maximum(arr);
        Minimum m2 = new Minimum(arr);
        Average m3 = new Average(arr);
        m1.start();
        m2.start();
        m3.start();
    }
}