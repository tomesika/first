package encryptor1;

import java.util.Comparator;

public class CompareKeys implements Comparator<EncryptionAlgorithm>
{
	//comparator which compares between 2 encryption algorithms by their key
	public int compare(EncryptionAlgorithm o1, EncryptionAlgorithm o2) 
	{
		return o1.getKeyStrength()-o2.getKeyStrength();
	}

}
