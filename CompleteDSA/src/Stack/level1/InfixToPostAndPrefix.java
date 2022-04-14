package Stack.level1;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostAndPrefix {
	
	
	public static int priority(char ch) {
		if(ch=='+' || ch=='-')
			return 1;
		else if(ch=='*' || ch=='/')
			return 2;
		else 
			return -1;
	}
	public static void infixToPostAndPrefix(String exp) {
		Stack<Character>op=new Stack<>();
		Stack<String>pre=new Stack<>();
		Stack<String>post=new Stack<>();
		//a*(b-c+d)/e
		for(int i=0;i<exp.length();i++) {
			char ch=exp.charAt(i);
			if((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z') || (ch>='0'&&ch<='9')) {
				pre.push(ch+"");
				post.push(ch+"");
//				System.out.println(pre.peek()+"  "+post.peek());
			}
			else if(ch=='(')
				op.push(ch);
			else if(ch==')') {
				//do operation till openeing bracket is encountered
				while( op.peek()!='(') {
					//for pre order
					String rvpre=pre.pop();
					String lvpre=pre.pop();
					char operator=op.pop();
					String preres=operator+lvpre+rvpre;
					pre.push(preres);
					// for post
					String rvpost=post.pop();
					String lvpost=post.pop();
					String postres=lvpost + rvpost+operator;
					post.push(postres);
				}
				op.pop();
			}
			else if(ch == '+' || ch=='-'|| ch=='/' || ch=='*') {
				//
				while(!op.isEmpty() && op.peek()!='(' && priority(op.peek())>= priority(ch)) {
					String rvpre=pre.pop();
					String lvpre=pre.pop();
					char operator=op.pop();
					String preres=operator+lvpre+rvpre;
					pre.push(preres);
					// for post
					String rvpost=post.pop();
					String lvpost=post.pop();
					String postres=lvpost + rvpost+operator;
					post.push(postres);
				}
				op.push(ch);
//				System.out.println(op.peek());
			}
			
		}
		while (!op.isEmpty()) {
			String rvpre=pre.pop();
			String lvpre=pre.pop();
			char operator=op.pop();
			String preres=operator+lvpre+rvpre;
			pre.push(preres);
			// for post
			String rvpost=post.pop();
			String lvpost=post.pop();
			String postres=lvpost + rvpost+operator;
			post.push(postres);
			
		}
		System.out.println(post.peek());
		System.out.println(pre.peek());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String exp=sc.nextLine();
		infixToPostAndPrefix(exp);

	}

}
//a*(b-c+d)/e
