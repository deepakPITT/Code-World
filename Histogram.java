import java.io.Console;

class Histogram
{
	public static void main (String[] args) 
	{
		int a[] = new int[10];
		int max=0;
		Console con = System.console();
		
		System.out.println("Enter 10 values");
		for(int i=0;i<10;i++)
		{
			a[i] = Integer.parseInt(con.readLine());
		}
		
		for(int i=0;i<10;i++)
		{
			if(max<a[i])
				max=a[i];
		}
		
		System.out.println("\n\n");
					
		for(int i=max;i>0;i--)
		{
			for(int j=0;j<10;j++)
			{
				if(a[j]>=i)
					System.out.print("*\t");
				else
					System.out.print("\t");
			}
			
			System.out.println();
		}
		
		for(int j=0;j<10;j++)
		{
				System.out.print(a[j]+"\t");
		}
	}
}
