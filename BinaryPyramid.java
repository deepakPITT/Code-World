import java.io.Console;

class BinaryPyramid
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
			
			for(int j=(2*i)-1;j>=1;j--)
			{
				if(i%2==1)
				{
					if(j%2==1)
						System.out.print("1");
					else
						System.out.print("0");
				}
				else
				{
					if(j%2==1)
						System.out.print("0");
					else
						System.out.print("1");
				}
			}
			System.out.println();
		} 
	}
}