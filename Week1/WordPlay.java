/**
 *  Programming Exercise: Implementing the Caesar Cipher
 *  Assignment 1: Word Play
 *  A program to transform words from a file into another form,
 *  such as replacing vowels with an asterix.
 * 
 * @author (sweetie98) 
 * @version (12/8/2020)
 */
public class WordPlay {

    public boolean isVowel(char ch) {
     if (ch == 'a' || ch =='e' || ch =='i' || ch =='o'|| ch =='u')   
         return true; 
     if (ch == 'A' || ch =='E' || ch =='I' || ch =='O'|| ch =='U')
         return true;
     return false;
    }
    
    public String replaceVowels(String phrase, char ch) {

        StringBuilder sb = new StringBuilder(phrase);
        for (int i = 0; i < sb.length();i++) {
            char currChar = sb.charAt(i);
            if (isVowel(currChar))
            {
                sb.setCharAt(i, ch);   
            }
        }
        return sb.toString();
    }
    
    public String emphasize(String phrase, char ch ){
        StringBuilder sb = new StringBuilder(phrase);
        for (int i = 0; i < sb.length();i++) {
            char currChar = sb.charAt(i);
            if ((currChar == ch) && (i %2 == 0))
                    sb.setCharAt(i, '*');
            else if ((currChar == ch) && (i %2 != 0))
                    sb.setCharAt(i, '+');
        }
        return sb.toString();
    }
   
    public void testWordPlay () {
        System.out.println("isVowel('F')"+ ": " + isVowel('F'));
        System.out.println("isVowel('a')"+ ": " + isVowel('a'));
        System.out.println("replace Vowels of Hello World"+ ": " + replaceVowels("Hello World",'*'));
        System.out.println("emphasize dna ctgaaactga"+ ": " + emphasize("dna ctgaaactga",'a'));
        System.out.println("emphasize Mary Bella Abracadabra"+ ": " + emphasize("Mary Bella Abracadabra",'a'));
    }
    
}
