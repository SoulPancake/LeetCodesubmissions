// https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance

typedef struct
{
int rating;
int id;
}fil;
int qsortfun1(const void a,const void* b)
{
const fil* c=a;
const fil* d=b;
return d->id-c->id;
}
int qsortfun(const void* a,const void* b)
{
const fil* c=a;
const fil* d=b;
return d->rating-c->rating;
}
int* filterRestaurants(int** arr, int n, int* m, int veg, int p, int dis, int* returnSize){
int i,j,a=0,a1=0;
fil arr1[n];
for(i=0;i<n;i++)
{
if(veg==1)
{
if(arr[i][2]==veg&&arr[i][3]<=p&&arr[i][4]<=dis)
{
arr1[a].rating=arr[i][1];
arr1[a].id=arr[i][0];
a++;
}
}
else
{
if(arr[i][3]<=p&&arr[i][4]<=dis)
{

     arr1[a].rating=arr[i][1];
     arr1[a].id=arr[i][0];
     a++;
       }
  }
}
qsort(arr1,a,sizeof(fil),qsortfun1);
qsort(arr1,a,sizeof(fil),qsortfun);
int *res=malloc(sizeof(int)*a);
for(i=0;i<a;i++)
{
res[a1++]=arr1[i].id;
}
*returnSize=a1;
return res;

}