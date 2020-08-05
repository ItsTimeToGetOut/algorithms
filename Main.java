import java.io.*;
import java.util.*;



class Tree{
  TNode root;
  Tree(){
    root=null;
  }


  public void insertInTree(NodeT node){
    root = insertRecursive(root, node);
  }


  public TNode insertRecursive(TNode root, NodeT node){
    if(root==null){
      TNode tmp=new TNode(node);
      return tmp;
    }
    if(node.a>=root.data.a)root.right=insertRecursive(root.right, node);
    else root.left=insertRecursive(root.left, node);
    return root;
  }


  void printTree(){
    inorder(root);
  }


  void inorder(TNode root){
    if(root!=null){
      inorder(root.left);
      System.out.println(root.data.a);
      System.out.println(root.data.b);
      System.out.println(root.data.name);
      System.out.println();
      inorder(root.right);
    }
  }


  NodeT searchTreeByIdA(int a){
    return searchTreeA(a, root);
  }


  NodeT searchTreeA(int a, TNode root){
    if(root==null)return new NodeT(-1, -1, "Not Found");
    if(root.data.a>a)return searchTreeA(a, root.left);
    else if(root.data.a<a)return searchTreeA(a, root.right);
    else return root.data;
  }


  void delete(int a){
    deleteFromTreeA(a, root);
  }


  TNode deleteFromTreeA(int a, TNode root){
    if(root==null)return null;
    if(root.data.a>a)root.left=deleteFromTreeA(a, root.left);
    else if(root.data.a<a)root.right=deleteFromTreeA(a, root.right);
    else {
      if(root.left==null&&root.right==null)return null;
      else if(root.left==null)return root.right;
      else if(root.right==null)return root.left;
      else {
        TNode tmp=root;
        TNode tmp2=root;
        root=root.right;
        while(root.left!=null)root=root.left;
        tmp.data=root.data;
        tmp2.right=deleteFromTreeA(root.data.a, tmp2.right);
        return tmp;
      }
    }
    return null;
  }



  NodeT bfs(int a){
    queue.add(root);
    return breadthFirstSearch(a);
  }

  public Queue<TNode> queue = new LinkedList<TNode>();
  public ArrayList<NodeT> list = new ArrayList<NodeT>();

  NodeT breadthFirstSearch(int a){
    if(queue.peek()==null)return null;
    if(queue.peek().data.a==a)return queue.peek().data;
    list.add(queue.peek().data);
    if(queue.peek().left!=null)queue.add(queue.peek().left);
    if(queue.peek().right!=null)queue.add(queue.peek().right);
    queue.remove();
    return breadthFirstSearch(a);
  }



}




class TNode{
  TNode left;
  TNode right;
  NodeT data;
  TNode(NodeT object){
    data=object;
    left=null;
    right=null;
  }
}




class NodeT{
  int a;
  int b;
  String name;
  NodeT(int data1, int data2, String data3){
    a=data1;
    b=data2;
    name=data3;
  }
}




class Graph<T>{
  private Map<T, List<T>> map = new HashMap<>();


  void BFS(int search){
    int s;
    boolean []visited = new boolean[getVertexCount()];
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(search);
    visited[search]=true;
    while(queue.size()!=0){
      s = queue.poll(); 
      System.out.print(s+" ");
      Iterator<T> i = map.get(s).listIterator(); 
      while (i.hasNext()){
        int n = (int)i.next(); 
        if (!visited[n]){ 
          visited[n] = true; 
          queue.add(n); 
        } 
      }
    }

  }


  void DFS(int search){
    boolean []visited = new boolean[getVertexCount()];
    DFSRecur(search, visited);
  }


  void DFSRecur(int search, boolean visited[]){
    visited[search] = true; 
    System.out.print(search+" ");
    Iterator<T> i = map.get(search).listIterator(); 
    while (i.hasNext()){ 
      int n = (int)i.next(); 
      if (!visited[n])DFSRecur(n, visited); 
    }
  }



  public void addVertex(T s){ 
    map.put(s, new LinkedList<T>()); 
  }


  public void addEdge(T source, T destination, boolean bidirectional){ 
    if(!map.containsKey(source))addVertex(source); 
    if(!map.containsKey(destination))addVertex(destination); 
    map.get(source).add(destination); 
    if (bidirectional == true)map.get(destination).add(source);  
  }


  public int getVertexCount(){ 
    return map.keySet().size(); 
  }


  public int getEdgesCount(boolean bidirection){ 
    int count = 0; 
    for (T v : map.keySet())count += map.get(v).size();
    if (bidirection == true)count=count/2;
    return count;
    }  


  public boolean containsVertex(T s){
    return map.containsKey(s);
  }


  public boolean hasEdge(T s, T d){
    return map.get(s).contains(d);
  }


  public String showGraph(){ 
    StringBuilder builder = new StringBuilder(); 
    for (T v : map.keySet()) { 
      builder.append(v.toString() + ": "); 
      for (T w : map.get(v))builder.append(w.toString() + " "); 
      builder.append("\n");
    } 
    return (builder.toString()); 
  }



  //any help in making a dfs and bfs function for graphs is much appreciated



}




class UF{


  public UF(int N){
    id = new int[N];
    sz = new int[N];
    for(int i=0;i<N;i++){id[i]=i; sz[i]=1;}
  }


  private int[] id;
  private int[] sz;


  boolean connected(int p, int q){
    return id[p]==id[q];
  }


  void unionQuadratic(int p, int q){
    int pid=id[p], qid=id[q];
    for(int i=0;i<id.length;i++)if(id[i]==pid)id[i]=qid;
  }


  int root(int i){
    while(i!=id[i]){
      id[i] = id[id[i]];
      i=id[i];
    }
    return i;
  }


  boolean connectedRoots(int p, int q){
    return root(p)==root(q);
  }


  void unionRoots(int p, int q){
    int i=root(p);
    int j=root(q);
    if(i==j)return;
    if(sz[i]<sz[j]){id[i]=j; sz[j]=sz[j]+sz[i];}
    else {id[j]=i; sz[i]=sz[i]+sz[j];}
  }


}




class NodeS {
  NodeS(int v, int n){value=v; next=n;}
  int value;
  int next;
}




// ----- Uncomment this when using custom linked list ----- //
// ----- comment this when using graphs and delete its class file ----- //




// class LinkedList{
//   Node head;
//   public static class Node {
//     Node(int v){value=v;}
//     int value;
//     Node next;
//   }


//   public static LinkedList insert(LinkedList list, int value){ 
//     Node new_node = new Node(value); 
//     new_node.next = null; 
//     if (list.head == null)list.head = new_node;  
//     else {
//       Node last = list.head; 
//       while (last.next != null)last = last.next;  
//       last.next = new_node; 
//     } 
//     return list; 
//   } 


//   public static void printList(LinkedList list) { 
//     Node currNode = list.head; 
//     System.out.print("LinkedList: "); 
//     while (currNode != null) { 
//       System.out.print(currNode.value + " "); 
//       currNode = currNode.next; 
//     } 
//     System.out.println();
//   }


//   public static void reverse(LinkedList list){
//     Node current=list.head;
//     Node next=null;
//     Node prev=null;
//     while(current!=null){
//       next=current.next;
//       current.next=prev;
//       prev=current;
//       current=next;
//     }
//     list.head=prev;
//   }


// }




// ----- GENERAL ALGORITHMS ----- //




class Main{



  public String reverseStringRecur(String s){
    if(s.length()<2)return s;
    return s.charAt(s.length()-1)+reverseStringRecur(s.substring(0,s.length()-1));
  }



  public int goodOlFibonacci(int index){
    if(index<2)return index;
    return goodOlFibonacci(index-1)+goodOlFibonacci(index-2);
  }



  public int basicFibonacci(int index){
    if(index<2)return index;
    int a1=0, a2=1, answer=0;
    for(int i=2;i<=index;i++){
      answer=a1+a2;
      a1=a2;
      a2=answer;
    }
    return answer;
  }



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



  public String foobar2_1(long x, long y){
    long yc=1, k=0;
    for(long i=0;i<y;i++)yc+=k++;
    ++y;
    for(long i=0;i<x-1;i++)yc+=y++;
    return String.valueOf(yc);
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



  // ----- SORTING TECHNIQUES ----- //



  void bubbleSort(int[] array){
    for(int i=0;i<array.length;i++){
      for(int j=0;j<array.length-i-1;j++){
        if(array[j]>array[j+1]){
          int tmp=array[j];
          array[j]=array[j+1];
          array[j+1]=tmp;
        }
      }
    }
  }



  void selectionSort(int[] array){
    for(int i=0;i<array.length-1;i++){
      int min = i;
      for(int j=i+1;j<array.length;j++)min=(array[j]<array[min])?j:min;
      int tmp=array[i];
      array[i]=array[min];
      array[min]=tmp;
    }
  }



  void insertionSort(int[] arr){
    for(int i=1;i<arr.length;i++){
      int key=arr[i];
      int j=i-1;
      while(j>=0&&arr[j]>key){ 
        arr[j+1]=arr[j]; 
        j--; 
      } 
      arr[j+1]=key;
    }
  }



  void mergeSort(int[] arr){
    sort(arr, 0, arr.length-1);
  }



  void sort(int arr[], int l, int r){ 
    if(l<r){
      int m = (l + r) / 2; 
      sort(arr, l, m); 
      sort(arr, m + 1, r); 
      merge(arr, l, m, r); 
    } 
  }



  void merge(int arr[], int l, int m, int r){ 
    int n1=m-l+1; 
    int n2=r-m; 
    int L[]=new int[n1]; 
    int R[]=new int[n2]; 
    for (int i=0;i<n1;++i)L[i]=arr[l+i]; 
    for (int j=0;j<n2;++j)R[j]=arr[m+1+j]; 
    int i=0,j=0; 
    int k=l; 
    while (i<n1&&j<n2){ 
      if(L[i]<=R[j]){ 
        arr[k]=L[i]; 
        i++; 
      } 
      else{ 
        arr[k]=R[j]; 
        j++; 
      } 
      k++; 
    } 
    while(i<n1){ 
      arr[k]=L[i]; 
      i++; 
      k++; 
    } 
    while(j<n2){ 
      arr[k]=R[j]; 
      j++; 
      k++; 
    } 
  }



  void quickSort(int arr[]){
    qSort(arr, 0, arr.length-1);
  }



  void qSort(int arr[], int low, int high){
    if (low<high){ 
      int pi=partition(arr, low, high); 
      qSort(arr, low, pi-1); 
      qSort(arr, pi+1, high); 
    }
  }



  int partition(int arr[], int low, int high){ 
    int pivot=arr[high];  
    int i=(low-1);
    for(int j=low;j<high;j++){ 
      if (arr[j]<pivot){ 
        i++; 
        int temp=arr[i]; 
        arr[i]=arr[j]; 
        arr[j]=temp; 
      } 
    }
    int temp=arr[i+1]; 
    arr[i+1]=arr[high]; 
    arr[high]=temp; 
    return i+1; 
  }



  // This is my own implementation of a sorting technique that sorts an array in O(n) time
  // at the expense of space. Not optimal, need to satisfy a lot of conditions, DONT LEARN.
  void sortOn(int arr[]){
    int n=arr.length;
    int max=arr[0];
    for(int i=1;i<n;i++)max=arr[i]>max?arr[i]:max;
    int []array=new int[max+1];
    for(int i=0;i<n;i++)array[arr[i]]=arr[i];
    arr[0]=0;
    n=1;
    for(int i=0;i<array.length;i++)if(array[i]!=0)arr[n++]=array[i];
  }



  // ----- Dynamic Programming Functions ----- //



  HashMap<Integer, Integer> FIBOmemo = new HashMap<Integer, Integer>(); //for fiboDP()
  HashMap<Integer, Integer> KWaysmemo = new HashMap<Integer, Integer>(); //for kWaysDP()



  int fiboDP(int index){
    if(FIBOmemo.containsKey(index))return FIBOmemo.get(index);
    if(index<=2)return 1;
    int f = fiboDP(index-1)+fiboDP(index-2);
    FIBOmemo.put(index, f);
    return f;
  }




  int kWaysDP(int n, int k){
    if(KWaysmemo.containsKey(n))return KWaysmemo.get(n);
    if(n<0)return 0;
    if(n==0)return 1;
    int f=0;
    for(int i=1;i<=k;i++)f=f+kWaysDP(n-i, k);
    FIBOmemo.put(n, f);
    return f;
  }





  // ----- EXECUTION STARTS HERE ----- //



  public static void main(String[] args) {

    Main a = new Main();

    // LinkedList list = new LinkedList();
    // list = LinkedList.insert(list, 1); 
    // list = LinkedList.insert(list, 2); 
    // list = LinkedList.insert(list, 3); 
    // list = LinkedList.insert(list, 4); 
    // list = LinkedList.insert(list, 5); 
    // list = LinkedList.insert(list, 6); 
    // list = LinkedList.insert(list, 7); 
    // list = LinkedList.insert(list, 8); 
    // String arr1[]={"nemo", "a", "b", "d", "z", "x", "y", "w"};
    // String arr2[]={"c", "e", "f", "s", "r", "q", "p", "o", "w"};
    // int arr[]={9,4,6,1,2,0,5,7,3,8};



    double start = System.currentTimeMillis();

    // a.main(arr1);  //STACK OVERFLOW ERROR




    //----- LINKED LIST METHODS -----//

    // use only one of these

    // LinkedList<NodeT> list = new LinkedList<NodeT>(); // predefined java list
    // List<NodeT> list = new LinkedList<NodeT>(); // predefined java list 


    // these are linked list of custom Linked list class above, uncomment that to use these


    // LinkedList.printList(list);
    // LinkedList.reverse(list);
    // LinkedList.printList(list);




    //----- STACKS ------//
    // Stack<NodeS> stack = new Stack<NodeS>();
    // NodeS node = new NodeS(1, 2);
    // stack.push(node);
    // System.out.println(stack.peek().next);




    //----- QUEUES -----//

    //before running this comment out the preimplemented linkedlist class and make sure to delete the 
    //.class file in the directory

    // Queue<NodeS> queue = new LinkedList<NodeS>();
    // NodeS node = new NodeS(1, 2);
    // queue.add(node);
    // System.out.println(queue.peek().next);




    //----- TREES -----//

    //AVL and balancing not implemented, please do that.

    // Tree tree = new Tree();
    // NodeT node = new NodeT(1, 2, "Shubhendu Singh");
    // NodeT node2 = new NodeT(2, 3, "Mayank Tolani");
    // tree.insertInTree(node);
    // tree.insertInTree(node2);
    // tree.insertInTree(new NodeT(0, 1, "Divya Dadarya"));
    // tree.insertInTree(new NodeT(-1, 0, "Ankur Srivastava"));
    // tree.insertInTree(new NodeT(-2, -1, "Aryaman Pande"));
    // tree.insertInTree(new NodeT(3, 4, "Vihaan Verma"));
    // tree.insertInTree(new NodeT(-3, -2, "Safuvan Sajid"));
    // tree.insertInTree(new NodeT(4, 5, "Joieta Banerjee"));
    // tree.insertInTree(new NodeT(-4, -3, "Sajjita Bhatacharya"));
    // tree.insertInTree(new NodeT(5, 6, "Lakshay Gupta"));
    // tree.insertInTree(new NodeT(-5, -4, "Adhyan Pandey"));
    // tree.insertInTree(new NodeT(6, 7, "Shagun Majotra"));
    // tree.insertInTree(new NodeT(-6, -5, "Saloni Varshney"));
    // tree.insertInTree(new NodeT(7, 8, "Manasi Potnis"));
    // tree.insertInTree(new NodeT(-7, -6, "Sanyam Jain"));

    // tree.printTree();
    // System.out.println(tree.searchTreeByIdA(2).name);
    // tree.delete(2);
    // tree.printTree();

    // System.out.println(tree.bfs(-7).name);
    // for(int i=0;i<tree.list.size();i++)System.out.println(tree.list.get(i).a);



    //----- GRAPHS -----//

    //before using this check that the linked list class is commented and the .class file deleted

    // Graph<Integer> g = new Graph<Integer>(); 
    // g.addEdge(0, 1, true); 
    // g.addEdge(0, 4, true); 
    // g.addEdge(1, 2, true); 
    // g.addEdge(1, 3, true); 
    // g.addEdge(1, 4, true); 
    // g.addEdge(2, 3, true); 
    // g.addEdge(3, 4, true);
    // System.out.println(g.showGraph());
    // System.out.println(g.getVertexCount());
    // System.out.println(g.getEdgesCount(true));
    // System.out.println(g.hasEdge(3, 5));
    // System.out.println(g.containsVertex(5));
    // g.BFS(4);
    // System.out.println();
    // g.DFS(4);




    //----- GENERAL METHODS -----//
    // System.out.println(a.firstRecurringCharachterHM(arr1));
    // System.out.println(a.checkTwoArrayContainSameElementBRUTEFORCE(arr1, arr2));
    // System.out.println(a.checkTwoArrayContainSameElement(arr1, arr2));
    // int b[] = a.foobar1(k);
    // System.out.println(a.findNemo(arr));
    // System.out.println(a.goodOlFibonacci(50));
    // System.out.println(a.reverseStringRecur("Shubhendu"));
    // System.out.println(a.basicFibonacci(5000));
    // a.bubbleSort(arr);
    // a.selectionSort(arr);
    // a.insertionSort(arr);
    // a.mergeSort(arr);
    // a.quickSort(arr);
    // a.sortOn(arr);
    // for(int i=0;i<arr.length;i++)System.out.print(" "+ arr[i]);
    // long xx=5, yy=10;
    // System.out.println(a.foobar2_1(xx, yy));




    // ----- DYNAMIC PROGRAMMING ----- //
    // System.out.println(a.fiboDP(5000));
    // System.out.println(a.kWaysDP(3, 2));




    //----- UNION FIND -----//
    // UF uf = new UF(10);
    // uf.unionRoots(4, 6);
    // System.out.println(uf.connected(4, 6));




    double end = System.currentTimeMillis();

    System.out.println();

    System.out.println((end-start)+" ms");

  }
}