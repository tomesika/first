package encryptor1;

import java.io.*;

import exceptions.InvalidPathException;


public class FileOperations 
{
	public String getFileContent(String path) throws InvalidPathException
	{
		//open the file
		FileInputStream fileStream;
		try 
		{
	
			fileStream = new FileInputStream(path);
			DataInputStream input=new DataInputStream(fileStream);
			BufferedReader br=new BufferedReader(new InputStreamReader(input));
			String line=br.readLine();
			String content="";
			while(line!=null)
			{
				content+=line;
				line=br.readLine();
				
			}
			//close the file
		  	br.close();		
		  	return content;
		}
	  	catch (Exception e)
	  	{
	  		throw new InvalidPathException();
	  	}		
	}
	
	public void writeToFile(String path,String content) throws InvalidPathException
	{
		//create the output file
		File file = new File(path);
		try 
		{
			try
			{
				file.createNewFile();
			}
			catch(Exception e)
			{
				throw new InvalidPathException();
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			//write the string into the file
			output.write(content);
			output.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}
