package encryptor1;

import exceptions.InvalidEncryptionKeyException;
import exceptions.InvalidPathException;

public class FileEncryptor
{
	EncryptionAlgorithm algo=null;
	
	/***constructor- gets encryptor algorithm and make actions using it ****/
	public FileEncryptor(EncryptionAlgorithm a)
	{
		algo=a;
	}
	
	// making the encryption action using the algorithm
	public void makeEncription(String path)
			throws InvalidEncryptionKeyException, InvalidPathException 
	{
		algo.makeEncryption(path,true);
	}

	//make decryption using the algorithm
	public void makeDecryption(String path,String key_path) 
			throws InvalidEncryptionKeyException, InvalidPathException
	{
		algo.makeDecryption(path, key_path);
	}
}
