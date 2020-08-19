
/**
 *Programming Exercise:Breaking the Caesar Cipher
 * Assignment 1: Word lengths
 * A program to figure out the most common word length of words from a file
 * 
 * @author (sweetie98) 
 * @version (12/8/2020)
 */
import java.lang.*;
import edu.duke.*;
public class WordLengths {    
   
public void countWordLengths(FileResource Resource, int[] counts) { 
        int lastIndex = counts.length - 1;
        for (String word : Resource.words()){
            int Wordlength = word.length();
            //removes any non-letter character from first and last position of a word
            for (int i=0; i<word.length();i++){
                char currChar = word.charAt(i);
                if ((i==0) || (i==word.length()-1)){
                    if (!Character.isLetter(currChar))
                        Wordlength--;
                }
            }  
            
            if (Wordlength >= lastIndex)
                counts[lastIndex]++;
            else 
                counts[Wordlength]++;  
        } 
    }
   
//This method finds the most common word length
public void indexOfMax(int[] values) {
        int max = 0;
        int index = 0;
            for (int i = 0; i <values.length;i++) 
              {
                  if (values[i] > max) 
                    {
                        max = values[i];
                        index = i;
                    } 
        } 
      System.out.println("The most common word length is :"+ index);   
    }
       
    
void testCountWordLengths(){
     FileResource Resource = new FileResource("data/smallHamlet.txt");
     int [] counts = new int[31];
     countWordLengths(Resource,counts);  
      // print the number of words of each length
     for(int i=0;i<counts.length;i++)
      {
          if(counts[i]!=0)
             System.out.println(" Word length: "+ i +" Number of words: "+ counts[i]);
      }
      //method prints index position of largest element in counts array i.e the most common word length
     indexOfMax(counts);    
   }
   
}   
                                                   
                                                     
                                                     
                                                     
                                                    
      
        
