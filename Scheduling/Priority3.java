import java.util.*;

class Priority3
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of Process : ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int pp[] = new int[n];
        int bt[] = new int[n];

        int ta[] = new int[n];
        int wt[] = new int[n];
        
        int temp;
        float avgta = 0;
        float avgwt = 0;

        for(int i=0; i<n; i++)
        {
            System.out.println("Enter PP of process no. " + i+1);
            pp[i] = sc.nextInt();

            System.out.println("Enter BT of process no. " + i+1);
            bt[i] = sc.nextInt();

            pid[i] = i+1;
        }

        for(int i=0; i<n-1; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(pp[i]>pp[j])
                {
                    temp = pp[i];
                    pp[i] = pp[j];
                    pp[j] = temp;  
                
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    temp = pid[i];
                    pid[i] = pid[j];
                    pid[j] = temp;
                }
            }
        }

        ta[0] = bt[0];
        wt[0] = 0;
        avgta += ta[0];

        for(int i=1; i<n; i++)
        {
            wt[i] = ta[i-1];
            ta[i] = wt[i] + bt[i];
            avgta += ta[i];
            avgwt += wt[i];
        }

        
        System.out.println("PID\tPP\tBT\tWT\tTA");
        for(int i=0; i<n; i++)
        {
            System.out.println(pid[i] + "\t" + pp[i] + "\t" + bt[i] + "\t" + wt[i] + "\t" + ta[i]);
        }
        sc.close();

        System.out.println("Average WT : " + avgwt/n );
        System.out.println("Average TA : " + avgta/n );
        



    }
}