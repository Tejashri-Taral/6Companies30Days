class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        int[] freq = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            freq[arr[i] - 1]++;
                if(freq[arr[i] - 1] > 1){
                    ans.add(arr[i]);
                }
            }
        for(int i=0; i<freq.length; i++){
                if(freq[i] == 0){
                    ans.add(i + 1);
                }
            }
        return ans;
    }
}
