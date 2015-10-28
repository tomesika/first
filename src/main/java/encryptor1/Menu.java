package encryptor1;

import java.util.Scanner;

import exceptions.InvalidEncryptionKeyException;
import exceptions.InvalidPathException;

public class Menu {
	static Scanner in =new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.println("Choose an option");
		System.out.println("1-for Encription");
		System.out.println("2-for Description");
		System.out.println("3-for exit");
		int option=in.nextInt();
		String path="";
		Algorithm a=null;
		switch(option)
		{
		//for case of encryption
		case 1:
			System.out.println("enter path of the input file");
			path=in.next();
			a=new Encryption(path);
			try 
			{
				a.makeAction();
			} catch (InvalidPathException e1) 
			{
				System.out.println(e1.getMessage());
			}
			break;
		//for case of decryption
		case 2:
			System.out.println("enter path of the input file");
			path=in.next();
			System.out.println("enter path of the key file");
			String key_path=in.next();
			try 
			{
				a=new Decryption(path,key_path);
			} catch (InvalidEncryptionKeyException e) 
			{
				System.out.println(e.getMessage());
			}
			try 
			{
				a.makeAction();
			} catch (InvalidPathException e) 
			{
				System.out.println(e.getMessage());
			}
			break;
		default:
			System.exit(0);
		}
	}

}
