package Stack.level1;

import java.util.Scanner;
import java.util.Stack;

//Q :
//	1. You are given a number n, representing the size of array a.
//	2. You are given n numbers, representing elements of array a.
//	3. You are required to "next greater element on the right" for all elements of array
//Logic : 
//	start from right side of the array

public class NextGreaterElementRight {
	public static int[] nextGreaterElementRight(int [] arr) {
		int ans[]=new int [arr.length];
		Stack<Integer>st=new Stack<>();
		st.push(arr[arr.length-1]);
		ans[arr.length-1]=-1;
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]<st.peek())
				ans[i]=st.peek();
			else {
				while(!st.isEmpty()&&arr[i]>=st.peek())
					st.pop();
				if(st.isEmpty())
					ans[i]=-1;
				else
					ans[i]=st.peek();
			}
			st.push(arr[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int ans[]=nextGreaterElementRight(arr);
		for(Integer res: ans)
			System.out.print(res+" ");
		System.out.println();
	}

}
