package Stack.level1;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistoGram {

	public static int[] nextSmallestElementIndexOnLeft(int arr[]) {
		int n=arr.length;
		int ans[]=new int[n];
		Stack<Integer>st=new Stack<>();
		ans[0]=-1;
		st.push(0);
		for(int i=1;i<n;i++) {
			if(arr[st.peek()]<arr[i])
				ans[i]=st.peek();
			else {
				while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
					st.pop();
				if(st.isEmpty())
					ans[i]=-1;
				else
					ans[i]=st.peek();
			}
			st.push(i);
		}
		return ans;
	}
	public static int[] nextSmallestElementIndexOnRight(int arr[]) {
		int n=arr.length;
		int ans[]=new int[n];
		Stack<Integer>st=new Stack<>();
		ans[n-1]=n;
		st.push(n-1);
		for(int i=n-2;i>=0;i--) {
			if(arr[st.peek()]<arr[i])
				ans[i]=st.peek();
			else {
				while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
					st.pop();
				if(st.isEmpty())
					ans[i]=n;
				else
					ans[i]=st.peek();
			}
			st.push(i);
		}
		return ans;
	} 
	
	public static int largestAreaHistogram(int arr[]) {
		int maxArea=0;
		int right[]=nextSmallestElementIndexOnRight(arr);
		int left[]=nextSmallestElementIndexOnLeft(arr);
//		System.out.println("left");
//		for(Integer ele:left)
//			System.out.print(ele + " ");
//		System.out.println();
//		System.out.println("rigth");
//		for(Integer ele:right)
//			System.out.print(ele + " ");
//		System.out.println();
		for(int i=0;i<arr.length;i++) {
			int max=(right[i]-left[i]-1)*arr[i];
			maxArea=Math.max(max, maxArea);
		}
		
		return maxArea;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(largestAreaHistogram(arr));

	}

}
//7 6 2 5 4 5 1 6
