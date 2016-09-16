import java.util.*;

public class EarlyStep{
  public EarlyStep(){}

 public int jump(int[] A, int D){
   LinkedList<Step> toVisit = new LinkedList<Step>();
   LinkedList<Step> visited = new LinkedList<Step>();
   LinkedList<Step> solution = new LinkedList<Step>();

   Step initial= new Step(0,-1,-1);
   if ((A.length +1 )== D){
     return 0;
   }
  
   toVisit.add(initial);
   while (!toVisit.isEmpty()){
     Step temp = toVisit.poll();
     int start = temp.getCurrent() + 1;
     int furthest = start + D;
     if (furthest <= A.length){
     for (int i = start; i < furthest; i++){
       if (i < A.length){
       int nextPos = A[i];
       int currentMax = temp.getMax();
       int currentPos = temp.getCurrent();
       int lastPos = temp.getLast();
       LinkedList<Integer> result = temp.getList();
       if (nextPos > -1){
             
         if (nextPos>currentMax) {
          currentMax = nextPos;
         }
         else{
           
         }
         Step next = new Step(currentMax,currentPos, lastPos);
         next.setList(result);
         next.update(lastPos);
         next.setLast(currentPos);
         next.setCurrent(i);
         toVisit.add(next);
    
       }
       else{
       }
       
     }
       
     }
     }
     else{
       temp.update(temp.getLast());
       temp.update(temp.getCurrent());
       solution.add(temp);
     }
   }
   
   int early = 0;
   for (Step x: solution){
     int temp = x.getMax();
    
     if (early ==0){
       early = temp;
     }
     if (temp < early){
       early = temp;
     }
     
   }
   if (solution.isEmpty()){
     return -1;
   }
   for (Step x: solution){
     x.getList().removeFirst();
   System.out.println(x.getList().toString());
   }

  return early;
 }

  public static void main (String[] args){
   EarlyStep test = new EarlyStep();
  



    
    
  }
}
class Step{

 private int maxTime;
  private int currentPos;
   private int lastPos;
   private LinkedList<Integer> list;
  public Step(int m, int c, int l){
    this.maxTime = m;
    this.currentPos=c;
    this.lastPos = l;
    this.list = new LinkedList<Integer>();
  }
  
  public int getMax(){
    return maxTime;
  }
  public LinkedList<Integer> getList(){
    return list;
  }
  public void add(int i){
    list.add(i);
  }
  
  public void setMax(int m){
    this.maxTime=m;
  }
  
  public int getCurrent(){
    return currentPos;
  }
  
  public int getLast(){
    return lastPos;
  }
  
  public void setLast(int l){
    this.lastPos = l;
  }
  public void setList(LinkedList<Integer> l){
    this.list = (LinkedList<Integer>)(l.clone());
  }
  public void setCurrent(int i){
    this.currentPos=i;
  }

  public void update(int u){
   this.list.add(u);
  }
  
  
}
