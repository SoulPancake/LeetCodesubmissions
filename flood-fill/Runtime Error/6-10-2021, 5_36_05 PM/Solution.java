// https://leetcode.com/problems/flood-fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int sourceColor=image[sr][sc];
        helper(image,sr,sc,newColor,sourceColor);
        return image;
    }
    private void helper(int[][] image, int i, int j, int newColor,int sourceColor)
    {
        if(i<0 || i>image.length-1 || j<0 || j>image[0].length-1 || image[i][j]!=sourceColor)
            return;
        
        if(image[i][j]==sourceColor)
             image[i][j]=newColor; //Source Color is the starting pixel color
                                   //Coloured this particular index
        
        helper(image,i+1,j,newColor,sourceColor); //Down
        helper(image,i,j+1,newColor,sourceColor); //right
        helper(image,i-1,j,newColor,sourceColor); //Up
        helper(image,i,j-1,newColor,sourceColor); //Left
        return;
    }
}