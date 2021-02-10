public class question{
    //find pair in sorted array that adds to a target;
     public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int re=target-nums[i];
            if(map.containsKey(re)){
                return new int[] {map.get(re),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static String getBalanceString(String s){
        int n=s.length();
        int[] lowerCase=new int[128];
        int[] upperCase=new int[128];
        int si=0,ei=0,len=0;
        while(ei<n){
            if(Character.isLowerCase(s.charAt(ei))) lowerCase[s.charAt(ei++)]++;
            else upperCase[s.charAt(ei++)];
            while(containsAllElements(lowerCase, upperCase) && containsAllElements(upperCase, lowerCase)){
               if(Character.isLowerCase(s.charAt(si))) lowerCase[s.charAt(si++)]--;
               else upperCase[s.charAt(si++)]--;
               if(len<ei-si) len=ei-(head=si);
            }
        }
         return len==0?-1:s.substring(head,head+len);
    }
    public boolean containsAllElements(int[] first, int[] second){
        int[] lower=new int[128];
        int[] upper=new int[128];
        for(int ele:first){
            lower[ele]+=(Character.toLowerCase(ele));
        }
        for(int ele:second){
            lower[ele]+=(Character.toLowerCase(ele));
        }
        Arrays.equals(lower, upper) methods
    }

    // sil
     public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return nums[b]-nums[a];});
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            while(pq.size()!=0&&pq.peek()<=i-k) pq.remove();
            pq.add(i);
            if(i>=k-1) ans[idx++]=nums[pq.peek()];
        }
        return ans;
    }

    // max len of subarray containig equal number of 0 1
    public int findMaxLength(int[] nums) {
      HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0,length=0;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(val==0) val=-1;
            sum+=val;
            if(map.containsKey(sum)){
                length=Math.max(length,i-map.get(sum));
            }
            else map.put(sum,i);
        }
        return length;
    }

    // number of subarray containg equal number 0 1 


    public int findMaxLength(int[] nums) {
      HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0,count=0;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(val==0) val=-1;
            sum+=val;
            count+=map.getOrDefault(sum,0);
             map.put(sum,getOrDefault(sum,0)+1);
        }
        return count;
    }

    //longest subarray divisibe by k
    	int longSubarrWthSumDivByK(int arr[], int n, int k)
	{
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0,len=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int SUM=(sum%k+k)%k;
            if(map.containsKey(SUM)){
                len=Math.max(len,i-map.get(SUM));
            }
            else map.put(SUM,map.getOrDefault(SUM,0)+1);
        }
        return len;
    }

    public int numRabbits(int[] arr){
        if(arr.length()==0) return 0;
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:arr){
            if(map.containsKey(ele)){
                ans+=(ele+1);
                map.put(ele,1);
            }
            else {
                map.put(ele,map.get(ele)+1);
            }
            if(map.gt(ele)==ele+1) map.remove(ele);
        }
        return ans;
    }
    
    // 930
    
 // 930
    public int numSubarraysWithSum(int[] arr, int S) {
    int n = arr.length;
    if(n == 0) return 0;
    
    int ei = 0, count = 0, psum = 0;
    
    // int[] freq = new int[30000 + 1];
    // freq[0] = 1;
    
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    while(ei < n){
        psum +=  arr[ei++];
        // if(psum - S >= 0)count += freq[psum - S];
        count += map.getOrDefault(psum - S,0);
        map.put(psum,map.getOrDefault(psum,0) + 1);            
    }
    
    return count;
}
     //ALT 930
    public int numSubarraysWithAtMostSum(int[] arr,int S){
    int si = 0, ei = 0, count = 0, sum = 0, n = arr.length;

    while(ei < n){
        sum += arr[ei++];

        while(sum > k){
            sum -= arr[si++];
        }

        count += ei - si;
    }

    return count;
}

    public int numSubarraysWithSum(int[] arr, int S) {
    int n = arr.length;
    if(n == 0) return 0;
    return numSubarraysWithAtMostSum(arr,S) - (S > 0 ? numSubarraysWithAtMostSum(arr,S - 1) : 0);
}
  
  //1248
  
    public int numberOfSubarraysAtmostK(int[] arr, int k) {
        int n=arr.length;
        int si=0,ei=0,oddcount=0,res=0;
        while(ei<n){
            if(arr[ei++]%2==1) oddcount++;
            while(oddcount>k){
                if(arr[si++]%2==1) oddcount--;
            }
            res+=(ei-si);
        }
        return res;  
      } 
    
    public int numberOfSubarrays(int[] arr, int k) {
        int n=arr.length;
        if(n==0) return 0;
        return numberOfSubarraysAtmostK(arr,k)-numberOfSubarraysAtmostK(arr,k-1);
    }

    public int longestOnes(int[] arr, int k) {
        int n=arr.length;
        int si=0,ei=0,count=0,zeroCount=0;
        while(ei<n){
            if(arr[ei++]==0) zeroCount++;
            while(zeroCount>k){
                if(arr[si++]==0) zeroCount--;
            }
            count=Math.max(count,ei-si);
        }
        return count;  
    } 
    
    //no of submatrices with given sum
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]+=matrix[i-1][j];
            }
        }
         int count=0;
        for(int base=0;base<n;base++){
            for(int row=base;row<n;row++){
                HashMap<Integer,Integer> map=new HashMap<>();
                map.put(0,1);
                int sum=0;
                for(int j=0;j<m;j++){
                    sum+=matrix[row][j]-(base!=0?matrix[base-1][j]:0);
                    count+=map.getOrDefault(sum-target,0);
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return count;
    }
}