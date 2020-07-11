public class Main{
	public static void main(String[] args){
		int[] nums = {1, 2, 0};
		System.out.println("first missing positive integer is " + findFirstMissingPostive(nums));
	}

	//positive numbers start at 1
	public static int findFirstMissingPostive(int[] nums){
		//shift all positive numbers to the beginning of the array
		int pCount = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > 0){
				int t = nums[i];
				nums[i] = nums[pCount];
				nums[pCount] = t;
				pCount ++;
			}
		}

		//for every positive number(n) make number at index n-1 negative
		for(int i = 0; i < pCount; i++){
			int n = Math.abs(nums[i]);
			if(n <= pCount && nums[n - 1] > 0){
				nums[n - 1] = -nums[n - 1];
			}
		}

		int missing_num = 1;
		//index(with positive number) + 1 is First Minimum Positive
		for(int i = 0; i < pCount; i++){
			if(nums[i] > 0) return missing_num;
			missing_num++;
		}
		return missing_num;
	}
}