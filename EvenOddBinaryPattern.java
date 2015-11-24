class EvenOddBinaryPattern
{
	public static void main (String[] args) 
	{
		int a,b;
		for(int i=1;i<=5;i++)
		{
			if(i%2==0)
			{
				a=0;
				b=1;
			}
			else
			{
				a=1;
				b=0;
			}
			for(int j=1;j<=i;j++)
			{
				if(j%2!=0) 
					System.out.print(a);
				else
					System.out.print(b);
			}
			System.out.println();
		}
	}
}