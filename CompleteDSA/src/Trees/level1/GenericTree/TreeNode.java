package Trees.level1.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TreeNode {
	int data;
	ArrayList<TreeNode>children;
	
	
}
class BuildTree{
	public TreeNode construct() {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		Stack<TreeNode>st=new Stack<>();
		TreeNode root=null;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==-1)
				st.pop();
				else {
					TreeNode node=new TreeNode();
					node.data=arr[i];
					if(!st.isEmpty() && st.size()>0)
						st.peek().children.add(node);
					else
						root=node;
					st.push(node);					
				}
				
			}
			
			return root;
		}
	
}
