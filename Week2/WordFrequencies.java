/**
 * Programming Exercise: Telling a Random Story
 * Assignment 1: Most Frequent Word
 * 
 * Determine the word that occurs the most often in a file.
 * If more than one word occurs as the most often, then return 
 * the first such word found.
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */
import edu.duke.*;
import java.util.*;

public class WordFrequencies {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
          myWords = new ArrayList<String>();
          myFreqs = new ArrayList<Integer>();
        }
         
    public void findUnique() { 
        myWords.clear();
        myFreqs.clear();
        FileResource Resource = new FileResource("data/testwordfreqs.txt");
        for(String s: Resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1); 
            }
        }
    }
    
    public int findIndexOfMax() {
        int max = myFreqs.get(0);
        int index = 0;
        for(int i=0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) >max) {
                max = myFreqs.get(i);
                index = i;
            }
        }
        return index;
    }
    
    public void tester() {
        findUnique();
        System.out.println("Number of unique words: "+myWords.size()+"\n");
        System.out.println("Words        Frequencies");
        for ( int i =0; i < myWords.size();i++){
            System.out.println( myWords.get(i)+"    "+myFreqs.get(i));
        }
        int idx = findIndexOfMax();
        System.out.println("Word with max frequency is: " +myWords.get(idx)+": "+ myFreqs.get(idx));
        
        
    }
     
   

}