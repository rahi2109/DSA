package Stack.level1;

import java.util.Scanner;
import java.util.Stack;

//Q :
//	[(a + b) + {(c + d) * (e / f)}] -> true
//	[(a + b) + {(c + d) * (e / f)]} -> false
//	[(a + b) + {(c + d) * (e / f)} -> false
//	([(a + b) + {(c + d) * (e / f)}] -> false
//			
//Login : 
//	when opening bracket comes push into the stack
//	and when closing bracket comes check the stack top if its opening bracket pop it other wise return false

public class BalanceBrackets {
	public static boolean balanceBracket( String exp) {
		Stack<Character>st=new Stack();
		
		for(int i=0;i<exp.length();i++) {
			char ch=exp.charAt(i);
			if(ch=='('||ch=='{'||ch=='[')
				st.push(ch);
			else if(ch==')'||ch=='}' || ch==']'){
				
				 if(ch==')' && st.peek()!='(')
					return false;
				else if(ch=='}' && st.peek()!='{')
					return false;
				else if(ch==']' && st.peek()!='[')
					return false;
				
				st.pop();
			}
		}

		return st.isEmpty()?true:false;
	}
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		String exp=sc.nextLine();
		System.out.println(balanceBracket(exp));
	}

}
