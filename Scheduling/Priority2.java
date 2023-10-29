import java.util.*;

public class Priority2
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of processes : ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int pp[] = new int[n];
        int bt[] = new int[n];
        int wt[] = new int[n];
        int ta[] = new int[n];

        int temp;
        int avgta = 0;
        int avgwt = 0;

        for(int i=0; i<n ; i++)
        {
            System.out.println("Enter Burst time for the process no. : "+(i+1));
            bt[i] = sc.nextInt();

            System.out.println("Enter Process Priority for the process no. : "+(i+1));
            pp[i] = sc.nextInt();

            pid[i] = i+1;
        }

        for(int i= 0; i<n-1; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(pp[i]>pp[j])
                {
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    temp = pp[i];
                    pp[i] = pp[j];
                    pp[j] = temp;

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

        System.out.println("\nProcess Id Priority of Processes Burst Time  Turn Around Time Waiting Time");
        for(int i=0; i<n; i++)
        {
            System.out.println(pid[i] +"    \t     "+ pp[i] +"    \t     "+ bt[i] +"    \t     "+ ta[i] +"    \t     "+ wt[i]);;
        }
        sc.close();

        System.out.println("\n Average Waiting Time is : "+ (avgwt/n));
        System.out.println("\n Average Turn Around Time is : "+ (avgta/n));

    }

}