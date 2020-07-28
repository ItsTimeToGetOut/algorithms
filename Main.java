import java.io.*;
import java.util.*;

class LinkedList{
  Node head;
  public static class Node {
    Node(int v){value=v;}
    int value;
    Node next;
  }

  public static LinkedList insert(LinkedList list, int value){ 
    Node new_node = new Node(value); 
    new_node.next = null; 
    if (list.head == null)list.head = new_node;  
    else {
      Node last = list.head; 
      while (last.next != null)last = last.next;  
      last.next = new_node; 
    } 
    return list; 
  } 
  public static void printList(LinkedList list) { 
    Node currNode = list.head; 
    System.out.print("LinkedList: "); 
    while (currNode != null) { 
      System.out.print(currNode.value + " "); 
      currNode = currNode.next; 
    } 
    System.out.println();
  }

  public static void reverse(LinkedList list){
    Node current=list.head;
    Node next=null;
    Node prev=null;
    while(current!=null){
      next=current.next;
      current.next=prev;
      prev=current;
      current=next;
    }
    list.head=prev;
  } 

}

class Main{

  public String findNemo(String arr[]){
    for(int i=0;i<arr.length; i++)if(arr[i]=="nemo")return "Found Nemo";
    return "Nemo not found";
  }

  public int[] foobar1(int area){
    int []list=new int[100];
    int i=0;
    while(area>0){
      int tmp = (int)Math.sqrt(area);
      area=area-(tmp*tmp);
      list[i]=(tmp*tmp);
      ++i;
    }
        
    int a[]= new int[i];
    for(int j=0;j<i;++j)a[j]=list[j];
    return a;
  }

  public boolean checkTwoArrayContainSameElement(String arr1[], String arr2[]){
    HashSet<String> table = new HashSet<String>();
    for(int i=0;i<arr1.length;i++)if(!table.contains(arr1[i]))table.add(arr1[i]);
    for(int i=0;i<arr2.length;i++)if(table.contains(arr2[i]))return true;
    return false;
  }

  public String firstRecurringCharachterHM(String arr[]){
    HashMap<String, Integer> table = new HashMap<String, Integer>();
    for(int i=0;i<arr.length;i++){
      if(!table.containsKey(arr[i]))table.put(arr[i], 1);
      else return arr[i];
    }
    return "Not Found";
  }


  public boolean checkTwoArrayContainSameElementBRUTEFORCE(String arr1[], String arr2[]){
    for(int i=0;i<arr1.length;i++)for(int j=0;j<arr2.length;j++)if(arr1[i]==arr2[j])return true;
    return false;
  }

  public int[] rotateArray(int[] nums, int k) {
    int n[] = new int[nums.length];
    for(int i=0;i<nums.length;i++)n[(i+k)%(nums.length)]=nums[i];
    return n;
    }

  public void moveZeroes(int[] nums) {
    for(int i=0;i<nums.length-1;i++){
      if(nums[i]==0){
        int j=i+1;
        while(j<nums.length&&nums[j]==0)++j;
        if(j<nums.length){
          nums[i]=nums[j];
          nums[j]=0;
        }
      }
    }
  }

  public static void main(String[] args) {

    Main a = new Main();
    LinkedList list = new LinkedList();
    list = LinkedList.insert(list, 1); 
    list = LinkedList.insert(list, 2); 
    list = LinkedList.insert(list, 3); 
    list = LinkedList.insert(list, 4); 
    list = LinkedList.insert(list, 5); 
    list = LinkedList.insert(list, 6); 
    list = LinkedList.insert(list, 7); 
    list = LinkedList.insert(list, 8); 
    String arr1[]={"nemo", "a", "b", "d", "z", "x", "y", "w"};
    String arr2[]={"c", "e", "f", "s", "r", "q", "p", "o", "w"};

    double start = System.currentTimeMillis();



    //----- LINKED LIST METHODS -----//
    // LinkedList.printList(list);
    // LinkedList.reverse(list);
    // LinkedList.printList(list);



    //----- GENERAL METHODS -----//
    // System.out.println(a.firstRecurringCharachterHM(arr1));
    // System.out.println(a.checkTwoArrayContainSameElementBRUTEFORCE(arr1, arr2));
    // System.out.println(a.checkTwoArrayContainSameElement(arr1, arr2));
    // int b[] = a.foobar1(k);
    // System.out.println(a.findNemo(arr));

    double end = System.currentTimeMillis();
    System.out.println((end-start)+" ms");

  }
}
