/**
 * Programming Exercise: Telling a Random Story
 * Assignment 2: Character Names
 * 
 * Determine the characters in one of Shakespeare’s plays
 * that have the most speaking parts.
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */
import edu.duke.*;
import java.util.*;

public class CharactersInPlay {

    private ArrayList<String> names;
    private ArrayList<Integer> counts;
    
    public CharactersInPlay() {
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    
    public void update(String person){
        int idx =names.indexOf(person);
        
        if (idx == -1)
        {
            names.add(person);
            counts.add(1);
        }
        else 
        {
            int freq = counts.get(idx);
            counts.set(idx,freq+1); 
        }
        
    }
    
    
    public void findAllCharacters() {
        names.clear();
        counts.clear();
        
        FileResource Resource = new FileResource("data/macbethSmall.txt");
        
        for (String line: Resource.lines()){
          
           if (line.contains(".")) {
               
               int idx = line.indexOf(".");
               String name = line.substring(0,idx);
               update(name);
            }
        }                                     
    }
            
    
    public void charactersWithNumParts(int num1, int num2) {
        
        System.out.println("-----The main characters with speaking parts range " + num1 + " and " + num2 + " are -----");
        for (int i =0; i < counts.size();i++) {
           
            if (counts.get(i) >= num1 && counts.get(i)<= num2) {
                
                System.out.println(names.get(i) +":  "+ counts.get(i));
            }  
        }
    } 
    
    
    public void tester() {
        findAllCharacters();
        int num =1;// estimated number for macbethSmall.txt
        System.out.println("------The Main characters and their number of speaking parts------");
             
        for (int i =0; i < counts.size();i++) {
           
            if (counts.get(i) > num) {
            
             System.out.println(names.get(i) +":  "+ counts.get(i));
            } 
        }  
       // estimated numbers for macbethSmall.txt 
       int num1 = 2;
       int num2 = 3;
       charactersWithNumParts(num1, num2);
    }
    
}