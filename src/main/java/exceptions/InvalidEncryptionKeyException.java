package exceptions;

public class InvalidEncryptionKeyException extends Exception
{
	// exception for case of key which has invalid value (not an number)
	public InvalidEncryptionKeyException()
	{
		super("The encryption key is invalid");
	}
}
