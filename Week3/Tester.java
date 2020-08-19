/**
 * Tester class contains several methods, which creates 
 * a LogAnalyzer object, calls readFile on the log data files,
 * and then tests several methods of LogAnalyzer class.
 * 
 * @author (sweetie98) 
 * @version (12/08/2020)
 */

import java.util.*;

public class Tester
{
    //Assignment: Reading Web Logs
    public void testLogAnalyzer() {
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("data/short-test_log");
        LogAnalyzer.printAll();
    }
    
    //Assignment: Unique IPs
    public void testUniqIP() {
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("data/short-test_log");
        int uIPs = LogAnalyzer.countUniqueIPs();
        System.out.println("Number of  uniqueIPs " + uIPs); 
    }
    
    //Assignment: Unique IPs
    public void testprintAllHigherthanNum() {
       LogAnalyzer LogAnalyzer = new LogAnalyzer();
       LogAnalyzer.readFile("data/short-test_log");
       LogAnalyzer.printAllHigherThanNum(400);
    }
    
    //Assignment: Unique IPs
    public void testuniqueIPVisitsOnDay() {
       LogAnalyzer LogAnalyzer = new LogAnalyzer();
       LogAnalyzer.readFile("data/weblog-short_log");
       LogAnalyzer.uniqueIPVisitsOnDay("Sep 14");
 
    }
    
    //Assignment: Unique IPs
    public void testcountUniqueIPsInRange() {
       LogAnalyzer LogAnalyzer = new LogAnalyzer();
       LogAnalyzer.readFile("data/short-test_log");
       int num = LogAnalyzer.countUniqueIPsInRange(200, 299);
       System.out.println("Count of Unique IPs In Range 200-299" +num);
    }
    
    //Assignment: Website Visits
     public void testCountVisitsPerIP()
    {
        LogAnalyzer Loganalyzer = new LogAnalyzer();
        Loganalyzer.readFile("data/short-test_log");
        HashMap<String, Integer> map = Loganalyzer.countVisitsPerIP();
        System.out.println("------Number of visits by each IP Adrdress: ------");
        for(String key : map.keySet())
        {
            System.out.println(key+" : "+map.get(key));
        }
    }
    
    //Assignment: Website Visits
    public void testMostNumberVisitsByIP()
    {
        LogAnalyzer Loganalyzer = new LogAnalyzer();
        Loganalyzer.readFile("data/weblog2_log");
        HashMap<String, Integer> map = Loganalyzer.countVisitsPerIP();
        System.out.println("Most visits by any IP: "+Loganalyzer.mostNumberVisitsByIP(map));
    }
    
    //Assignment: Website Visits
    public void testIPsMostVisits()
    {
        LogAnalyzer Loganalyzer = new LogAnalyzer();
        Loganalyzer.readFile("data/weblog2_log");
        HashMap<String, Integer> map = Loganalyzer.countVisitsPerIP();
        System.out.println("------Most visits by IPs:-------");
        ArrayList<String> ips = Loganalyzer.iPsMostVisits(map);
        for(String ip : ips)
        {
            System.out.println(ip);
        }
    }
    
    //Assignment: Website Visits
    public void testIPsForDays()
    {
        LogAnalyzer Loganalyzer = new LogAnalyzer();
        Loganalyzer.readFile("data/weblog3-short_log");
        HashMap<String, ArrayList<String>> map = Loganalyzer.iPsForDays();
        for(String key : map.keySet())
        {
            System.out.println("Visits on "+key);
            for(String ip : map.get(key))
                System.out.println(ip);
        }
    }
    
    //Assignment: Website Visits
    public void testDayWithMostIPVisits()
    {
        LogAnalyzer Loganalyzer = new LogAnalyzer();
        Loganalyzer.readFile("data/weblog2_log");
        HashMap<String, ArrayList<String>> map = Loganalyzer.iPsForDays();
        System.out.println("Day with most IP visits :"+Loganalyzer.dayWithMostIPVisits(map));
    }
    
    //Assignment: Website Visits
    public void testIPsWithMostVisitsOnDay()
    {
        LogAnalyzer Loganalyzer = new LogAnalyzer();
        Loganalyzer.readFile("data/weblog2_log");
        HashMap<String, ArrayList<String>> map = Loganalyzer.iPsForDays();
        String day = "Sep 29";
        System.out.println("------IP with most visits on day "+day+"------");
        ArrayList<String> ips = Loganalyzer.iPsWithMostVisitsOnDay(map,day);
        for(String ip : ips)
            System.out.println(ip);
    }
}
