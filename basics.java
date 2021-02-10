public class basics{
     //lecture 1;
    public static void sepratePN(int[] arr, int n){
     if(arr.length==0) return;
     int pivot=-1;
     int idx=0;
     while(idx<n){
         if(arr[idx]>=0){
             int temp=arr[++pivot];
             arr[++pivot]=arr[idx];
             arr[idx]=temp;
             //swap(arr[++pivot],arr[idx]);
         }
     }
     idx++;

    }
    //seprate 0 1 
    public static seprateZeroOne(int[] arr){
        if(arr.length==0) return 0;
        int pivot=-1;
        int idx=0;
        while(idx<arr.length){
            if(arr[idx]==0){
               int temp=arr[++pivot];
             arr[++pivot]=arr[idx];
             arr[idx]=temp
            }
            idx++;
        }
        
    }
    // seprate 0 1 2 
    
    public void sortColors(int[] arr) {
         if(arr.length==0) return ;
        int n=arr.length;
        int p1=-1,p2=n-1;
        int idx=0;
        while(idx<=p2){
            if(arr[idx]==0){
               swap(arr,++p1,idx++);
            }
            else if(arr[idx]==2){
               swap(arr,idx,p2--);
            }
            else idx++;
        }
    } 
       public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
    public static void reverseArray(int[] arr,int i, int j){
        if(arr.length==0) return;
         //i=0,j=arr.length-1;
        while(i<j){
            swap(arr, i++, j--]);
        }
    } 

    public static void rotateArray(int[] arr){
        if(arr.length==0) return;
        k=(k%m+m)%m;
        reverseArray(arr,0,n-k-1);
        reverseArray(arr,n-k,n-1);
        reverseArray(arr,0,n-1);
    }

    public static int maxSumRotation(int[] arr){
        int sum=0,rotateSum=0;
        int n=arr.length;
        for(int ele:arr) sum+=ele;
        for(int i=0;i<n;i++){
            rotateSum+=i*arr[i];
        }
        int maxSum=rotateSum;
        for(int i=0;i<n;i++){
            rotateSum=rotateSum-sum+arr[i]*n;
            maxSum=Math.max(maxSum, rotateSum-sum+arr[i]*n);
        }
        return maxSum;
    }
//   lecture 2
//leetcode 003
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
        int n=s.length();
        int[] map=new int[128];
        int si=0,ei=0,count=0,len=0;
        while(ei<n){
            if(map[s.charAt(ei++)]++>0 ) count++;
            while(count>0){
                if(map[s.charAt(si++)]-->1 ) count--;
            }
            len=Math.max(len,ei-si);
        }
       return len;
    }
    public static minWindows(String s, String t){
        int nt=s.length();
        int ns=t.length();
        int[] freq=new int[128];
        for(int i=0;i<nt;i++){
            freq[s.charAt(i)]++;
        }
        int si=0,ei=0,require=nt,len=(int)1e8;
        int head=0;
        while(ei<ns){
            if(freq[s.charAt(ei++)]-->0) require--;
            while(require==0){
                if(len>ei-si) len=ei-(head=si);
                if(freq[s.charAt(si++)++==0]) require++;
            }
        }
        return len==(int)1e8?"":s.substring(head,head+len);
    } 
    //lecture 3
    public static String smallestWindow(String s){
        int n= s.length();
        int[] freq=new int[128];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)]=1;
        }
        int require=0;
        for(int ele:freq){
            require+=ele;
        }
        int head=0;
        int si=0,ei=0,len=(int)1e8;
        while(ei<n){
            if(freq[s.charAt(ei++)]-->0) require--;
            while(require==0){
                if(len<ei-si) len=ei-(head=si);
                if(freq[s.charAt(si++)]++==0) require++;
            }
        }
         System.out.println(s.substring(head,head+len));
        }
    
      //leetcode 159
    public static int lengthOfLongestSubstringTwoDistinct(String s){
        int n=s.length();
        int[] freq=new int[128];
        int si=0,ei=0,len=0,distinctCount=0;
        while(ei<n){
            if(freq[s.charAt(si++)]++==0) distinctCount++;
            while(distinctCount>2){
                if(freq[s.charAt(si++)]--==1) distinctCount--;
                if(len<ei-si) len=ei-(head=si);
            }
        }
        return s.substring(head,head+len);

        }

    public static int lengthOfLongestSubstringKDistinct(String s, int k){
        int n=s.length();
        int[] freq=new int[128];
        int si=0,ei=0,len=0,distinctCount=0;
        while(ei<n){
            if(freq[s.charAt(ei++)]++==0) distinctCount++;
            while(distinctCount>k){
                if(freq[s.charAt(si++)]--==1) distinctCount--;
                if(len<ei-si) len=ei-(head=si);
            }
        }
        return s.substring(head,head+len);
        }

    public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
        
    }
    public int maxVowels(String s, int k) {
        int n=s.length();
        int si=0,ei=0,vowelCount=0,maxVowelCnt=0;
        while(ei<n){
            if(isVowel(s.charAt(ei++))) vowelCount++;
            if(ei-si==k){
                maxVowelCnt=Math.max(maxVowelCnt,vowelCount);
                if(isVowel(s.charAt(si++))) vowelCount--;
            }
        }
        return maxVowelCnt;
    }

     
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
    //lecture 4
    //longest subarray with equal number of 0 n 1
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        int psum=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(val==0) val=-1;
            psum+=val;
            if(map.containsKey(psum)){
                maxLen=Math.max(maxLen,i-map.get(psum));
            }
            else map.put(psum,i);
        }
        return maxLen;
        
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

    //number of subarray divisibe by k
     public int subarraysDivByK(int[] A, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0,len=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int SUM=(sum%k+k)%k;
            count+=map.getOrDefault(SUM,0);
             map.put(SUM,map.getOrDefault(SUM,0)+1);
        }
        return count;       
        
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
    // lecture 5
    public int numSubarraysWithSum(int[] arr, int S) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            //if(sum==S) ans++;
            if(map.containsKey(sum-S)){
                ans+=map.get(sum-S);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
        
    }
    //Alt
      
     //1248
      public int numberOfSubarraysAtmostK(int[] arr, int k) {
        int n=arr.length;
        int si=0,ei=0,oddcount=0,res=0;
        while(ei<n){
            if((arr[ei++]&&1)!=0) oddcount++;
            while(oddcount>k){
                if(arr[si++]%2==1) oddcount--;
            }
            res+=(ei-si);
        }
        return res;  
      }

      //  
    
    public int numberOfSubarrays(int[] arr, int k) {
        int n=arr.length;
        if(n==0) return 0;
        return numberOfSubarraysAtmostK(arr,k)-numberOfSubarraysAtmostK(arr,k-1);
    }
    //1004
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


    public static void solve(){
     int[] arr={4,-3,6,7,2,-8,-9,10,11,12,-19};
    }
    public static void main(String[] args){
      solve();
    } 
}