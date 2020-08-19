/**
 * Programming Exercise: Object Oriented Caesar Cipher
 * Assignment 2: Two Keys
 * 
 * TestTwoKeyCaesarCipher to test examples that use the TwoKeyCaesarCipher class,
 * including writing a method that will automatically decrypt an encrypted file by
 * determining the two keys that were used to encrypt it.
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */
import edu.duke.*;

public class TestTwoKeyCaesarCipher {
    
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
    
    
    private String halfOfString(String message, int start)
    {
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(int i=start;i<message.length();i++)
        {
            if(count%2==0)
                sb.append(message.charAt(i));
            count++;
        }
        return sb.toString();
    }
    
    
    public void simpleTests()
    {
        FileResource fr=new FileResource();
        TwoKeyCaesarCipher cc=new TwoKeyCaesarCipher(17,3);
        String encrypted=cc.getEncryptedMessage(fr.asString());
        System.out.println("Encrypted Message: "+encrypted);
        String decrypted=cc.getDecryptedMessage(encrypted);
        System.out.println("Decrypted Message: "+decrypted);
        String automaticDecryptedMessage = breakCaeserCipher(encrypted);
        System.out.println("Automatic Decrypted Message: "+automaticDecryptedMessage);
    }
    
    
    private int getKey(String s)
    {
        int counts[]=countLetters(s);
        int index=maxIndex(counts);
        int dKey=index-4;
        if(index < 4)
            dKey=26-(4-index);
        return dKey;
    }
    
    
    private String breakCaeserCipher(String input)
    {
        String firstHalf = halfOfString(input,0);
        String secondHalf = halfOfString(input,1);
        int key1=getKey(firstHalf);
        int key2=getKey(secondHalf);
        System.out.println("The keys are:"+key1+" and "+key2);
        TwoKeyCaesarCipher cc=new TwoKeyCaesarCipher(26-key1,26-key2);;
        return cc.getEncryptedMessage(input);
    }
}
