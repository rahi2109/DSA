package Stack.level1;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluationAndConversion {
	public static int calculate(int lv,int rv,char ch) {
		if(ch=='+')
			return lv+rv;
		else if(ch=='-')
			return lv-rv;
		else if(ch=='/')
			return lv/rv;
		else if(ch=='*')
			return lv*rv;
		else 
			return -1;
	}
	public static void postfixEvaluationAndConversion(String exp) {
		Stack<Integer>post=new Stack<>();
		Stack<String>pre=new Stack<>();
		Stack<String>infix=new Stack<>();
		for(int i=0;i<exp.length();i++) {
			char ch=exp.charAt(i);
			if( ch>='0'&&ch<='9') {
				post.push(ch - '0');
				pre.push(ch+"");
				infix.push(ch+"");
//				System.out.println(pre.peek()+"  "+post.peek());
			}
			else if(ch=='+'|| ch=='-' || ch=='/' || ch=='*') {
				int rv=post.pop();
				int lv=post.pop();
				int res=calculate(lv,rv,ch);
				post.push(res);
				// infix
				String infixrv=infix.pop();
				String infixlv=infix.pop();
				String infixres="(" + infixlv +ch + infixrv + ")";
				infix.push(infixres);
				
				//prefix
				String prefixrv=pre.pop();
				String prefixlv=pre.pop();
				String prefixres=ch+prefixlv +prefixrv ;
				pre.push(prefixres);
			}
		}
		System.out.println(post.peek());
		System.out.println(pre.peek());
		System.out.println(infix.peek());
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String exp=sc.nextLine();
		postfixEvaluationAndConversion(exp);
	}

}
//264*8/+3-