// https://leetcode.com/problems/integer-to-roman

class Solution {
    public String intToRoman(int num) {
    
        StringBuilder sb = new StringBuilder();
        
        int counter=0;
        while(num!=0)
        {
            if(num/1000!=0) //convert thousands into Roman
            {
                counter=num/1000;
                while(counter!=0) 
                {
                    sb.append("M");
                    counter--;
                }
                num=num%1000;   //forward to hundreads
                
            }else if(num/100!=0)// convert hundreads into Roman
            {
                counter=num/100;
                if(counter==9)
                {
                    sb.append("CM");
                    num=num%100;    //forward to tens
                }else if(counter==4)
                {
                    sb.append("CD");
                    num=num%100;
                }else if(counter>=5){
                    sb.append("D");
                    while(counter-5>0)
                    {
                        sb.append("C");
                        counter--;
                    }
                    num=num%100;
                    
                }else
                {
                    while(counter!=0)
                    {
                        sb.append("C");
                        counter--;
                    }
                    num=num%100;
                }
                
                
                
            }else if(num/10!=0) // convert tens into Roman
            {
                counter=num/10;
                if(counter==9)
                {
                    sb.append("XC");
                    num=num%10; //forward to units
                }else if(counter==4)
                {
                    sb.append("XL");
                    num=num%10;
                }else if(counter>=5)
                {
                    sb.append("L");
                    while(counter-5>0)
                    {
                        sb.append("X");
                        counter--;
                    }
                    num=num%10;
                    
                }else{
                    while(counter!=0)
                    {
                        sb.append("X");
                        counter--;
                    }
                    num=num%10;
                }
            }else if(num/1!=0)  // convert units into Roman
            {
                counter=num/1;
                if(counter==9)
                {
                    sb.append("IX");
                    break;      //exit the loop, the process is done
                }else if(counter==4)
                {
                    sb.append("IV");
                    break;
                }else if(counter>=5){
                    sb.append("V");
                    while(counter-5>0)
                    {
                        sb.append("I");
                        counter--;
                    }
                    break;
                    
                }else{
                    while(counter!=0)
                    {
                        sb.append("I");
                        counter--;
                    }
                    break;
                }
            }
            
        }
        
        
        return sb.toString();
        
        
        
    }
}