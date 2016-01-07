import java.io.Console;

class PatternDiamond
{
	public static void main(String[] args) 
	{
		Console con = System.console();
		
		System.out.print("Enter any value: ");
		int n = Integer.parseInt(con.readLine());
		int x=0;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=i;j<n;j++)
			{
				System.out.print("  ");
			}
			
			for(int j=i;j>=1;j--)
			{
				if(j==i)
					System.out.print(" *");
				else
					System.out.print(" -");
			}
			
			for(int j=i-1;j>0;j--)
			{
				if(j==1)
					System.out.print(" *");
				else
					System.out.print(" -");
			}
			
			System.out.println();
		}
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("  ");
			}
			
			for(int j=(n-i);j>=1;j--)
			{
				if(j==(n-i))
					System.out.print(" *");
				else
					System.out.print(" -");
			}
			
			for(int j=(n-i-1);j>0;j--)
			{
				if(j==1)
					System.out.print(" *");
				else
					System.out.print(" -");
			}
			
			System.out.println();
		}
	}
}