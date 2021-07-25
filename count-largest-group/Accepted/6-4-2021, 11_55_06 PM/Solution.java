// https://leetcode.com/problems/count-largest-group

class Solution {
public int countLargestGroup(int n) {
	int[] digitSums = new int[37];
	int maxSize = Integer.MIN_VALUE;
	for (int i = 1; i <= n; i++) {
		int digitSum = digitSum(i);
		digitSums[digitSum]++;
		maxSize = Math.max(maxSize, digitSums[digitSum]);
	}

	int answer = 0;
	for (int i = 1; i < digitSums.length; i++) {
		if (digitSums[i] == maxSize) {
			answer++;
		}
	}

	return answer;
}

public int digitSum(int num) {
	int sum = 0;
	while (num > 0) {
		sum += num%10;
		num /= 10;
	}

	return sum;
}
}