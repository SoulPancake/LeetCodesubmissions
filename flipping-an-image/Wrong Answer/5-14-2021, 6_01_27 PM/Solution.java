// https://leetcode.com/problems/flipping-an-image

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        //Flipping is essentially reversing that array
        //REVERSE AND CHANGE ZEROES TO ONES
        
        //LMAO
        
        
        for(int i=0;i<image.length;i++)
        {
            int last=image[i].length-1;
            for(int j=0;j<(image[i].length/2);j++)
            {
                int swap=image[i][j]^1;
                image[i][j]=image[i][last]^1;
                image[i][last]=swap;
                last--;
               
            }
        }
        return image;
    }
}