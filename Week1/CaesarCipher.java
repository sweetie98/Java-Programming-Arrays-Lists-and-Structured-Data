/**
 * Programming Exercise: Implementing the Caesar Cipher
 * Assignment 2: Caesar Cipher
 * 
 * Caesar Cipher algorithm to encrypt messages.
 *
 * @author (sweetie98) 
 * @version (12/8/2020)
 */
import edu.duke.*;
public class CaesarCipher {
    
 public String encrypt (String input, int key) {
        StringBuilder encrypted = new StringBuilder (input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        
        for ( int i = 0; i < encrypted.length();i++){
        char currChar = encrypted.charAt(i);
        int idx = alphabet.indexOf(currChar);
        if (idx !=-1){
            char newChar = shiftedAlphabet.charAt(idx);
            encrypted.setCharAt(i,newChar);
        }
    } 
     return encrypted.toString();
   }
   
     
 public String encrypt_modified(String input, int key) {
        StringBuilder encrypted = new StringBuilder (input);
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = Alphabet.toLowerCase();
        String ShiftedAlphabet = Alphabet.substring(key)+ Alphabet.substring(0,key);
        String shiftedalphabet = alphabet.substring(key)+ alphabet.substring(0,key);
      
        for (int i = 0; i < encrypted.length();i++){
        char currChar = encrypted.charAt(i);
        if (Character.isLowerCase(currChar)) 
        {
            int idx = alphabet.indexOf(currChar);
            if (idx !=-1){
                char newChar = shiftedalphabet.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
        }
        
        else {
            int idx = Alphabet.indexOf(currChar);
            if (idx !=-1)
            {
                char newChar = ShiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }  
        } 
    }
     return encrypted.toString();
 }
    
public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder (input); 
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String ShiftedAlphabet1 = Alphabet.substring(key1)+ Alphabet.substring(0,key1);
        String shiftedalphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        String ShiftedAlphabet2 = Alphabet.substring(key2)+ Alphabet.substring(0,key2);
        String shiftedalphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
        
        for (int i = 0; i <encrypted.length();i+=2){
        char currChar = encrypted.charAt(i);
        if ((Character.isLowerCase(currChar))) {
                int idx = alphabet.indexOf(currChar);
            if (idx!= 0)
            {
                char newChar = shiftedalphabet1.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
        }
        else 
        {
                
            int idx = Alphabet.indexOf(currChar);
            if (idx != 0)
            {
                char newChar = ShiftedAlphabet1.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
        }
    }
    
    for (int i = 1; i <encrypted.length();i+=2){
        char currChar = encrypted.charAt(i);
        if ((Character.isLowerCase(currChar)))
        {
            int idx = alphabet.indexOf(currChar);
            if (idx != 0)
            {
                char newChar = shiftedalphabet2.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
        }
        else
        {
            int idx = Alphabet.indexOf(currChar);   
            if (idx != 0)
                {
                    char newChar = ShiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
        }         
    } 
    return encrypted.toString();
}


public void testEncrypt() {
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!",23));

  } 
    
public void testEncrypt_modified() { 
      System.out.println(encrypt_modified("First Legion",23));
      System.out.println(encrypt_modified("First Legion",17));
    } 
    
public void testencryptTwoKeys() {
        int key1 = 14;
        int key2 = 24;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encryptTwoKeys(message,key1,key2);
        System.out.println("Key1 is "+ key1 + " and Key2 is "+ key2 +"\n"+encrypted);
     
    }
    
public void testCaesar() {
       int key = 23;
       FileResource fr = new FileResource();
       String message = fr.asString();
       String encrypted = encrypt_modified(message, key);
       System.out.println("key is " + key + "\n" + encrypted);
    }
    
}
