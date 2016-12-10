/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 import java.util.*;
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> resultlist = new ArrayList<Interval>();
         System.out.println("Test");
        List<Interval> intervallist = new ArrayList<Interval>(intervals);
        if (intervallist.isEmpty()){
            return resultlist;
        }
        
        Collections.sort(intervallist,IntervalStartOrder);
         System.out.println((intervallist.get(0)).start + "");
         resultlist.add(intervallist.get(0));
        int count = 1;
        
        while (count < intervallist.size()){
            Interval current = intervallist.get(count);
            int index = resultlist.size()-1;
            Interval lastinput = resultlist.get(index);
            if (current.start <= lastinput.end){
                int endrange = Math.max(current.end, lastinput.end);
                resultlist.set(index, new Interval(lastinput.start, endrange));
                }
            else{
                resultlist.add(current);
            }
            count++;
        }
        System.out.println((resultlist.get(0)).start + "");
        
        System.out.println("Test");
        return resultlist;
    }
    final Comparator<Interval> IntervalStartOrder = new Comparator<Interval>() {
            public int compare(Interval e1, Interval e2) {
                return e1.start - e2.start;
            }
    };
    
}

