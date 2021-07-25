// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    
    public int find(int fen[], int x) {
        if(x < 0) return 0;
        int i = x + 1;
        int n = fen.length;
        int sum = 0;
        while(i > 0) {
            sum += fen[i - 1];
            i -= (i & (-i));
        }
        return sum;
    }
    
    public void update(int fen[], int x, int val) {
        int i = x + 1;
        int n = fen.length;
        while (i <= n) {
            fen[i - 1] += val;
            i += (i & (-i));
        }
    }
    
    public List<Integer> countSmaller(int[] a) {
        int n = a.length;
        
        // remap the numbers to whole numbers range
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i : a) {
            map.put(i, 0);
        }
        int val = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map.put(entry.getKey(), val);
            val++;
        }
        int arr[] = new int[n];
        for(int i =0 ; i < n; i++) {
            arr[i] = map.get(a[i]);
        }
        
        // making fenwick tree
        int fen[] = new int[val];
        int ans[] = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = find(fen, arr[i] - 1);
            update(fen, arr[i], 1);
        }
        
        // converting our answer array to list
        List<Integer> list = new ArrayList<>();
        for(int i : ans) {
            list.add(i);
        }
        return list;
    }
}