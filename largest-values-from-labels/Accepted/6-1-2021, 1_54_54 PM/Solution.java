// https://leetcode.com/problems/largest-values-from-labels

class Solution {

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int[][] arr = new int[values.length][2];

        for (int i = 0; i < values.length; i++) {
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return -(x[0] - y[0]);
            }
        });

        Map<Integer, Integer> labelMap = new HashMap<>();
        int sum = 0;
        int numCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (labelMap.containsKey(arr[i][1]) && labelMap.get(arr[i][1]) == use_limit) {
                continue;
            }

            labelMap.put(arr[i][1], labelMap.getOrDefault(arr[i][1], 0) + 1);
            sum += arr[i][0];
            numCount++;

            if (numCount == num_wanted) break;
        }
        return sum;
    }
}