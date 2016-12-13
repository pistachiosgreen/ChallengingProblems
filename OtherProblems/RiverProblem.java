/******************************************************************************
  Completing the RiverProblem using one public class
  
  ******************************************************************************/
import java.util.*;
public class RiverProblem {
  LinkedList<Item> left;
  LinkedList<Item> right;
  RiverProblem prev;
  int side;
  public enum Item {
    FARMER, WOLF, CHICKEN, GRAIN
  }
  public RiverProblem(LinkedList<Item> left, LinkedList<Item> right,int side, RiverProblem yo) {
    this.left=left;
    this.right= right;
    this.side =side;
    this.prev = yo;
  }
  
  public String toString(){
    String s = "";
    s = left.toString() + " | " + right.toString();
    return s;
  }
  
  public boolean isValid(LinkedList<Item> checking){  
    return (!((checking.contains(Item.WOLF) && checking.contains(Item.CHICKEN))||
              (checking.contains(Item.CHICKEN) && checking.contains(Item.GRAIN))));
  }
  
  public boolean isSimilar(LinkedList<Item> currentState, LinkedList<Item> nextState){
    if (currentState.size() == nextState.size()){
      boolean temp = true;
      for (Item x : currentState){
        if (nextState.contains(x)){    
        }        
        else{
          return false;
        }
      }
      return temp;
    }
    else{
      return false;
    }
  }
  
  
  public boolean isSame(RiverProblem one, RiverProblem two){
    return isSimilar(one.left,two.left) && isSimilar(one.right,two.right);
    
  }
  
  //FWCG
  public static void main(String[] args) {
    LinkedList<Item> l = new LinkedList<Item>();
    LinkedList<Item> r = new LinkedList<Item>();
    LinkedList<Item> goal = new LinkedList<Item>();
    RiverProblem nothing = new RiverProblem (l,r,0,null);      
    Item [] start = new Item [] {Item.FARMER, Item.WOLF, Item.CHICKEN, Item.GRAIN};
    l = new LinkedList<Item>(Arrays.asList(start));
    goal =  new LinkedList<Item>(Arrays.asList(start));
    RiverProblem test = new RiverProblem(l,r,0,nothing);
    test.prev = nothing;
    boolean repeat= false;
    RiverProblem end = new RiverProblem (new LinkedList<Item>(), goal, 2, nothing);
    LinkedList<RiverProblem> toVisit= new LinkedList<RiverProblem>();
    LinkedList<RiverProblem> visited= new LinkedList<RiverProblem>();
    LinkedList<RiverProblem> solution= new LinkedList<RiverProblem>();
    toVisit.add(test);        
    while (toVisit.size()>=1){
      RiverProblem temp = toVisit.poll();
      if (temp.isSame(temp, end)){
        System.out.println("YO");
        RiverProblem solved = temp;
        while (!(solved.prev == null)){
          solution.addFirst(solved);
          solved = solved.prev;
        }          
        for (RiverProblem t: solution){
          System.out.println(t);
        }
        return;
      }
      else{
      }
      repeat = false;
      for (RiverProblem z : visited){
        if (temp.isSame(z, temp)){
          repeat = true;
        }
        else{}
      }
      
      if (repeat == false){     
        visited.add(temp);    
        if (temp.side == 0){
          LinkedList<Item> left = (LinkedList<Item>)(temp.left.clone());
          LinkedList<Item> right = (LinkedList<Item>)(temp.right.clone());
          for (Item x : temp.left){
            left.remove(x);
            right.add(x);
            if (temp.isValid(left)){
              if (left.contains(Item.FARMER)){
                left.remove(Item.FARMER);
                right.add(Item.FARMER);
              }else{
              }
              LinkedList<Item> s = (LinkedList<Item>)left.clone();
              LinkedList<Item> j = (LinkedList<Item>)right.clone();
              RiverProblem random = new RiverProblem(s,j, 2,temp);
              toVisit.add(random);
            } else{
            }
            left.add(x);
            right.remove(x);
            if (right.contains(Item.FARMER)){
              right.remove(Item.FARMER);
              left.add(Item.FARMER);
            }else{
            }
          }    
        }     
        else {
          LinkedList<Item> left = (LinkedList<Item>)(temp.left.clone());
          LinkedList<Item> right = (LinkedList<Item>)(temp.right.clone());     
          for (Item x : temp.right){
            right.remove(x);
            left.add(x);
            if (temp.isValid(right)){
              if (right.contains(Item.FARMER)){
                right.remove(Item.FARMER);
                left.add(Item.FARMER);
              }else{
              }
              LinkedList<Item> g = (LinkedList<Item>)left.clone();
              LinkedList<Item> n = (LinkedList<Item>)right.clone(); 
              RiverProblem random = new RiverProblem(g,n, 0,temp);
              toVisit.add(random);
            } else{
            }
            right.add(x);
            left.remove(x);
            if (left.contains(Item.FARMER)){ 
              left.remove(Item.FARMER);
              right.add(Item.FARMER);
            }else{
            }
          }  
        }          
      }
      else {
      }        
    }            
  }
}
