// https://leetcode.com/problems/largest-values-from-labels

class Solution {
public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
Queue arr1[] = new Queue[20001];
int arr2[] = new int[20001];
for(int i = 0; i < values.length; i++) {
if(arr1[values[i]] == null)
arr1[values[i]] = new LinkedList<>();

        arr1[values[i]].add(labels[i]);
    }
    
    for(int i = 0; i < labels.length; i++) {
         arr2[labels[i]] = use_limit; 
    }
    
   Arrays.sort(values);
    
    int sum = 0;
    for(int i = values.length - 1; i >= 0; i--) {
       int k = values[i];
        int l = arr1[k].remove();
        if(arr2[l] > 0) {
            sum = sum + values[i];
            num_wanted--;
            arr2[l]--;
        }
        
        if(num_wanted == 0)
            break;
    }
    return sum;
}
}