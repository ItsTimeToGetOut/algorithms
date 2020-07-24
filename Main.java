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


  public static void main(String[] args) {

    Main a = new Main();

    String arr[]={"nemo"};

    double start = System.currentTimeMillis();

    // int b[] = a.foobar1(k);
    // System.out.println(a.findNemo(arr));

    double end = System.currentTimeMillis();
    System.out.println((end-start)+" ms");

  }
}
