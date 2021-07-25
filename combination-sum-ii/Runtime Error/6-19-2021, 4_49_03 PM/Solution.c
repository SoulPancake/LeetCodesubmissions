// https://leetcode.com/problems/combination-sum-ii

int** ret;
void getArray(int** ret,int* curSize,int temp[],int tpos,int** columnSize,int candidates[],int n,int target,int pos){
	if(target < 0) return;
	else if(target==0){
		for(int i=0;i<tpos;i++) ret[*curSize][i]=temp[i];
		(*columnSize)[*curSize] = tpos;
		(*curSize)++;
	}
	else{
		if(pos >= n) return;
		int current=candidates[pos];
		for(int i=pos;i<n;i++){
		    if(i!=pos&&candidates[i]==candidates[i-1]){
		        continue;
		    }
			else{
			    temp[tpos++]=candidates[i];
			    getArray(ret,curSize,temp,tpos,columnSize,candidates,n,target-candidates[i],i+1);
			    tpos--;
			} 
		}
	}
}
void getSizeAndLength(int candidates[], int n, int target, int pos, int* returnSize, int* length, int tpos){
    if(target < 0) return;
    else if(target == 0){
    	(*returnSize)++;
    	if(tpos > *length) *length = tpos;
    }
    else{
    	if(pos >= n) return;
        int current = candidates[pos];
        for(int i=pos; i<n; i++){
            if(i!=pos&&candidates[i]==candidates[i-1]){
                continue;
            }
            else{
            	tpos++;
                getSizeAndLength(candidates, n, target-candidates[i], i+1, returnSize, length, tpos);
                tpos--;
            }
        }
    }
}
int compare(const void* a,const void* b){
	return (*(int*)a-*(int*)b);
}
int **combinationSum2(int candidates[],int n,int target,int **columnSize,int *returnSize){
	qsort(candidates,n,sizeof(int),compare);
	int length=0;
	getSizeAndLength(candidates, n, target, 0, returnSize, &length, 0);
	ret = (int**)malloc(sizeof(int*)*(*returnSize));
	for(int i=0; i<*returnSize; i++) ret[i] = (int*)malloc(sizeof(int)*length);
	*columnSize=(int*)malloc(sizeof(int)*(*returnSize));
	int temp[length];
	int curSize=0;
	getArray(ret,&curSize,temp,0,columnSize,candidates,n,target,0);
	return ret;
}