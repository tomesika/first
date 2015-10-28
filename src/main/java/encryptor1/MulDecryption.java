package encryptor1;

import exceptions.InvalidEncryptionKeyException;
import exceptions.InvalidPathException;

public class MulDecryption extends Algorithm
{
	/********* constructor ********/
	public MulDecryption(String path,String key_path) throws InvalidEncryptionKeyException
	{
		super(path);
		try
		{
			setKey(Integer.parseInt(getFp().getFileContent(key_path)));
		}
		catch(Exception e)
		{
			throw new InvalidEncryptionKeyException();
		}
		setType("decrypted");
	}
	
	//specific action for decryption- devide the key value from the letter
	public char doAction(char curr)
	{
		return (char) ((curr/getKey())%256);
	}

	//write the results of decryption into file and write proper message to the user
	public void finishAction() throws InvalidPathException 
	{
		String message="the decryptefd file is in path: ";
		writeResult(message);
	}
}
