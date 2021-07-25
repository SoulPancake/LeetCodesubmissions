// https://leetcode.com/problems/count-primes



int countPrimes(int n){
 if (n<=2) return 0;
    int N = n-1;
    int M = N/2+N%2;
    char* index = malloc(M*sizeof(char)); // prime -> 1, otherwise -> 0

    for(int i=0;i<M;i++){// index for odd numbers, 1,3,5,...
        index[i] = 1;
    }
    index[0] = 0; // 1 is not prime number
        
    for(int div=3;div<=sqrt(N);div+=2){
        if (index[div>>1]){
            for(int j=div+(div>>1);j<M;j+=div){
                index[j] = 0;
            }
        }
    }
        
    int total=0;// count total number of primes
    for(int i=0;i<M;i++){
        total += index[i];
    }
    return total+1; // 2 is prime number
}