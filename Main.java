import java.io.*;
import java.util.*;

class Main {

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


  public static void main(String[] args) {

    Main a = new Main();

    String arr1[]={"nemo", "a", "b", "d"};
    String arr2[]={"c", "e", "f"};

    double start = System.currentTimeMillis();

    // System.out.println(a.checkTwoArrayContainSameElement(arr1, arr2));
    // int b[] = a.foobar1(k);
    // System.out.println(a.findNemo(arr));

    double end = System.currentTimeMillis();
    System.out.println((end-start)+" ms");

  }
}
