package Stack.level1;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvalutionAndConversion {
	public static int calculate(int lv,int rv,char ch) {
		if(ch=='+')
			return lv+rv;
		else if(ch=='/')
			return lv/rv;
		else if (ch=='-')
			return lv-rv;
		else if(ch=='*')
			return lv*rv;
		else 
			return -1;
		
	}
	
	public static void prefixEvaluationAndConversion(String exp) {
		Stack<Integer>pre=new Stack<>();
		Stack<String>infix=new Stack<>();
		Stack<String>post=new Stack<>();
		
		for(int i=exp.length()-1;i>=0;i--) {
			char ch=exp.charAt(i);
			if(ch>='0' && ch <='9') {
				pre.push(ch-'0');
				post.push(ch+"");
				infix.push(ch+"");
			}
			else if(ch=='+'|| ch=='-' || ch=='/' || ch=='*') {
				//prefix calcualtion
				int lv=pre.pop();
				int rv=pre.pop();
				int preres=calculate(lv, rv, ch);
				pre.push(preres);
				
				//postfix
				String postlv=post.pop();
				String postrv=post.pop();
				String postres=ch+postlv+postrv;
				post.push(postres);
				
				//infix
				String infixlv=infix.pop();
				String infixrv=infix.pop();
				String infixres="("+  infixlv + ch+  infixrv +")";
				infix.push(infixres);
			}
		}
		System.out.println(pre.pop());
		System.out.println(post.pop());
		System.out.println(infix.pop());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String exp=sc.nextLine();
		prefixEvaluationAndConversion(exp);

	}

}
//-+2/*6483