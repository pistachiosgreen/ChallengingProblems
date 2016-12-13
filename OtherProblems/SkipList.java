/*Name: Jessica Guo
 * About the program- This coding sample is my attempt at implementing an indexable skip list 
 * to find the moving median while printing out numbers that are a certain percentage above
 * the current moving median.
 * The program takes in a text file called "input.txt" with the file being in the following format:
 * first line is an integer that represents how many inputs the user wants calculated when 
 * discovering the median
* the second line is a double that is a percentage that represents how much a number has to be above the
* median to be printed
* The other lines should just be integers  
* Note: The program may have bugs and only calculate the correct output 50% of the time
* If you have any tips or advice, please feel free to reach out to me at jsguo9@gmail.com. 
* I really appreciate the time you are taking to look at my code. Thank you for your consideration!
**/

import java.io.*;
import java.text.*;
import java.util.*;


public class SkipList {
  private Node[] layers;
  private int tracking;
  private int numberOfInputs;
  private Double currentMedian;
  private Double percent;
  private int height;
  private Double maxThreshold;
  final int MAX= Integer.MAX_VALUE;
  final int MIN= Integer.MIN_VALUE;
  
  public static void main(String args[] ){
    
    try{
      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
      DecimalFormat df=new DecimalFormat("#.000");
      SkipList test= new SkipList();
      String line = br.readLine();
      test.numberOfInputs= Integer.parseInt(line);
      test.height= (int)(Math.log(test.numberOfInputs)/Math.log(2))+1;
      line=br.readLine();
      test.percent=Double.parseDouble(line);    
      LinkedList moving= new LinkedList<Integer>();
      line=br.readLine();  
      test.makeLevels(test.height);
      
      while (line!=null){
        int another= Integer.parseInt(line);
        moving.add(another);
        test.insert(another);
        if(moving.size()==test.numberOfInputs){ 
          test.currentMedian=(Double)test.findMedian(test.numberOfInputs); 
          test.maxThreshold= (1.0+test.percent)*test.currentMedian;   
        }
        if(moving.size()>test.numberOfInputs){
          int toBeDeleted=(Integer)(moving.removeFirst());
          test.delete(toBeDeleted);
          Double convertToDouble= another*1.0;
          if(convertToDouble>(test.maxThreshold)){
            System.out.println(df.format(another));
          }
        }    
        line=br.readLine();
      }
      br.close();
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
  
  public void makeLevels(int n){
    Node[] levels= new Node[height];
    Node min= new Node(MIN,1);
    levels[height-1]=min;
    Node max= new Node(MAX,0);
    min.setRight(max);
    
    if(height>=2){
      for (int i=height-2;i>=0;i--){
        Node left=new Node(MIN,1);
        Node right= new Node(MAX,0);
        left.setRight(right);
        levels[i]= left;
        levels[i+1].setDown(levels[i]);
      }
    }
    layers= levels;
  }
  
  public Double findMedian(int n){
    int num=n;
    Double median=0.0;
    int halfOne=(int)(num/2);
    int nodeOne=findNode(halfOne);
    int halfTwo=halfOne+1;
    int nodeTwo= findNode(halfTwo); 
    
    if(num%2==0){
      median= (Double)((nodeOne+nodeTwo)/2.0); 
    }
    else{
      median=nodeTwo*1.0;
    }
    return median;
  }
  
  public int findNode(int n){
    int find=n;
    int max=height;
    Node start= layers[height-1];
    
    while(max>0){
      int sub=find-start.getWidth(); 
      if((sub>=0)&&(start.getRight().getValue()!=Integer.MAX_VALUE)){
        find-=start.getWidth();
        if(find==0){
          return start.getRight().getValue();
        }
        start=start.getRight();
      }
      else{
        start=start.getDown();
        max--;
      }    
    }
    return start.getValue();
  }
  
  public void insert(int v){
    Node left=findNodeInLevel(layers[0],v);
    Node inserting= new Node(v,1);
    inserting.swapPointers(left);
    createUpperLevels(inserting);
  }
  
    public void delete(int v){
    int max=height-1;
    while(max>=0){
      Node left=findNodeInLevel(layers[max],v-1);
      if(left.getRight().getValue()==v){
        Node temp=left.getRight();
     left.setRight(temp.getRight());
     left.setWidth(temp.getWidth()+left.getWidth()-1);
      }
      else{
        left.setWidth(left.getWidth()-1);       
      }
        left=left.getDown();
            max--;
      }
    }
    
  public void createUpperLevels(Node start){
    int n = makeRandomLevels(); 
    int leftToCurrent=0;
    int count=1;
    int val= start.getValue();
    Node current=start;  
    int currentToRight=0;
    
    for (int i=1;i<height;i++){ 
      if (count<n){
        Node head= layers[i];
        Node left= findNodeInLevel(head, val);
        Node right=left.getRight();
        Node leftBottom= findNodeInLevel(layers[0], left.getValue());
        Node currentBottom=findNodeInLevel(leftBottom, val);
        leftToCurrent=tracking;
        findNodeInLevel(currentBottom, right.getValue());
        currentToRight= tracking;
        Node insert= new Node(val, currentToRight);
        left.setWidth(leftToCurrent);
        insert.swapPointers(left);
        insert.setDown(current);
        current=insert;
      }
      else{ 
        Node head= layers[i];
        Node left= findNodeInLevel(head, val);
        left.setWidth(left.getWidth()+1);
      }
      count++; 
    }
  }
  
  public Node findNodeInLevel(Node t, int v){
    tracking=0;
    int val=v;
    Node next= t.getRight();
    while((next.getValue()<=val)&&(next.getRight()!=null)){
      tracking+= next.getWidth();
      t=next;
      next= next.getRight();
    }
    return t;
  }
  
  public int makeRandomLevels(){
    int count=0;
    if (height>=2){
      int max= height;
      int random=0;
      do{
        count++;
        random= (int)(Math.random()*100);
      }
      while ((random%2==0 )& count<max);
    }
    return count;
  }
}

class Node{ 
  private Node right;
  private Node down;
  private int value;
  private int width;
  public Node(int val, int w){
    this.value= val;
    this.width=w;
  }
  
  public int getValue(){
    return this.value;
  }
  
  public int getWidth(){
    return this.width;
  }
  
  public void setWidth(int w){
    this.width=w;
  }
  
  public void setRight(Node n){
    this.right=n;
  }
  
  public Node getRight(){
    return right;
  }
  
  public void setDown(Node n){
    this.down=n;
  }
  
  public Node getDown(){
    return down;
  }
  
  public void swapPointers(Node left){ 
    Node right= left.getRight();
    left.setRight(this);
    this.setRight(right);
  }
  
  public String toString(){
    String s= "Value: " + this.value + ", " + "Width: " + this.width;
    s+= ", Right: " + this.getRight();
    return s;
  }
}
