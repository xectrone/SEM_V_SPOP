import java.util.*;

class Main2
{
	static Scanner sc =  new Scanner(System.in);
	static void priority()
	{
		 System.out.println("Enter total number of process: " );
		 int n = sc.nextInt();
		 int p[] = new int[n];
		 int bt[] = new int[n];
		 int tat[] = new int[n];
		 int wt[] = new int[n];
		 int pp[] = new int[n];
		 int temp;
		 float avgwt = 0;
		 float avgtat = 0;
		 
		 for(int i=0; i<n; i++)
		 {
		 	System.out.println("Enter Burst time of " + (i+1));
		 	bt[i] = sc.nextInt();
		 	System.out.println("Enter priority of : "+ (i+1));
		 	pp[i] = sc.nextInt();
		 	p[i] = (i+1);
		 }
		 for (int i=0; i<n-1; i++)
		 {
		 	for (int j=0; j<n-i-1; j++)
		 	{
		 		if (pp[j] < pp[j+1])
		 		{	
		 			temp = pp[j];
		 			pp[j] = pp[j+1];
		 			pp[j+1] = temp;
		 			
		 			temp = bt[j];
		 			bt[j] = bt[j+1];
		 			bt[j+1] = temp;
		 			
		 			temp = p[j];
		 			p[j] = p[j+1];
		 			p[j+1] = temp;
		 		}
		 	}
		 }
		 
		 wt[0] = 0;
		 tat[0] = bt[0];
		 avgtat += tat[0];
		 
		 for (int i=1;i<n; i++)
		 {
		 	wt[i] = tat[i-1];
		 	tat[i] = wt[i] + bt[i];
		 	avgwt += wt[i];
		 	avgtat += tat[i];
		 }
		 
		 System.out.println("P\tPP\tBT\tTAT\tWT");
		 
		 for (int i=0; i<n; i++)
		 {	
		 	System.out.println(p[i] + "\t" +pp[i] + "\t" +bt[i] + "\t" +tat[i] + "\t" +wt[i] );
		 }
		 
		 System.out.println("AVG tat" + (avgtat/n));
		 System.out.println("AVG wt" + (avgwt/n));
	}
	
	static void sjf()
	{
		System.out.println("Enter total number of Process");
		int n = sc.nextInt();
		
		int p[] = new int[n];
		int at[] = new int[n];
		int bt[] = new int[n];
		int tat[] = new int[n];
		int ct[] =new int[n];
		int wt[] = new int[n];
		int f[] =new int[n];
		int k[] =new int[n];
		int c;
		int tot=0;
		int st=0;
		
		float avgtat=0;
		float avgwt=0;
		
		for (int i=0; i<n; i++)
		{
			System.out.println("ENter arrival time of " + (i+1));
			at[i] = sc.nextInt();
			System.out.println("Enter brust time of " + (i+1));
			bt[i] = sc.nextInt();
			p[i] = (i+1);
			k[i] = bt[i];
			f[i] = 0;
		}
		
		while(true)
		{
			int min=99; c=n;
			if (tot ==n)
			{
				break;
			}
			
			for (int i=0; i<n; i++)
			{
				if ((at[i]<=st)&&(f[i] ==0)&&(bt[i] < min))
				{
					min = bt[i];
					c=i;
				}
				
			}
				if(c==n)
				{
					st++;
				}
				else
				{
					bt[c]--;
					st++;
					if (bt[c]== 0)
					{
						ct[c]=st;
						f[c] =1;
						tot++;
					}
				}
		}
		
		for (int i=0; i<n; i++)
		{
			tat[i] = ct[i] - at[i];
			wt[i] = tat[i] - k[i];
			avgtat += tat[i];
			avgwt += wt[i];
		}
		
		System.out.println("P\tAT\tBT\tCT\tTAT\tWT");
		
		for (int i=0; i<n; i++)
		{
			System.out.println(p[i] + "\t" +at[i] + "\t" +k[i] + "\t" +ct[i] + "\t" +tat[i] + "\t" +wt[i]);
		}
		System.out.println("avg tat" + (avgtat/n));
		System.out.println("avg wt" + (avgwt/n));
	}
	
	
	public static void main(String args[])
	{
		while(true)
		{
			System.out.println("1.Priority");
			System.out.println("2.SJF");
			System.out.println("3.Exit");
			
			System.out.println("Enter your choice");
			int ch = sc.nextInt();
			
			if (ch==1)
			{
				priority();
			}
			
			else if (ch==2)
			{
				sjf();
			}
			
			else if (ch==3)
			{
				break;
			}
			
			else
			{
				System.out.println("Wrong choice");
			}
		}
	}
}













