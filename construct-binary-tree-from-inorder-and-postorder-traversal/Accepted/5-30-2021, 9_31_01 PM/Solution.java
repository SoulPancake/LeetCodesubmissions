// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

class Solution {
	private int ind=0;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		ind=postorder.length-1;
		Map<Integer,Integer> m=new HashMap<>();
		for(int i=0;i<inorder.length;i++)   m.put(inorder[i],i);
		return get_ans(inorder,postorder,m,0,inorder.length-1);
	}
	private TreeNode get_ans(int []inorder,int []postorder,Map<Integer,Integer> m,int s,int e){
		if(s>e) return null;
		TreeNode root=new TreeNode(postorder[ind]);
		int mid=m.get(postorder[ind--]);
		root.right=get_ans(inorder,postorder,m,mid+1,e);
		root.left=get_ans(inorder,postorder,m,s,mid-1);
		return root;
	}
}