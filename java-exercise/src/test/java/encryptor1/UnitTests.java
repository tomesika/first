package encryptor1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import exceptions.InvalidEncryptionKeyException;
import exceptions.InvalidPathException;

public class UnitTests {
	ShiftUpEncryption test = Mockito.mock(ShiftUpEncryption.class);
	String path="C:\\tests\\";
	String dir_path="";
	FileOperations f=new FileOperations();
	
	
	/****************************Tests*****************************/
	
	
	/******************* 5 tests to check encryption**********************/
	 @Test
	 public void testsEncryptor() {
		 String[] results={"cdef",";<=>?","FfGgHh","$C&'(a)-+,",".gh;i."};
		 String content_path="";
		 String str="";
		 for(int i=1;i<=5;i++)
		 {
			 ShiftUpEncryption tester = new ShiftUpEncryption();
			 try 
			 {
				tester.makeEncryption(path+Integer.toString(i),false);
				content_path=path+Integer.toString(i)+"\\file_encrypted.txt";
				str= f.getFileContent(content_path);
			} 
			catch (InvalidPathException e) 
			{
				System.out.println(e.getMessage());
			}
			catch (InvalidEncryptionKeyException e)
			{
				System.out.println(e.getMessage());
			}
			 assertEquals(results[i-1],str);
		 }
	 }
	 
	 
	 /******************* 5 tests to check decryption**********************/
	 @Test
	 public void testsDeccryptor() {
		 String content_path="";
		 String s="",s1="";
		 for(int i=1;i<=5;i++)
		 {
			 ShiftUpEncryption tester = new ShiftUpEncryption();
			 dir_path=path+Integer.toString(i);
			 
			try 
			{
			tester.makeDecryption(dir_path+"\\file_encrypted.txt"
					 			  ,dir_path+"\\key.txt");
			content_path= path+Integer.toString(i)
				 	   +"\\file_encrypted_decrypted.txt";
			 s1= f.getFileContent(content_path);
			 s=f.getFileContent(path+Integer.toString(i)+"\\file.txt");
			 
			} 
			catch (InvalidEncryptionKeyException e) 
			{
				System.out.println(e.getMessage());
			}
			catch(InvalidPathException e)
			{
				System.out.println(e.getMessage());
			}
			 assertEquals(s,s1);
		 }	
	 }
	 
	 
	 
	 /**************** 5 tests for multiply encryption**************/
	 @Test
	 public void testsMulEncryptor() {
		 String[] results={"abcd","bdfhj","cciicc","cÀilor~x{","D¶¸^ºD"};
		 String content_path="",str="";
		 for(int i=6;i<=10;i++)
		 {
			ShiftMultiplyEncryption tester = new ShiftMultiplyEncryption();
			try 
			{
				tester.makeEncryption(path+Integer.toString(i),false);
				content_path=path+Integer.toString(i)+"\\file_encrypted.txt";
				str= f.getFileContent(content_path);
			} catch (InvalidEncryptionKeyException e) 
			{
				System.out.println(e.getMessage());
			}
			catch(InvalidPathException e)
			{
				System.out.println(e.getMessage());
			}
			 
			 assertEquals(results[i-6],str);
		 }
	 }
	
	 
	 /**************** 5 tests for multiply decryption**************/
	 @Test
	 public void testsMulDecryptor() {
		 String content_path="",s="",s1="";
		 for(int i=6;i<=10;i++)
		 {
			 ShiftMultiplyEncryption tester = new ShiftMultiplyEncryption();
			 dir_path=path+Integer.toString(i);
			 try 
			 {
				tester.makeDecryption(dir_path+"\\file_encrypted.txt"
						 			  ,dir_path+"\\key.txt");
				content_path= path+Integer.toString(i)
					 	   +"\\file_encrypted_decrypted.txt";
				 s1= f.getFileContent(content_path);
				 s=f.getFileContent(path+Integer.toString(i)+"\\file.txt");
			 } 
			 catch (InvalidEncryptionKeyException e) 
			 {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			 }
			 catch(InvalidPathException e)
			 {
				System.out.println(e.getMessage());
			 }
			 assertEquals(s,s1);
		 }
	 }
	 
	 

		/***************** 5 tests to check double encryption*****************/
		 @Test
		 public void testsDoubleEncryptor() {
			 String[] results={"@ABCD","JjKkLl",",K./0i1534","/hi<j/","rstu"};
			 String content_path="",str="";
			 for(int i=11;i<=15;i++)
			 {
				 ShiftUpEncryption enc = new ShiftUpEncryption();
				 DoubleEncryption tester=new DoubleEncryption(enc);
				 try 
				 {
					tester.makeEncryption(path+Integer.toString(i),false);
					content_path=path+Integer.toString(i)+"\\file_encrypted.txt";
					str= f.getFileContent(content_path);
				 } 
				 catch (InvalidEncryptionKeyException e) 
				 {
					System.out.println(e.getMessage());
				 }
				 catch(InvalidPathException e)
				 {
					System.out.println(e.getMessage());
				 }
				 assertEquals(results[i-11],str);			 
			 }
			
		 }
		 
		 /************** 5 tests to check double decryption**************/
		 @Test
		 public void testsDoubleDecryptor() {
			 String content_path="",s="",s1="";
			 for(int i=11;i<=15;i++)
			 {
				 ShiftUpEncryption enc = new ShiftUpEncryption();
				 DoubleEncryption tester=new DoubleEncryption(enc);
				 dir_path=path+Integer.toString(i);
				 try {
					tester.makeDecryption(dir_path+"\\file_encrypted.txt"
							 			  ,dir_path+"\\key.txt");
					content_path= path+Integer.toString(i)
						 	   +"\\file_encrypted_decrypted.txt";
					s1= f.getFileContent(content_path);
					s=f.getFileContent(path+Integer.toString(i)+"\\file.txt");
				} 
				catch (InvalidEncryptionKeyException e) 
				{
					System.out.println(e.getMessage());
				}
				catch(InvalidPathException e)
				{
					System.out.println(e.getMessage());
				}
				 assertEquals(s,s1);
			 }	
		 } 
		
		 
		 @Test(expected=InvalidEncryptionKeyException.class)
		 public void testsCheckInvalidKey() throws InvalidEncryptionKeyException 
		 {
			String content_path="";
			ShiftUpEncryption tester = new ShiftUpEncryption();
			try 
			{
				tester.makeEncryption(path+"16",false);
				content_path=path+"16\\file_encrypted.txt";
				f.getFileContent(content_path);
			} 
			
			catch (InvalidPathException e) 
			{
				System.out.println(e.getMessage());
			}
					 
		 }
		 
		 
		 @Test(expected=InvalidPathException.class)
		 public void testsCheckInvalidPath() throws InvalidPathException
		 {
			String content_path="";
			ShiftUpEncryption tester = new ShiftUpEncryption();
			try 
			{
				tester.makeEncryption(path+"1",false);
				content_path=path+"1\\abcd.txt";
				f.getFileContent(content_path);
			} 
			
			catch (InvalidEncryptionKeyException e) 
			{
				System.out.println(e.getMessage());
			}
		 }
		 
		 @Test
		 public void testsCompareKeys() 
		 {
			EncryptionAlgorithm tester = new ShiftUpEncryption();
			EncryptionAlgorithm tester2=new ShiftMultiplyEncryption();
			EncryptionAlgorithm tester3=new ShiftMultiplyEncryption();

			CompareKeys c=new CompareKeys();
			int flag=0;
			try 
			{
				tester.makeEncryption(path+"1",false);
				tester2.makeEncryption(path+"1",false);
				tester3.makeEncryption(path+"2",false);
				assertEquals(c.compare(tester, tester2),0);
				if(c.compare(tester, tester3)==0)
					flag=1;
				assertEquals(flag,0);
			} 
			catch (InvalidEncryptionKeyException e) 
			{
				System.out.println(e.getMessage());
			}
			catch (InvalidPathException e) 
			{
				System.out.println(e.getMessage());
			}

		 }

}
