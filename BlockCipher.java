public class BlockCipher
{
	//***********************************************************************	
        //Petr Bowles		CS455 Cryptography and Network Security		
	//Midterm Project Programming Question 3	- BlockCipher.java
	//Encodes a string of ascii characters to hex format using a block cipher.
        //After the given initial vector each 8 bit block will be encrypted using the //previous 8 bits.
	//Program displays the final encrypted hex message.
	//***********************************************************************

	public static void main(String[] args) 
	{
		String message = "HTTP/1.1"; //original message
		String key = "10001001"; //initial vector
		String nextKey = "";	//key used for next block
		String messageBin = ""; //original message in binary
		String encryptedBin = ""; //encrypted binary message
		String encryptedHex = ""; //encrypted hex message
				System.out.println("***************************************************************************************\n"
+"Petr Bowles		CS455 Cryptography and Network Security\n"
+"Midterm Project Programming Question 3 - BlockCipher.java\n"
+"Encodes a string of ascii characters to hex format using a block cipher.\n"
+"After the given initial vector each 8 bit block will be encrypted using the previous\n"
+"8 bits.\n"
+"Program displays the final encrypted hex message.\n"			
+"***************************************************************************************\n");
		
System.out.println("Encrypting \""+ message +"\" using initial vector \"" + key +"\".");
		
		//convert original message to binary
		//--------------------------------------------------
               System.out.println("Step 1 - Convert message to binary:");
               char[] charMessage = message.toCharArray();
               for(int i =0; i<charMessage.length; i++){
                   char m = charMessage[i];
                   int asciiValue = (int) m;
                   String binaryRepresentation = String.format("%8s", Integer.toBinaryString(asciiValue)).replace(' ', '0');
                   System.out.print(binaryRepresentation);
               }
               System.out.println();
               System.out.println("Step 2 - Convert binary to 8-bit blocks:");
               for(int i =0; i<charMessage.length; i++){
                   char m = charMessage[i];
                   int asciiValue = (int) m;
                   String binaryRepresentation = String.format("%8s", Integer.toBinaryString(asciiValue)).replace(' ', '0');
                   System.out.print(binaryRepresentation + " ");
               }
               System.out.println();
		//end convert to binary
		
//---------------------------------------------------
		
		//XOR in 8 bit blocks beginning with initial vector
		//current 8 bit block becomes key for next block
		//-------------------------------------------------------
                System.out.println("Step 3 - Start with the initial vector (key is updated after XOR):");
                int binaryKey = Integer.parseInt(key, 2);
                System.out.print(key + " ");
                for(int i = 0; i<charMessage.length-1; i++){
                   char currentChar = charMessage[i]; //get our current character
                   int asciiValue = (int) currentChar;//get the current character in ASCII
                   //String binaryAsciiRep = String.format("%8s", Integer.toBinaryString(asciiValue)).replace(' ', '0');
                   //String binaryKeyRep = String.format("%8s", Integer.toBinaryString(binaryKey)).replace(' ', '0');
                   //System.out.println(binaryAsciiRep + " XOR " + binaryKeyRep);
                   int encryptedValue = (asciiValue ^ binaryKey);
                   String binaryEncryptRep = String.format("%8s", Integer.toBinaryString(encryptedValue)).replace(' ', '0');
                   System.out.print(binaryEncryptRep+" ");
                   binaryKey = encryptedValue;

               }
           
                System.out.println(" ");
                
                System.out.println("Step 4 - XOR the binary block and the key:");
		//end xor
		//-----------------------------------------------------------------------
                binaryKey = Integer.parseInt(key, 2);
		for(int i = 0; i<charMessage.length; i++){
                   char currentChar = charMessage[i]; //get our current character
                   int asciiValue = (int) currentChar;//get the current character in ASCII
                   //String binaryAsciiRep = String.format("%8s", Integer.toBinaryString(asciiValue)).replace(' ', '0');
                   //String binaryKeyRep = String.format("%8s", Integer.toBinaryString(binaryKey)).replace(' ', '0');
                   //System.out.println(binaryAsciiRep + " XOR " + binaryKeyRep);
                   int encryptedValue = (asciiValue ^ binaryKey);
                   String binaryEncryptRep = String.format("%8s", Integer.toBinaryString(encryptedValue)).replace(' ', '0');
                   System.out.print(binaryEncryptRep + " ");
                   binaryKey = encryptedValue;

               }
                System.out.println(" ");
		//convert encrypted binary string to hex string
		//---------------------------------------------------------------------------
                System.out.println("Step 5 - Convert encrypted binary to hex:");
                binaryKey = Integer.parseInt(key, 2);
		for(int i = 0; i<charMessage.length; i++){
                   char currentChar = charMessage[i]; //get our current character
                   int asciiValue = (int) currentChar;//get the current character in ASCII
                   //String binaryAsciiRep = String.format("%8s", Integer.toBinaryString(asciiValue)).replace(' ', '0');
                   //String binaryKeyRep = String.format("%8s", Integer.toBinaryString(binaryKey)).replace(' ', '0');
                   //System.out.println(binaryAsciiRep + " XOR " + binaryKeyRep);
                   int encryptedValue = (asciiValue ^ binaryKey);
                   String binaryHexRep = String.format("%02X", encryptedValue & 0xFF);
                   System.out.print(binaryHexRep + " ");
                   binaryKey = encryptedValue;

               }
                System.out.println(" ");
		//end convert to hex
                System.out.println("Encrypted Message:\n" + encryptedHex);
//--------------------------------------------------------------------------------
                binaryKey = Integer.parseInt(key, 2);
		for(int i = 0; i<charMessage.length; i++){
                   char currentChar = charMessage[i]; //get our current character
                   int asciiValue = (int) currentChar;//get the current character in ASCII
                   //String binaryAsciiRep = String.format("%8s", Integer.toBinaryString(asciiValue)).replace(' ', '0');
                   //String binaryKeyRep = String.format("%8s", Integer.toBinaryString(binaryKey)).replace(' ', '0');
                   //System.out.println(binaryAsciiRep + " XOR " + binaryKeyRep);
                   int encryptedValue = (asciiValue ^ binaryKey);
                   String binaryHexRep = String.format("%02X", encryptedValue & 0xFF);
                   System.out.print(binaryHexRep);
                   binaryKey = encryptedValue;

               }
                System.out.println(" ");
	}//end main()
}//end BlockCipher.java
