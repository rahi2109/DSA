package Stack.level1;
//Q:
//	((a + b) + (c + d)) -> false
//	(a + b) + ((c + d)) -> true
//Logic:
//	push everything in the stack till closing bracket comes
//	when closing brackets come pop the things from stack till opening bracket is encounter ther count the elements while popping out;
//	if count is 0 return false
//	else at last return true

import java.util.*;
public class DuplicateBrackets {
	public static boolean duplicateColumns(String exp) {
		Stack<Character>st=new Stack<>();
		for(int i=0;i<exp.length();i++) {
			char ch=exp.charAt(i);
			if(ch!=')'&& ch!=' ')
				st.push(ch);
			else if(ch==')') {
				int count=0;
				while(!st.isEmpty()&&st.peek()!='(') {
					st.pop();
					count++;
				}
				if(count==0)
					return true;
				st.pop();// for opening bracket
					
				
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String exp=sc.nextLine();
		System.out.println(duplicateColumns(exp));
		
		
	}

}
