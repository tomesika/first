package exceptions;

public class InvalidPathException extends Exception
{
	//exception for case of invalid path of the input file
	public InvalidPathException()
	{
		super("The given file path is invalid");
	}
}
