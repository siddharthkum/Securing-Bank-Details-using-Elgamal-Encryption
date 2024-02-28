package elGamal;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.BigInteger;

public class Decryption {
    
	String s1="",s2="";
    FileWriter f1,f2,f3;
            
    public void decrypt(BigInteger p,BigInteger secretkey,String file)
    {
        try
        {
            f2=new FileWriter("C:\\Users\\Siddharth Kumar\\eclipse-workspace\\elGamal\\output of project\\second_decryption.txt");
            f3=new FileWriter("C:\\Users\\Siddharth Kumar\\eclipse-workspace\\elGamal\\output of project\\decrypted.txt");
            f1=new FileWriter("C:\\Users\\Siddharth Kumar\\eclipse-workspace\\elGamal\\output of project\\first_decrytpion.txt");
            String substring="";
            int j=0,sk=secretkey.intValue();
            try
            {
            	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Siddharth Kumar\\eclipse-workspace\\elGamal\\output of project\\Encryption.txt"));
            	String line;
            	while ((line = br.readLine()) != null) 
            	{
            		int i=0;j=0;
            		for(i=0;i<48;i=i+3)
            		{
            			if(j<8)
            			{
            				substring=line.substring(i,i+3);
            				int a=Integer.parseInt(substring);
            				int bit=(a%sk)%2;
            				s1=s1+Integer.toString(bit);
            				j++;
            			}
            			else
            			{
            				substring=line.substring(i,i+3);
            				int a=Integer.parseInt(substring);
            				int bit=(a%sk)%2;
            				s2=s2+Integer.toString(bit);
            				j++;
            			}
            			if(j==8);
            		}
            		BigInteger c1,c2;
            		f1.write("INPUT IS = "+line+" BINARY - "+s1+"   "+s2+"\n");
            		f1.flush();
            		int a1=binaryToInteger(s1);
            		int a2=binaryToInteger(s2);
            		c1=BigInteger.valueOf(binaryToInteger(s1));
            		c2=BigInteger.valueOf(binaryToInteger(s2));
            		f2.write("BINARY  "+s1+"  "+s2+"\tC1="+c1+"\tC2="+c2+"\n");
            		f2.flush();
            		BigInteger temp = c1.modPow(secretkey,p);
            		temp = temp.modInverse(p);
            		BigInteger recover = temp.multiply(c2);
            		recover = recover.mod(p);
            		char ch=(char)recover.intValue();
            		f3.write(ch);
            		f3.flush();
            		s1="";
            		s2="";       
            	}
            }
            catch(Exception e){e.printStackTrace();}
        }
        catch(Exception e){System.out.println("EXCEPTION AT DECRYPTED FILE");}
    }
    
    public int binaryToInteger(String binary)
    {
    char[] numbers = binary.toCharArray();
    int result = 0;
    for(int i=numbers.length - 1; i>=0; i--)
        if(numbers[i]=='1')
            result += Math.pow(2, (numbers.length-i - 1));
    return result;
    }
}
