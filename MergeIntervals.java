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
        if (intervals.isEmpty()){
            List<Interval> resultlist = new ArrayList<Interval>();
            return resultlist;
        }
        
        Collections.sort(intervals,IntervalStartOrder);
        ListIterator<Interval> it = intervals.listIterator();
        Interval lastinput = it.next();
        while (it.hasNext()){
            Interval current = it.next();
            if (current.start <= lastinput.end){
                int endrange = Math.max(current.end,lastinput.end);
                lastinput.end = endrange;
                it.remove();
            }
            else{
                lastinput = current;
            }
            
        }

        return intervals;
    }
    /*
    public List<Interval> merge(List<Interval> intervals) {
    int N = intervals.size();
    Collections.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i, Interval j){
                return i.end - j.end;
        }
    });
    for(int i = N-1; i>0;i--){
        Interval inter1 = intervals.get(i-1);
        Interval inter2 = intervals.get(i);
        if(inter1.end >= inter2.start){
            inter1.start = Math.min(inter1.start, inter2.start);
            inter1.end = inter2.end; 
            intervals.remove(i);
        }
    }
    return intervals;
}
*/
    final Comparator<Interval> IntervalStartOrder = new Comparator<Interval>() {
            public int compare(Interval e1, Interval e2) {
                return e1.start - e2.start;
            }
    };
    
}

