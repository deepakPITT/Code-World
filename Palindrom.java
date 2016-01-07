import java.io.Console;
class Palindrom
{
	public static void main(String args[])
	{
		System.out.println("enter the three digit no");
		Console con=System.console();
		int n=Integer.parseInt(con.readLine());
		int a=n,rev=0;
		int i=0;
		while(i<=2)
		{
			int b=n%10;
			n=n/10;
			rev=rev*10+b;
			i++;
		}
	if(a==rev)
		System.out.println("the no is palindrome");
	else
		System.out.println("the no is not palindrome");
	}
}			