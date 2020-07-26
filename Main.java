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

    public boolean checkTwoArrayContainSameElementBRUTEFORCE(String arr1[], String arr2[]){
    for(int i=0;i<arr1.length;i++)for(int j=0;j<arr2.length;j++)if(arr1[i]==arr2[j])return true;
      return false;
  }

      public int[] rotateArray(int[] nums, int k) {
        int n[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            n[(i+k)%(nums.length)]=nums[i];
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

    String arr1[]={"nemo", "a", "b", "d", "z", "x", "y", "w"};
    String arr2[]={"c", "e", "f", "s", "r", "q", "p", "o", "w"};

    double start = System.currentTimeMillis();

    // System.out.println(a.checkTwoArrayContainSameElementBRUTEFORCE(arr1, arr2));
    // System.out.println(a.checkTwoArrayContainSameElement(arr1, arr2));
    // int b[] = a.foobar1(k);
    // System.out.println(a.findNemo(arr));

    double end = System.currentTimeMillis();
    System.out.println((end-start)+" ms");

  }
}
