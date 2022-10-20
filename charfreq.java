import java.util.Scanner;

class Frequency extends Thread
{
    private final String s;
    public Frequency(String s)
    {
        this.s=s;
    }
    @Override
    public void run()
    {
        char[] arr = s.toCharArray();
        int[] freq =  new int [s.length()];
        for(int i=0;i<s.length();i++)
        {
            freq[i]=1;
            for(int j=i+1;j<s.length();j++)
            {
                if(arr[i]==arr[j])
                {
                    freq[i]++;
                    arr[j]='0';
                }

            }
        }
        for(int i = 0; i <s.length(); i++)
        {
            if(arr[i] != ' ' &&  arr[i] != '0') {
                System.out.print(arr[i] +" : " + freq[i]+" ");
            }
        }
    }

}
public class ts2
{
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Counters :");
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = new String[2];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter text for counter "+(i+1));
            s[i] = sc.nextLine();
        }
        for(int i=0;i<n;i++)
        {
            System.out.println("\nCounter "+(i+1)+" result");
            Frequency f1 = new Frequency(s[i]);
            f1.start();
            f1.join();
        }

    }
}
