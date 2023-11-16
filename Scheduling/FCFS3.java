import java.util.*;

class FCFS3
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of processes : ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];

        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];

        int temp;
        float avgta = 0;
        float avgwt = 0;

        for(int i = 0; i<n; i++)
        {
            System.out.println("Enter AT of Process no." + i+1 );
            at[i] = sc.nextInt();

            System.out.println("Enter BT of Process no." + i+1 );
            bt[i] = sc.nextInt();

            pid[i] = i+1;
        }

        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n-(i+1); j++)
            {
                if(at[j]>at[j+1])
                {
                    temp = pid[j];
                    pid[j] = pid[j+1];
                    pid[j+1] = temp;

                    temp = at[j];
                    at[j] = at[j+1];
                    at[j+1] = temp;

                    temp = bt[j];
                    bt[j] = bt[j+1];
                    bt[j+1] = temp;
                }
            }
        }

        for(int i = 0; i<n; i++)
        {
            if(i==0)
                ct[i] = at[i] + bt[i];
            else
                if(at[i]>ct[i-1])
                    ct[i] = at[i] + bt[i];
                else
                    ct[i] = ct[i-1] + bt[i];

            ta[i] = ct[i] - at[i];
            wt[i] = ta[i] - bt[i];
            
            avgta += ta[i];
            avgwt += wt[i];
        }




        System.out.println("PID \t AT \t BT \t CT \t WT \t TA");
        for(int i=0; i<n; i++)
        {
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + wt[i] + "\t" + ta[i]);
        }
        sc.close();

        System.out.println("Average WT : " + avgwt/n );
        System.out.println("Average TA : " + avgta/n );
        
    }
}