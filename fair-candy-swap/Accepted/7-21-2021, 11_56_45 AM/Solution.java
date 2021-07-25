// https://leetcode.com/problems/fair-candy-swap

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sb=0,sa=0;
        for(int a : aliceSizes)
            sa+=a;
        for(int b: bobSizes)
            sb+=b;
        int diff=(sb-sa)/2;
        
        HashSet<Integer> bob=new HashSet<>();
        for(int c : bobSizes)bob.add(c);
        
        for(int a : aliceSizes){
            if(bob.contains(a+diff)){
                return new int[]{a,a+diff};
            }
        }
        
        return new int[]{-1,-1};
    }
}