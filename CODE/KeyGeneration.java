package elGamal;

import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import static java.lang.Math.*;

public class KeyGeneration {
	private BigInteger p;
    private BigInteger g;
    private BigInteger SECRETKEY;
    private BigInteger b;
    private int pval[]={151,157,163,167,179,};
    private int xval[]={45,47,49,51,53,57};
    
    public void generatekeys()
    {
         Scanner stdin = new Scanner(System.in);
         Random r = new Random();
         double ran=  random();
         int ran2=(int) ((ran*100)%5);
         ran2=1;
         p = BigInteger.valueOf(pval[ran2]);
         g = getGenerator(p, r);
         if (g != null)
         {
        	 SECRETKEY = BigInteger.valueOf(xval[ran2]);
        	 b = g.modPow(SECRETKEY, p);
        	 System.out.println("\nPublic keys:: P = "+p+" G = "+g+" B = "+b +"\nSecret Key :: "+SECRETKEY);
         }
         else
        	 System.out.println("Sorry, a generator for your prime couldn't be found.");
    }
    
    public static BigInteger getNextPrime(String ans)
    {
		BigInteger one = new BigInteger("1");
		BigInteger test = new BigInteger(ans);
		while (!test.isProbablePrime(99))
			test = test.add(one);
		return test;		
	}

	public static BigInteger getGenerator(BigInteger p, Random r)
	{
		int numtries = 0;
		while (numtries < 1000)
		{
			BigInteger rand = new BigInteger(p.bitCount()-1,r);
    		BigInteger exp = BigInteger.ONE;
    		BigInteger next = rand.mod(p);
            while (!next.equals(BigInteger.ONE))
            {
      			next = (next.multiply(rand)).mod(p);
      			exp = exp.add(BigInteger.ONE);
    		}
    		if (exp.equals(p.subtract(BigInteger.ONE)))
      			return rand;
      	}
        return null;
	}
	public BigInteger getp()
	{ return p;}
    public BigInteger getg()
    { return g;}
    public BigInteger getb()
    { return b;}
    public BigInteger getSecretkey()
    { return SECRETKEY;}
        
}