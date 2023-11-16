import java.util.*;

class Main{
	
		static Scanner sc = new Scanner(System.in);
		static void fcfs_run()
		{
			System.out.println("Enter Total number of process " );
			int n = sc.nextInt();
			
			int p[] = new int[n];
			int at[] = new int[n];
			int bt[] = new int[n];
			int ct[] = new int[n];
			int tat[] = new int[n];
			int wt[] = new int[n];
			
			float avgtat = 0;
			float avgwt = 0;
			int temp;
			
			for (int i=0; i<n; i++)
			{
				System.out.println("Enter the Arrival time of Process: ");
				at[i] = sc.nextInt();
				System.out.println("Enter the burst time ");
				bt[i] = sc.nextInt();
				p[i] = (i+1);
			}
			
			for (int i=0; i<n; i++)
			{
				for (int j=0; j<n-(i+1); j++)
				{
					if (at[j] > at[j+1])
					{
						temp = at[j];
						at[j] = at[j+1];
						at[j+1] = temp;
						
						temp = p[j];
						p[j] = p[j+1];
						p[j+1] = temp;
						
						temp = bt[j];
						bt[j] = bt[j+1];
						bt[j+1] = temp;
					}
					
				}
			}
			
			for (int i=0; i<n; i++)
			{
				if (i==0)
				{
					ct[i] = at[i] + bt[i];
				}
				else
					{
						if (at[i] > ct[i-1])
						{
							ct[i] = at[i] + bt[i];
						}
						
						else
						{
							ct[i] = ct[i-1] + bt[i];
						}
					}
					
					tat[i] = ct[i] - at[i];
					avgtat += tat[i];
					wt[i] = tat[i] - bt[i];
					avgwt += wt[i];
			}
			
			System.out.println("P\tAT\tBT\tCT\tTAT\tWT\t");
			
			for (int i=0; i<n; i++)
			{
				System.out.println(p[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
				
			}
			
			System.out.println("AVG Tat" + (avgtat/n));
			System.out.println("AVG wt" + (avgwt/n));
		}
		
		
		static void roundrobin()
		{
			System.out.println("Enter total process");
			int n = sc.nextInt();
			
			int bt[] = new int[n];
			int tat[] = new int[n];
			int wt[] = new int[n];
			int rem_bt[] = new int[n];
			int temp = 0;
			int count = 0;
			int i;
			int qt;
			int sq=0;
			float avgtat = 0;
			float avgwt = 0;
			
			for (i=0; i<n; i++)
			{	
				System.out.println("Enter burst time of " +(i+1) );
				bt[i] = sc.nextInt();
				rem_bt[i] = bt[i];
			}
			System.out.println("Enter time quantum ");
			qt = sc.nextInt();
			
			while(true)
			{
				for (i=0, count=0; i<n;i++)
				{	
					temp = qt;
					
					if (rem_bt[i] == 0)
					{
						count++;
						continue;
					}
					
					if (rem_bt[i] > qt)
					{
						rem_bt[i] = rem_bt[i] - qt;
					}
					
					else
					{
						if (rem_bt[i] >= 0)
						{
							temp = rem_bt[i];
							rem_bt[i] = 0;
						} 
					}
					
					sq = sq + temp;
					tat[i] = sq;
				}
				
				if (n== count)
				{
					break;
				}
			}
			
			for (i=0; i<n; i++)
			{
				wt[i]= tat[i] - bt[i];
				avgwt += wt[i];
				avgtat += tat[i];
			}
			
			System.out.println("P\tBT\tTAT\tWT");
			for (i=0; i<n;i++)
			{
				System.out.println((i+1) + "\t" + bt[i] + "\t" + tat[i] + "\t" + wt[i] );
			}
			System.out.println("AVG tat" + (avgtat/n));
			System.out.println("AVG wt" + (avgwt/n));
		}
	
	public static void main(String args[])
	{	
		
		while(true)
		{
			System.out.println("1.FCFS");
			System.out.println("2.Round Robin");
			System.out.println("3.Exit");
			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();
			
			
			if (ch == 1)
			{
				fcfs_run();	
			}
			
			else if (ch == 2)
			{
				roundrobin();
			}
			
			else if( ch == 3)
			{
				break;
			}
			
			else
			{
				System.out.println("Wrong Choice");
			}
		} 
	}
}
