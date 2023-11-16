import java.util.*;

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of processes : ");
        int n = sc.nextInt();

        int bt[] = new int[n];
        int rembt[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];

        float avgta = 0;
        float avgwt = 0;

        int temp, j, count, sq = 0;

        System.out.println("Enter the Quantum no. : ");
        int qt = sc.nextInt();

        for(int i=0; i<n; i++)
        {
            System.out.println("Enter the BT of process no." + (i+1));
            bt[i] = sc.nextInt();
            rembt[i] = bt[i];
        }

        while(true)
        {
            for(j=0, count=0; j<n; j++ )
            {
                temp = qt;
                if(rembt[j]==0)
                {
                    count++;
                    continue;
                }
                if(rembt[j]>qt)
                    rembt[j] = rembt[j] - qt;
                else
                {
                    if(rembt[j]>=0)
                    {
                        temp = rembt[j];
                        rembt[j] = 0;
                    }
                }
                sq = sq + temp;
                ta[j] = sq;
            }
            if(count==n)
                break;
        }


        for(int i=0; i<n; i++)
        {
            wt[i] = ta[i] - bt[i];
    
            avgta += ta[i];
            avgwt += wt[i];
        }
    
        System.out.println("PID\tBT\tWT\tTA");
        for(int i=0; i<n; i++)
        {
            System.out.println((i+1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + ta[i]);
        }
        sc.close();

        System.out.println("Average WT : " + avgwt/n );
        System.out.println("Average TA : " + avgta/n );

    }

}