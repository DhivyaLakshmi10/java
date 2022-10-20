import java.util.*;

class VoteId extends Thread{
    Random rand = new Random();                      // generating a random number
    int max = 750;                                   // max wait time for thread
    int min = 100;                                   // min wait time for thread
    int v, s;
    Vector vec;

    public VoteId(int v, Vector vec)
    {
        this.v = v;
        this.vec = vec;
    }

    public void run() {
        try
        {
            // while voting print id
            while(vec.size() < 240) {               // ensure size of vote vector is below 240
                System.out.println("Thread " + this.getId() + " is Voting");
                vec.add(v);

                s = rand.nextInt((max - min) + 1) + min;
                System.out.println("Thread " + this.getId() + " is sleeping for " + s);
                Thread.sleep(s);                    // create random delay between threads
            }

        }
        catch(InterruptedException e)
        {
            System.out.println("Voting Exception: " + e);
        }
    }
}
class CountVote extends Thread{
    Vector vec;
    int k, i;
    public int count = 0;

    public CountVote(int k, Vector vec){
        this.k = k;
        this.vec = vec;
    }

    public void run(){
        try{
            for(i = 0; i < vec.capacity(); i++){
                if(vec.elementAt(i).equals(k))              // check if elements match
                    count++;

            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
public class ts4 {
    public static void main(String[] args) {
        Vector votevec = new Vector(240);   // creating a vote array for 240 votes

        VoteId a = new VoteId(1, votevec);
        a.start();

        VoteId b = new VoteId(2, votevec);
        b.start();

        VoteId c = new VoteId(3, votevec);
        c.start();

        try{
            a.join();
            b.join();
            c.join();
            System.out.println("Voting has ended!");
        }catch(Exception e){System.out.println(e);}

        CountVote ac = new CountVote(1, votevec);
        CountVote bc = new CountVote(2, votevec);
        CountVote cc = new CountVote(3, votevec);

        ac.start();
        bc.start();
        cc.start();

        try{
            ac.join();
            bc.join();
            cc.join();
            System.out.println("Counting has ended!");
        }catch(Exception e){System.out.println(e);}

        int av = ac.count;
        int bv = bc.count;
        int cv = cc.count;

        System.out.println("elections.Vote Vector:" + "\n" + votevec);
        System.out.println(av + " votes for A");
        System.out.println(bv + " votes for B");
        System.out.println(cv + " votes for C");

        if(av >= bv && av >= cv){
            if(av == bv || av == cv)
                System.out.println("Tie in elections!");
            else
                System.out.println("A has won the elections!");
        }
        else if(bv >= av && bv >= cv){
            if(bv == cv)
                System.out.println("Tie in elections!");
            else
                System.out.println("B has won the elections!");
        }
        else {
            System.out.println("C has won the elections!");
        }
    }
}