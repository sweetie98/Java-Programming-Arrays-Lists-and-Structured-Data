/**
 * Programming Exercise: Object Oriented Caesar Cipher
 * Assignment 1: One Key
 * 
 * TestCaesarCipher to test examples that use the OneKeyCaesarCipher class, 
 * including writing a method that will automatically decrypt an encrypted file
 * by determining the key and then decrypting with that key.
 *  
 * @author (sweetie98) 
 * @version (12/08/2020)
 */
import edu.duke.*;
public class TestOnekeyCaesarCipher {
    
    private int[] countLetters(String message)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int counts[]=new int[26];
        for(int i=0;i<message.length();i++)
        {
            char ch= Character.toLowerCase(message.charAt(i));
            int index=alphabet.indexOf(ch);
            if(index!=-1)
                counts[index]++;
        }
        return counts;
    }
    
    
    private int maxIndex(int values[])
    {
        int max=0,index=-1;
        for(int i=0;i<values.length;i++)
        {
            if(max<values[i])
            {
                max=values[i];
                index=i;
            }
        }
        return index;
    }
    
    
    private String breakCaeserCipher(String input)
    {
        int[] freqs=countLetters(input);
        int index=maxIndex(freqs);
        int dKey=index-4;
        if(index<4)
            dKey=26-(4-index);
        System.out.println("The key is:"+dKey);
        OneKeyCaesarCipher cc=new OneKeyCaesarCipher(26-dKey);
        return cc.getEncryptedMessage(input);
    }
    
    
    public void simpleTests()
    {
        FileResource fr=new FileResource();
        OneKeyCaesarCipher cc=new OneKeyCaesarCipher(18);
        String encrypted=cc.getEncryptedMessage(fr.asString());
        System.out.println("Encrypted Message: "+encrypted);
        String decrypted=cc.getDecryptedMessage(encrypted);
        System.out.println("Decrypted Message: "+decrypted);
        String automaticDecryptedMessage = breakCaeserCipher(encrypted);
        System.out.println("Automatic Decrypted Message: "+automaticDecryptedMessage);
    }
}
