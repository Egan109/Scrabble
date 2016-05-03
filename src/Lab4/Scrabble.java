/*
 * Scabble letter checker, checks and prints the top 10 best words to use in scrabble
 *  with a given inputed String of letters
 * @author Brendan Egan
 */
package Lab4;
import java.util.*;

public class Scrabble {
    public static void main (String argz[])
    {
    Scanner scan=new Scanner(System.in);
    FileIO reader = new FileIO();
    String[] dic = reader.load("words.txt");
    System.out.println("enter your letters");
    String letters= scan.nextLine();
  
    while(!letters.equalsIgnoreCase("stop"))
    {
    	  long startTime = System.nanoTime();
    	  String[] in = new String[10];
    for(int i=0;i<dic.length;i++)
    {
    		String word=dic[i].trim();
        if(word.length()>(letters.length()))//if the word is longer then the inputed letters do nothing
        	{
        	}
        else
        	{
        	int wrong=(letters.length())-(word.length());//checking allowable wrong matches
        	int count=0;                
            for(int x=0;x<letters.length();x++)//going throught the letters
                {
            		int count2=0;
                	int nomatch=0;
                		for(int y=0;y<word.length();y++)
                		{
                			if(word.charAt(y)==letters.charAt(x))
                			{    
                				count2++;
                				//if they match do nothing
                			}
                			else
                			{
                				nomatch++;//
                			}
                    }
                if(nomatch==word.length())//no matches for current letter
                    {
                		count++;//no letter matches the letter its looking at
                    if(count>wrong)//checks if the allowable amount of wrong matches has been reached
                    	{
                    		break;//stops the loop
                    	}
                    	}
                else
                    { //at least one match if it gets here
                    if(x==(letters.length()-1))//if on last letter of the inputed word
                        {
                    		int check=0;
                        	int check1=0;
                        for(int c=0;c<10;c++)//check if all letters in the dictionary word are in the inputed letters
                        {                            
                            if( in[c]== null ||in[c].length()<word.length())
                            {
                                for(int h=0;h<word.length();h++)
                                {
                                    
                                    	int count9=0;
                                    for(int g=0;g<letters.length();g++)
                                    {
                                        if(word.charAt(h)==letters.charAt(g))
                                        	{
                                        	count9++;
                                        	}
                                    }
                                    if(count9==0)
                                    {
                                        check1++;
                                    }
                                }
                                
                                if(check==0 && check1==0)
                                	{
                                		String place=in[c];
                                		in[c]=word;
                                		check++;//to ensure a word is isued once     	
                                for(int p=0;p<10;p++)//shifts words down array
                                {
                                    if(place == null || in[p] == null)
                                    {
                                        break;
                                    }
                                    else{
                                        if(place.length()>in[p].length())
                                        {
                                        	String place1=in[p];
                                        	in[p]=place;
                                        	place=place1;
                                        }
                                    }
                                }
                              }
                            }
                         }
                       }
                    }
                }
        }
    }
    for(int i=0;i<10;i++)
    {
        System.out.println(in[i]);
       }
    long endTime = System.nanoTime();
    System.out.println("Took "+(endTime - startTime) + " ns");
    
    System.out.println("enter new letters\nenter stop to stop program");
    letters= scan.nextLine();
    }
    System.out.println("program has ended \ngoodbye!");
}
}

 