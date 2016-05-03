/*
 * frequency encoder for an inputted String
 * @author Brendan Egan
 */




package Lab4;
import java.util.Arrays;
import java.util.Scanner;


public class Q 
{

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		System.out.println(in);
		char[] work = new char[in.length()];

		for(int i =0;i<in.length();i++)
		{
			work[i] = in.charAt(i);
		}
		Arrays.sort(work);
		//System.out.println(Arrays.toString(work));
		int count = 0;
		
		for(int i = 0; i< in.length()-1;i++)
		{
			if( work[i]!=work[i+1])
			{
				count++;
			}
		}
		
		int[] amount = new int[count+1];
		char[] letter = new char[count+1];
		int place = 0;
		count = 1;		
		for(int i = 0; i< in.length()-1;i++)
		{
			if( work[i]==work[i+1] )
			{
				count++;
			}
			else
			{
				amount[place] = count;
				count = 1;
				letter[place] = work[i];
				place++;
			}
		}
		amount[place]=count;
		letter[place] = work[in.length()-1];
		
		System.out.println(Arrays.toString(letter));
		System.out.println(Arrays.toString(amount));
		
		int max = 0;
		for(int i = 0;i<letter.length;i++)
		{
			if(max<amount[i])
			{
				max = amount[i];
			}
		}
		
		while(max>0)
		{
			for(int i = 0;i<amount.length;i++)
			{
				if(amount[i]==max)
				{
					System.out.print(letter[i]);
				}
			}
			max--;
		}
		
		sc.close();
	}
}
