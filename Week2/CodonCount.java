/**
 * Programming Exercise: Improving GladLibs
 * Assignment 1: Codon Count
 * 
 *  A program to find out how many times each codon occurs 
 *  in a strand of DNA based on reading frames.
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */

import edu.duke.*;
import java.util.*;

public class CodonCount {
    
    private HashMap<String, Integer> DNAmap;
    
    public CodonCount() {
        DNAmap = new HashMap<String, Integer>();
    }
 
    public void buildCodonMap(int start, String dna) {
        
        DNAmap.clear();
        for(int i=start;i<dna.length();i+=3)
            if((i+2)<dna.length())
            {
                String codon = dna.substring(i,i+3);
               if (!DNAmap.containsKey(codon))
               {
                    DNAmap.put(codon, 1);
               }
                else 
               {
                   DNAmap.put(codon, DNAmap.get(codon)+1);
               }
           
            }
        
    }
        
    public String getMostCommonCodon() {
        int max = 0;
        int value = 0;
        String str = "";
        for (String codon : DNAmap.keySet()) {
            value = DNAmap.get(codon);
            if (value>max) {
                max = value;
                str = codon;
            }
        }
        return str;
    }
    
    public void printCodonCounts(int start, int end) {
        int value = 0;
        for (String codon : DNAmap.keySet()) {
            value = DNAmap.get(codon);
            if (value >= start && value <= end) 
                System.out.println(codon+":  "+value);
        }
        
    }
    
    public void Test() {
       FileResource fr = new FileResource("data/smalldna.txt ");
       String dna = fr.asString().toLowerCase();
       //estimated for smalldna.txt file
       int start = 1;
       int end = 5;
        
       buildCodonMap(0, dna);
       System.out.println("----Reading frame starting with 0----");
       String codon0 = getMostCommonCodon();
       System.out.println("Most common codon is "+codon0 +" with count "+DNAmap.get(codon0));  
       System.out.println("Codons count ranging between "+start+" and "+end+" inclusive are:");
       printCodonCounts(start, end);
        
       buildCodonMap(1, dna);
       System.out.println("----Reading frame starting with 1----");
       String codon1 = getMostCommonCodon();
       System.out.println("Most common codon is "+codon1 +" with count "+DNAmap.get(codon1));  
       System.out.println("Codons count ranging between "+start+" and "+end+" inclusive are:");
       printCodonCounts(start, end);
        
       buildCodonMap(2, dna);
       System.out.println("----Reading frame starting with 2----");
       String codon2 = getMostCommonCodon();
       System.out.println("Most common codon is "+codon2 +" with count "+DNAmap.get(codon2));  
       System.out.println("Codons count ranging between "+start+" and "+end+" inclusive are:");
       printCodonCounts(start, end);
    }
}
