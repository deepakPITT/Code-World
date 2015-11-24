import java.io.Console;
class Factorial
{	
	public static void main(String args[])
	{	
	    System.out.println("enter the no to be factorized");
	    Console con=System.console();
	    int n=Integer.parseInt(con.readLine());
	    int fact=1;
	    while(n!=0)
		{
			fact=fact*n;
			n--;
		}
		System.out.println("the factorial no is ");
		System.out.println(fact);
	}
}