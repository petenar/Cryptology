public class AdditiveCipher 
{
	
	//Petr Bowles		CS455 Cryptography and Network Security	
	//Midterm Project - AdditiveCipher.java
	//Simulates a brute force attack on an additive cipher.
//Displays every possible plaintext result by progressing through each //key choice.
//***********************************************************************//***********************
	public static void main(String[] args)
	{
		System.out.println("**********************************************************************************************\n"
+"Petr Bowles - CS455 Cryptography and Network Security\n"
+"Midterm Project - AdditiveCipher.java\n"
+"Simulates a brute force attack on an additive cipher.\n"
+"Displays every possible plaintext result by progressing through each key choice.\n"				  +"**********************************************************************************************\n");	

		String guess = "";
		String cipherText = "UOISCXEWLOBDOX";
                System.out.println("The Ciphertext is: " + cipherText);
		//array of characters we can use 
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
				'P','Q','R','S','T','U','V','W','X','Y','Z'};
				
		//try each key on the cipher text
		for(int key = 0; key < 26; key++)
		{
			for(int i = 0; i < cipherText.length(); i++)
			{
                            char encryptedChar = cipherText.charAt(i);//take char U
                            int encryptedValue = encryptedChar - 'A';// take U's value in ascii (85) and subract A from it to give us alphabet position
                            char decryptedChar;
                            int decryptedValue = (encryptedValue - key + 26)%26;
                            //System.out.print(decryptedValue);
                            decryptedChar = alphabet[decryptedValue];
                            //System.out.print(decryptedChar);
                            guess += decryptedChar;
			}
			System.out.print(guess + "\n"); //display each guess
			guess = "";
		}
	}//end main
}//end AdditiveCipher.java
