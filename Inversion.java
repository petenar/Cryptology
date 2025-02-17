/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crytp;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Petr
 */
public class Inversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the encryption key (7 digits): ");
        String encryptionKey = scanner.nextLine();

        if (encryptionKey.length() != 7 ) {
            System.out.println("Invalid input. Please enter a 7-digit numeric encryption key.");
        } else {
            
            int[] keyArray = new int[encryptionKey.length()];//create an array of ints equal to the length of our string
            
            for(int i=0; i <encryptionKey.length();i++){ 
                keyArray[i] = Integer.parseInt(String.valueOf(encryptionKey.charAt(i)));//add each value of our array string to the integer string converted to an int
            }
            
            Arrays.sort(keyArray);//call the sort function for our new array
            
            char[] decryptionKeyArray = new char[keyArray.length];//create an array to store our ints, converted back to a string
            
            for(int i=0; i <keyArray.length;i++){
                decryptionKeyArray[i] = (char) (keyArray[i] + '0');//convert the numeric value of our int back to a string and offset by the ascii value of "0"
            }
            System.out.println("Encryption Key: " + encryptionKey);
            System.out.println("Decryption Key: " + String.valueOf(decryptionKeyArray));
        }

        scanner.close();
    }
    
}
