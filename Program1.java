class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i<nums.length -1; i++){
            for(int j = i+1; j<nums.length ; j++){
                if(nums[i]+nums[j]==target){ int a[] = {i, j}; return a;}
            }
        }
        return null;
    }
}

class Program1
{
	public static void main(String args[])
	{
		Solution1 object = new Solution1();
		int a[] = {3, 2, 4};
		int b[]=object.twoSum(a, 6);
		for(int i = 0; i<b.length ; i++)System.out.println(b[i]);
	}
}