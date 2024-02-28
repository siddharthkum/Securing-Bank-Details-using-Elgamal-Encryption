package elGamal;

import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class ElGamal{
		
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		KeyGeneration k=new KeyGeneration();
        k.generatekeys();
        System.out.println("\n***Encryption Has Started***");
        Encryption E=new Encryption();
        long encstart=System.currentTimeMillis();
        E.Encrypt(k.getp(),k.getg(),k.getb(),k.getSecretkey());
        long encend=System.currentTimeMillis();
        System.out.println("\n\n***ENCRYPTION DONE***");
        Decryption d=new Decryption();
        long start=System.currentTimeMillis();
        d.decrypt(k.getp(),k.getSecretkey(), null);
        long end=System.currentTimeMillis();
        long diff=end-start;
        long diff2=encend-encstart;
        System.out.println("\n\n"+diff2+"\tMilli Seconds for Encryption"+"\n"+diff+"\tMilli Seconds for Decryption");
	}
}