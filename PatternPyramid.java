import java.io.Console;

class PatternPyramid
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
				System.out.print(" ");
			}
			
			for(int j=1;j<=i;j++)
			{
				System.out.print(j);
			}
			
			for(int j=i-1;j>0;j--)
			{
				System.out.print(j);
			}
			
			System.out.println();
		} 
	}
}