/**
 * In the LogAnalyzer class the constructor initialize records to an empty ArrayList and
 * the readFile method create a FileResource and iterate over all the lines in the file.
 * For each line, create a LogEntry and store it in the records ArrayList.
 * Further perform different operations on records by implementing several methods.
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     WebLogParser LogParser = new WebLogParser(); 
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
     
     //Assignment: Reading Web Logs
     public void readFile(String source) {
         FileResource fr = new FileResource(source);
          for(String line: fr.lines()){
              records.add(LogParser.parseEntry(line));
          }                        
     }
     
     // Assignment: Reading Web Logs
     public void printAll() {
         for (LogEntry entry : records) {
             System.out.println(entry);
         }
     } 
     
     //Assignment: Unique IPs
     public int countUniqueIPs() {
        ArrayList<String> uIPs = new ArrayList<String>();
        for(LogEntry entry: records) {
            String ip = entry.getIpAddress();
            if(!uIPs.contains(ip)) {
                uIPs.add(ip);
            }
        }
        return uIPs.size();
     }
      
     //Assignment: Unique IPs
     public void printAllHigherThanNum(int Num) { 
        System.out.println("StatusCode greater than: "+Num+" are:-");
        for(LogEntry entry: records) {
            int sCode = entry.getStatusCode();
            if(sCode > Num) {
                System.out.println(sCode);
            }
        }
           
     }   
     
     //Assignment: Unique IPs
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> uIPs = new ArrayList<String>();
         System.out.println("uniqueIP Visits On "+someday+":- "); 
         for(LogEntry entry: records) {
             String ip = entry.getIpAddress();
             String str = entry.getAccessTime().toString();
             if((str.contains(someday)) && (!uIPs.contains(ip)))
             {
                uIPs.add(ip);
             }  
         }
         
         for(int i =0; i < uIPs.size();i++){
                     System.out.println(uIPs.get(i)); 
         }
         System.out.println("Total number of uniqueIP Visits On "+someday+": "+uIPs.size());           
         return uIPs;
     }
         
     //Assignment: Unique IPs
     public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uIPs = new ArrayList<String>();
        for(LogEntry entry: records) {
        int sCode = entry.getStatusCode();
        String ip = entry.getIpAddress();
            if((sCode >= low) && (sCode <= high)) 
            {
                if(!uIPs.contains(ip)) 
                {
                    uIPs.add(ip);
                }
            }
        }
        return uIPs.size();
     }
     
     //Assignment: Website Visits
      public HashMap<String,Integer> countVisitsPerIP() {
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        for (LogEntry entry: records) {
            String ip = entry.getIpAddress();
            map.put(ip,map.getOrDefault(ip,0)+1);
       }
       return map;
     }
     
     //Assignment: Website Visits
     public int mostNumberVisitsByIP(HashMap<String,Integer> map){ 
       int max = 0;
       for (String str: map.keySet()){
            int ipTimes = map.get(str);
            if (ipTimes > max) {
                max = ipTimes;
            }
        }
        return max; 
     }
     
     //Assignment: Website Visits
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> map){   
        ArrayList<String> list = new ArrayList<String>();    
        int max = mostNumberVisitsByIP(map);
        for (String str: map.keySet()) {
            if (map.get(str) == max) {
                list.add(str);
            }
        }
       return list;
     }
    
     //Assignment: Website Visits
      public HashMap<String,ArrayList<String>> iPsForDays(){
         HashMap<String,ArrayList<String>> map= new HashMap<String,ArrayList<String>>();
         ArrayList<String> ips = new ArrayList<String>();
         for (LogEntry entry: records) {
             String days = entry.getAccessTime().toString();
             ips = uniqueIPVisitsOnDay(days);
             if(!map.containsKey(days))
                map.put(days,ips);  
         }
       return map;
     }
    
     //Assignment: Website Visits
     public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> map){
          int max =0;
          String maxday="";
          for (String day : map.keySet()) {
               if( map.get(day).size()>max)
               {
                     max =map.get(day).size();
                     maxday= day;
               }
          }
          return maxday;
     }
    
     //Assignment: Website Visits
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day)
     {
         ArrayList<String> list = map.getOrDefault(day,new ArrayList<String>());
         HashMap<String, Integer> mapvisits = new HashMap<>();
         for(String ip : list)
            mapvisits.put(ip, mapvisits.getOrDefault(ip,0)+1);
         return iPsMostVisits(mapvisits);
     }
}