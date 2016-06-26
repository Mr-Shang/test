/*package Stack;



*//**
 * 实现算数表达式的求值
 * 报错。
 * @author 东
 *
 *//*
public class Example3_3 {
	// 将算数表达式转化为后缀表达式的函数，结果一字符串的形式返回
	public String convertToPostfix(String expression) throws Exception {
		LinkStack st = new LinkStack();// 初始化一个运算符栈
		String postfix = new String();// 用于存放输出的后缀表达式
		for (int i = 0; expression != null && i < expression.length(); i++) {
			char c = expression.charAt(i);// 从运算符中读取一个字符
			if (' ' != c) {// 字符不是空格
				if (isOpenParenthesie(c)) {
					st.push(c);// 为开括号，压栈
				} else if (isCloseParenthesie(c)) {// 为闭括号
					char ac = (Character) st.pop();// 弹出栈顶元素
					while (!isOpenParenthesie(ac)) {// 直到为开括号为止
						postfix = postfix.concat(String.valueOf(ac));// 串联到后缀表达式的结尾
						ac = (Character) st.pop();
					}

				} else if (isOperator(c)) {
					if (!st.isEmpty()) {
						char ac = (Character) st.pop();
						while (ac != null && priority(ac.charValue()) >= priority(c)) {
							postfix = postfix.concat(String.valueOf(ac));
							ac = (Character) st.pop();
						}
						if (ac != null) {
							st.push(ac);
						}
					}
					st.push(c);
				} else {
					postfix = postfix.concat(String.valueOf(c));
				}

			}
			while (!st.isEmpty())
				postfix = postfix.concat(String.valueOf(c));
		}
		return postfix;
	}

	public double numberCalculate(String postfix) throws Exception {
		LinkStack st = new LinkStack();
		for (int i = 0; postfix != null && i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if (isOperator(c)) {
				double d2 = Double.valueOf(st.pop().toString());
				double d1 = Double.valueOf(st.pop().toString());
				double d3 = 0;
				if ('+' == c) {
					d3 = d1 + d2;
				}
				if ('-' == c) {
					d3 = d1 - d2;
				}
				if ('*' == c) {
					d3 = d1 * d2;
				}
				if ('/' == c) {
					d3 = d1 / d2;
				}
				if ('%' == c) {
					d3 = d1 % d2;
				}
				if ('^' == c) {
					d3 = Math.pow(d1, d2);
				}
				st.push(d3);
			}
			return (Double) st.pop();
		}
		return 0.0;
	}

	private boolean isCloseParenthesie(char c) {

		return ')' == c;
	}

	private int priority(char c) {
		if (c == '^') {
			return 3;
		}
		if (c == '*' || c == '/' || c == '%') {
			return 2;
		} else if (c == '+' || c == '-') {
			return 1;
		} else {
			return 0;
		}
	}

	private boolean isOperator(char c) {
		if ('+' == c || '-' == c || '*' == c || '/' == c || '%' == c) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isOpenParenthesie(char c) {
		return '(' == c;
	}

	public static void main(String[] args) throws Exception {
		Example3_3 e = new Example3_3();
		String postfix = e.convertToPostfix("(1+2)*(5-2)/2^2+5%3");
		System.out.println(e.numberCalculate(postfix));
	}

}
*/