// https://leetcode.com/problems/word-subsets

class Solution {
   public List<String> wordSubsets(String[] A, String[] B) {
        List<String> out  = new ArrayList<>();
        int n = B.length;
        int[] arr = new int[26]; // least number needed for each letter in a to be subset of any b
        int i = 0;
        for(String b : B){
            int[] brr = new int[26];
            for(char c: b.toCharArray()){
                brr[c-'a']++;
                arr[c-'a'] = Math.max(arr[c-'a'], brr[c-'a']);
            }
        }
        // System.out.println(Arrays.toString(arr));
        for(String a: A){
            int[] arr2 = new int[26];
            for(char c: a.toCharArray()){
                arr2[c-'a']++;
            }
            boolean f = true;
           for(i=0;i<26;i++){
                if(arr[i]>0 && arr2[i]<arr[i]){
                    f = false;
                    break;
                }
            } 
            if(f)
                out.add(a);
        }
        return out;
        
    }
}