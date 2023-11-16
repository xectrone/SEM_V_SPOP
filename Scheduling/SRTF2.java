import java.util.*;

class Main
{
    public static void main(Sting args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of processes : ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];

        int ta[] = new int[n];
        int wt[] = new int[n];
        int ct[] = new int[n];

        int f[] = new int[n];
        int k[] = new int[n];

        int tot, st = 0 ;

        for(int i=0; i<n; i++)
        {
            System.out.println("Enter the BT of process no."+(i+1));
            bt[i] = sc.nextInt();

            System.out.println("Enter the AT of process no."+(i+1));
            at[i] = sc.nextInt();

            pid[i] = i+1;
            f[i] = 0;
            k[i] = bt[i];
        }

        while(true)
        {
            int min = 99, c=n;
            if(tot==n)
                break;

            for(int i=0; i<n; i++)
            {
                if((at[i]<st)&&(f[i]==0)&&(bt[i]<min))
                {
                    min = bt[i];
                    c=i;

                }
            }

            if(c==n)
                st++;
            else
            {
                st++;
                bt[c]--;
                if(bt[c]==0)
                {
                    ct[c] = st;
                    f[c] = 1;
                    tot++;
                }
            }
            
        }
        for(int i=0; i<n; i++)
        {
            ta[i] = ct[i] - at[i];
            wt[i] = ta[i] - k[i];

            avgta += ta;
            avgwt += wt;
        }

        System.out.println("PID\tAT\tBT\tCT\tWT\tTA");
        for(int i=0; i<n; i++)
        {
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i]+ "\t" + wt[i]+ "\t" + ta[i]  );
        }
        sc.close();

        System.out.println("Average WT : " + avgwt/n );
        System.out.println("Average TA : " + avgta/n );

    }
}