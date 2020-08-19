/**
 * Programming Exercise: Improving GladLibs
 * Assignment 2: Words in Files
 * 
 * A program to determine which words occur in the greatest number of files,
 * and for each word, which files they occur in.
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */
import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsinFiles {
    
    private HashMap<String,ArrayList<String>> filenames;
    public WordsinFiles()
    {
          filenames = new HashMap<String, ArrayList<String>>();
    }
    
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        String name = f.getName();
        
        for(String word: fr.words()){
            word = word.toLowerCase();
            if(!filenames.containsKey(word)){     
                ArrayList<String> list = new ArrayList<String>();
                list.add(name);
                filenames.put(word, list);
            }
                    
            else 
            {   
                filenames.get(word).add(name);
            }                                   
        }
    }
                                                   
                                                      
    public void buildWordFileMap(){
        filenames.clear(); 
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    public int maxNumber(){        
       int max = 0;
       for(String word: filenames.keySet()){
            int size = filenames.get(word).size();
            if (size > max) {
                max = size;
            }
        }
        return max;
    }
    
    public List<String> wordsInNumFiles(int number){
        List<String> list = new ArrayList<String>();
        
        for(String word: filenames.keySet()){
            int size = filenames.get(word).size();
            
            if (size == number) 
            {
                list.add(word);
            }
        
        }
        return list;
    }
    
   
    private void printFilesIn(String word){
        ArrayList<String> list = filenames.get(word);
        System.out.println("List of file names in which the word: "+word+"appears:-");
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.println(list.get(i));
        }
    
    }
    
    public void tester(){  
        buildWordFileMap();
        System.out.println("The maximum number of files any word is in: "+maxNumber()+"\n");
        System.out.println("List of all the words that are in the maximum number of files: ");
        List <String> list = wordsInNumFiles(maxNumber());
        for (int i =0;i< list.size(); i++)
        {
          System.out.println("Word"+list.get(i)+": "+filenames.get(list.get(i)));
        }
        
    }
}