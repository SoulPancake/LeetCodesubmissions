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
                int swap=image[i][j];
                image[i][j]=image[i][last];
                image[i][last]=swap;
                last--;
                image[i][j]=image[i][j]^1;//Inverting
                image[i][last]=image[last]^1;
            }
        }
        return image;
    }
}