package encryptor1;

import exceptions.InvalidEncryptionKeyException;
import exceptions.InvalidPathException;

public class DoubleEncryption implements EncryptionAlgorithm 
{
	EncryptionAlgorithm a=null;
	FileOperations fp=null;
	
	/**** constructor ****/
	public DoubleEncryption(ShiftUpEncryption e)
	{
		a=e;
		fp=new FileOperations();
	}
	
	//making action of double encryption (using two different keys)
	public void makeEncryption(String path,boolean random) 
			throws InvalidEncryptionKeyException, InvalidPathException 
	{
			String origin="";
			//make the first encryption -with the first key
			a.makeEncryption(path,random);
			//if using random key
			if(random)
			{
				String[] seperatedPath=path.split("\\\\");
				int len=seperatedPath.length;
				String only_path="";
				for(int i=0;i<len-1;i++)
				{
					only_path+=seperatedPath[i]+"\\";
				}	
				fp.writeToFile(only_path+"key2.txt",
								fp.getFileContent(only_path+"key.txt"));
				origin= fp.getFileContent(path);
				fp.writeToFile(path,fp.getFileContent(fp.getFileContent
						(only_path+"\\file_encrypted.txt")));
			}
			//using existing key- for unit tests case
			else
			{
				swapFilesContent(path);
				origin=fp.getFileContent(path+"\\file.txt");
				fp.writeToFile(path+"\\file.txt",fp.getFileContent
				        (path+"\\file_encrypted.txt"));
			}
			//make second encryption with the second key
			a.makeEncryption(path,random);
			if(random)
				fp.writeToFile(path,origin);
			else
				fp.writeToFile(path+"\\file.txt",origin);
			
	}
		
	//get the path of 2 files- key1 and key2 and swap their values
	private void swapFilesContent(String path) throws InvalidPathException
	{
		String str=fp.getFileContent(path+"\\key.txt");
		fp.writeToFile(path+"\\key.txt", fp.getFileContent(path+"\\key2.txt"));
		fp.writeToFile(path+"\\key2.txt", str);
	}

	//making action of double decryption using the 2 given different keys
	public void makeDecryption(String path, String key_path) 
			throws InvalidEncryptionKeyException, InvalidPathException 
	{	
		//first decryption using the first key
		a.makeDecryption(path, key_path);
		String[] seperatedPath=path.split("\\\\");
		int len=seperatedPath.length;
		String only_path="";
		for(int i=0;i<len-1;i++)
		{
			only_path+=seperatedPath[i]+"\\";
		}		
		String saved_key=fp.getFileContent(key_path);
		fp.writeToFile(key_path, fp.getFileContent(only_path+"key2.txt"));
		fp.writeToFile(only_path+"key2.txt", saved_key);
		String content=fp.getFileContent(only_path+"file_encrypted.txt");
		//set the encrypted_file value to the content after first decryption
		fp.writeToFile(only_path+"file_encrypted.txt", fp.getFileContent				
				(only_path+"file_encrypted_decrypted.txt"));	
		//second decryption
		a.makeDecryption(path, key_path);
		fp.writeToFile(only_path+"file_encrypted.txt",content);
	}

	//calculate key strength- number of digits
	public int getKeyStrength() 
	{
		return a.getKeyStrength();
	}
	
}
