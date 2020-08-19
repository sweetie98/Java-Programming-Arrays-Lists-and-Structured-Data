
/**
 * Programming Exercise: Object Oriented Caesar Cipher
 * Assignment 2: Two Keys
 * 
 * TwoKeyCaesarCipher class that encrypts a message with two keys 
 * (the same way as the previous lesson: key1 is used to encrypt every other letter,
 * starting with the first, and key2 is used to encrypt every other letter, starting with the second),
 * and also decrypts the same message.
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */
public class TwoKeyCaesarCipher {
    private String alphabets;
    private String shiftedAlphabets1;
    private String shiftedAlphabets2;
    private int key1,key2;
    
    
    public TwoKeyCaesarCipher(int key1,int key2)
    {
        this.key1=key1;
        this.key2=key2;
        alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabets1 = alphabets.substring(key1) +
                        alphabets.substring(0,key1);
        
        shiftedAlphabets2 = alphabets.substring(key2) +
                        alphabets.substring(0,key2);
    }
    
    
    private String encrypt(String input)
    {
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0;i < sb.length(); i++)
        {
            char newChar=sb.charAt(i);
            boolean upperCase = Character.isUpperCase(newChar);
            newChar=Character.toUpperCase(newChar);
            int index=alphabets.indexOf(newChar);
            if(index!=-1)
            {
                if(i%2==0)
                    newChar=shiftedAlphabets1.charAt(index);
                else
                    newChar=shiftedAlphabets2.charAt(index);
            }
            if(!upperCase)
                newChar=Character.toLowerCase(newChar);
            sb.setCharAt(i,newChar);
        }
        return sb.toString();
    }
    
    
    private String decrypt(String input)
    {
        TwoKeyCaesarCipher cc = new TwoKeyCaesarCipher(26-key1,26-key2);
        return cc.encrypt(input);
    }
    
    
    public String getEncryptedMessage(String input)
    {
        return encrypt(input);
    }
    
    
    public String getDecryptedMessage(String input)
    {
        return decrypt(input);
    }
}
