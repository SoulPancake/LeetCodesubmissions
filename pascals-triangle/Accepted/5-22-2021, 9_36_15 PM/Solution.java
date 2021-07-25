// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle=new ArrayList<>();
        
        if(numRows==0)
            return triangle;
        
        List<Integer> firstRow=new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        
        for(int i=1;i<numRows;i++)
        {
            List<Integer> PrevRow=triangle.get(i-1);
            List<Integer> row=new ArrayList<>();
            row.add(1); //1 as the first element
            for(int j=1;j<i;j++)
            {
                row.add(PrevRow.get(j-1)+PrevRow.get(j));
            }
            
            row.add(1);
            triangle.add(row);
        }
        
        return triangle;
    }
}