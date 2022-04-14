package Stack.level1;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
	public static int calculate(int lv,int rv,char op) {
		if(op=='+')
			return lv+rv;
		else if(op=='-')
			return lv-rv;
		else if(op=='/')
			return lv/rv;
		else if (op=='*')
			return lv*rv;
		else
			return -1;
		
	}
	public static int priority(char ch) {
		if(ch=='+'||ch=='-')
			return 1;
		else if(ch=='/'|| ch=='*')
			return 2;
		else 
			return -1;
	}
	public static int infixEvaluation(String exp) {
		Stack<Character>op=new Stack<>();
		Stack<Integer>val=new Stack<>();
		for(int i=0;i<exp.length();i++) {
			char ch=exp.charAt(i);
			if(ch>='0' && ch<='9')
				val.push(ch-'0');
			else if(ch=='(')
					op.push(ch);
			else if(ch==')') {
				//solve all the things inside closing and opening bracket
				while(!op.isEmpty()&&op.peek()!='(') {
					int rv=val.pop();
					int lv=val.pop();
					char operator=op.pop();
					int res=calculate(lv,rv,operator);
					val.push(res);
				}
				op.pop();//for openeing bracket;
				
			}
			else if(ch=='+' || ch=='-' || ch=='/' || ch=='*') {
				//before pushing operator into the stack solve for all the operator whose priority is >= current character
				while(!op.isEmpty() && priority(op.peek())>=ch) {
					int rv=val.pop();
					int lv=val.pop();
					char operator=op.pop();
					int res=calculate(lv,rv,operator);
					val.push(res);
				}
				op.push(ch);
			}
		}
		while(!op.isEmpty()) {
			int rv=val.pop();
			int lv=val.pop();
			char operator=op.pop();
			int res=calculate(lv,rv,operator);
			val.push(res);
		}
		return val.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String exp=sc.nextLine();
		System.out.println(infixEvaluation(exp));

	}
}
