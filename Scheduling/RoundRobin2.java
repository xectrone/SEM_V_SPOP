import java.util.*;

class RoundRobin2
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of Processes : ");
        int n = sc.nextInt();

        int bt[]= new int[n];
        int rembt[] = new int[n];
        int wt[]= new int[n];
        int ta[]= new int[n];
        
        float avgta = 0;
        float avgwt = 0;

        int sq = 0;
        int count, temp, qt, i;
    
        for(i = 0; i<n; i++)
        {
            System.out.println("Enter the BT of process "+(i+1));
            bt[i] = sc.nextInt();
            rembt[i] = bt[i];
        }
        System.out.println("Enter the Quantum no. :");
        qt = sc.nextInt();

    
        while(true)
        {
            for(i=0, count=0; i<n; i++)
            {
                temp = qt;
                if(rembt[i] == 0)
                {
                    count++;
                    continue;
                }
                if(rembt[i]>qt)
                    rembt[i] = rembt[i] - qt;
                
                if(rembt[i]>=0)
                {
                    temp = rembt[i];
                    rembt[i] = 0;
                }
                sq = sq + temp;
                ta[i] = sq;
            }
            if(count==n)
                break;
        }

        for(i= 0; i<n; i++)
        {
            wt[i] = ta[i] - bt[i];
            
            avgta += ta[i];
            avgwt += wt[i];
        }

        System.out.println("PID\tBT\tWT\tTA");
        for(i=0; i<n; i++)
        {
            System.out.println((i+1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + ta[i]);
        }
        sc.close();

        System.out.println("Average WT : " + avgwt/n );
        System.out.println("Average TA : " + avgta/n );

    }
}