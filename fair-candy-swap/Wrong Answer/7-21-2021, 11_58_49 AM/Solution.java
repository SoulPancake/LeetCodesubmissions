// https://leetcode.com/problems/fair-candy-swap

class Solution{
	public int[] fairCandySwap(int[] A, int[] B){
		int sumA = 0;
		for(int i : A){
			sumA += i;
		}
		
		boolean[] f = new boolean[100001];
		int sumB = 0;
		for(int i : B){
			sumB += i;
			f[i] = true;
		}
		int diff = (sumA - sumB) / 2;
		for(int i : A){
			if(i > diff && i - diff < 100000 && f[i-diff]){
				return new int[]{i-diff, i};
			}
		}
		
		throw new IllegalArgumentException();
	}
}