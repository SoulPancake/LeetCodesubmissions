// https://leetcode.com/problems/flipping-an-image

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        //Flipping is essentially reversing that array
        //REVERSE AND CHANGE ZEROES TO ONES
        
        //LMAO
        
        
        for(int i=0;i<image.length;i++)
        {
            int j=0;
            int last=image[i].length-1;
            while(j<=last)
            {
                int temp=image[i][j]^1;
                image[i][j]=image[i][last]^1;
                image[i][last]=temp;
                j++;
                last--;
            }
           // if(j==last)   //Do not forget to flip the middle element
              //  image[i][j]^=1;
        }
        return image;
    }
}