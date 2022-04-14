package Stack.level1;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

	public static int[] nextSmallerElementIndexLeft(int [] arr) {
		int n=arr.length;
		int ans[]=new int [n];
		Stack<Integer>st=new Stack<>();
		ans[0]=1;
		st.push(0);
		for(int i=1;i<n;i++) {
			if(arr[st.peek()]>arr[i])
				ans[i]=i-st.peek();
			else {
				while(!st.isEmpty() && arr[st.peek()]<=arr[i])
					st.pop();
				if(st.isEmpty())
					ans[i]=i+1;
				else
					ans[i]=i-st.peek();
			}
			st.push(i);
		}
		
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		int[]ans=nextSmallerElementIndexLeft(arr);
		for(Integer res:ans)
			System.out.print(res +" ");
		System.out.println();

	}

}

// 9 2 5 9 3 1 12 6 8 7
