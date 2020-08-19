/**
 * Programming Exercise: Improving GladLibs
 * Assignment 3: Maps Version of GladLibs
 * 
 * Modify GladLib.java to use one HashMap that maps word types to ArrayList of possible words to select.
 * The program should still work for the additional categories verbs and fruits and
 * should not use duplicate words from a category.
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */

import edu.duke.*;
import java.util.*;

public class GladLibMap {
    
    private HashMap<String,ArrayList<String>> map;
    private ArrayList<String> words;
    private ArrayList<String> usedCategories;
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data/GladLib_long";
    
    public GladLibMap() {
        map=new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        words = new ArrayList<String>();
        usedCategories = new ArrayList<String>();
    }
    
    public GladLibMap(String source) {
        map=new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
        words = new ArrayList<String>();
        usedCategories = new ArrayList<String>();
    }
    
    private void initializeFromSource(String source) {
        String[] labels = {"adjective","animal","color","country","fruit","name","noun","timeframe","verb"};
        for(String s : labels){
            ArrayList<String> list = readIt(source+"/"+s+".txt");
            map.put(s, list);
        }
    }
    
    
    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()) {
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }
    
    
    private String randomFrom(ArrayList<String> Source) {
        
          int index = myRandom.nextInt(Source.size());
          return Source.get(index);
        
    }
   
    
    private String getSubstitute(String label) {
       
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        addUsedCategory(label);
        return randomFrom(map.get(label));
    }
    
    private void addUsedCategory(String label) {
       if (usedCategories.indexOf(label) == -1){
           usedCategories.add(label);
        }
    }
    
    
    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for(String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    
    private String processWord(String word) {
        
        int first = word.indexOf("<");
        int last = word.indexOf(">",first);
        if (first == -1 || last == -1){
            return word;
        }
        String prefix = word.substring(0,first);
        String suffix = word.substring(last+1);
        String sub;
        while(true){
            sub = getSubstitute(word.substring(first+1,last));
            int index = words.indexOf(sub);
           
            if(index==-1)
            {
             words.add(sub);
             break;
            }
        }   
        return prefix+sub+suffix;
     } 
     
     
    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    
     private int totalWordsInMap() {
       int total = 0;      
       for (String category : map.keySet()) 
       {
           total += map.get(category).size();
       }
       return total;
       
    }
    
  
    private int totalWordsConsidered() {
        int total = 0;
        for (int i = 0; i < usedCategories.size(); i++) 
        {
            String category = usedCategories.get(i);
            total +=map.get(category).size();
        }
        return total;
    }
    
    
    public void makeStory() {
        words.clear();
        System.out.println("--------------------------------------------------------");
        String story = fromTemplate("data/GladLib_long/madtemplate2.txt");
        System.out.println("GladLib: Story from Template in file: data/GladLib_long/madtemplate2.txt");
        System.out.println("Replaced labels: "+ words.size()+"\n");
        System.out.println();
        printOut(story, 60);
        System.out.println(("Total words in map: "+totalWordsInMap()));
        System.out.println("The total number of words in the ArrayLists of the categories that were used: "+totalWordsConsidered());
    }

}