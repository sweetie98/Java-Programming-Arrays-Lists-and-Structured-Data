
/**
 * Programming Exercise: Object Oriented Caesar Cipher
 * Assignment 1: One Key
 * 
 * In this assignment, put together the CaesarCipher class 
 * from the lesson and add a decrypt method to decrypt with the same key. 
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */
public class OneKeyCaesarCipher {
    
    private String alphabets;
    private String shiftedAlphabets;
    private int mainKey;
    
    OneKeyCaesarCipher(int key)
    {
        mainKey=key;
        alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabets = alphabets.substring(key) +
                        alphabets.substring(0,key);
    }
    
    
    private char encryptCharacter(char ch)
    {
        int index = alphabets.indexOf(Character.toUpperCase(ch));
        if(index != -1)
        {
            char newChar = shiftedAlphabets.charAt(index);
            if(Character.isLowerCase(ch))
                newChar = Character.toLowerCase(newChar);
            return newChar;
        }
        return ch;
    }
    
    
    private String encrypt(String input)
    {
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0;i < sb.length(); i++)
        {
            char newChar = encryptCharacter(sb.charAt(i));
            sb.setCharAt(i,newChar);
        }
        return sb.toString();
    }
    
    
    private String decrypt(String input)
    {
        OneKeyCaesarCipher cc = new OneKeyCaesarCipher(26-mainKey);
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

