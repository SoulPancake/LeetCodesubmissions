// https://leetcode.com/problems/complement-of-base-10-integer



int bitwiseComplement(int num){
unsigned int result=0; 
    
  unsigned int power=1;
    
    while(num>0)
    {
        result+=(num%2^1)*power;
        power=power*2; //Multiplies power by 2
        num/=2; //Divides by 2
    }
    
    return result;
}