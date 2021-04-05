import java.util.Scanner;
// Q-2: Check Palindrome: 
// Logic: // Reverse the string and if it equals original then string is palindrome

public class PalindromeString 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("\n Enter the string");
		String s = scan.nextLine();
		StringBuilder sb = new StringBuilder(s);
		String rev = sb.reverse().toString();
		if(s.equals(rev))
		{
			System.out.println("\n String "+s+" is a palindrome");
		}
		else
		{
			System.out.println("\n String "+s+" is not a palindrome");
		}

	}

}
