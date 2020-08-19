/**
 * Programming Exercise:Breaking the Caesar Cipher
 * Assignment 2: Caesar Cipher Two Keys Decrypt
 * 
 * Decrypts a message that was encrypted with one Key, using 
 * statistical letter frequencies of English text. Then add code 
 * to be able to decrypt a message that was encrypted with two Keys, using
 * ideas from the Single key decryption method and the encryption with two
 * keys method from the program in the last lesson.
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */
import edu.duke.*;
public class CaesarBreaker {
    
    public int[] CountLetters(String message) {
         String alphabet = "abcdefghijklmnopqrstuvwxyz";
         int[] counts = new int[26];
         for(int i=0; i < message.length();i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int index = alphabet.indexOf(ch);
            if(index!=-1) {
                counts[index]++;
            }
         }
        return counts;
    }
    
    public int maxIndex(int[] values) {
        int max = 0;
        int index = 0;
        for(int i = 0;i <values.length;i++) {
            if (values[i]> max) {
            max = values[i];
            index = i;
            }
        }
        return index; 
    }
    
    public String decrypt(String encrypted) {
      CaesarCipher cc= new CaesarCipher();
      int[] freqs=CountLetters(encrypted);
      int maxDex=maxIndex(freqs);
      int dkey=maxDex-4;
      if(maxDex < 4)
            dkey=26-(4-maxDex);
            
      return cc.encrypt(encrypted,26-dkey);
    }
    
    public void testDecrypt() {
        int key = 22;
        FileResource fr = new FileResource("data/wordsLotsOfEs.txt");
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher();
        String encrypted = cc.encrypt(message,key);
        String decrypted = decrypt(encrypted);
        System.out.println("Key is"+ key);
        System.out.println("Actual message is: "+message);
        System.out.println("Encrypted message is: "+encrypted);
        System.out.println("Decrypted message is: "+decrypted);
    
    }
    
     public String halfOfString(String message, int start){
        String str = "";
        for (int i = start; i< message.length();i+=2) {
          str += String.valueOf(message.charAt(i));
        }
        return str;
    }
    
    
    public void testHalfOfString() {
       System.out.println(halfOfString("Qbkm Zgis", 0));
       System.out.println(halfOfString("Qbkm Zgis", 1));
    }
    
    
    public int getKey(String s) {
       int[] freqs = CountLetters(s);
       int maxDex = maxIndex(freqs);
       int dKey = maxDex - 4;
       if (maxDex < 4) {
           dKey = 26 - (4 -maxDex);
       }
       return dKey;
        
    }
    
     public String decryptTwoKeys(String encrypted)
    {
        int key1,key2;
        String even=halfOfString(encrypted,0);
        String odd=halfOfString(encrypted,1);
        key1=getKey(even);
        key2=getKey(odd);
        CaesarCipher cc=new CaesarCipher();
        System.out.println("The keys are:"+key1+" and "+key2);
        return cc.encryptTwoKeys(encrypted,26-key1,26-key2);
    }
    
    public void testDecryptTwoKey()
    {
        FileResource fr=new FileResource();
        CaesarCipher cc=new CaesarCipher();
        String encrypted =fr.asString();
        System.out.println("Encrypted Message: "+encrypted);
        System.out.println("Decrypted Message:"+decryptTwoKeys(encrypted));
    }
}
