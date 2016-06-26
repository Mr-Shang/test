package Stack;

import java.util.Scanner;

/**
 * 用栈实现分隔符的匹配
 * 
 * @author 东
 *
 */
public class Example3_1 {
	private final static int LEFT = 0;// 记录分隔符为“左”的分割符
	private final static int RIGHT = 0;// 记录分隔符为“右”的分割符
	private final static int OTHER = 2;// 记录分隔符为其他的分隔符
	private static Scanner in;

	public int verifyFlag(String str) {
		if ("(".equals(str) || "[".equals(str) || "{".equals(str) || "/*".equals(str)) {//左分隔符
			return LEFT;
		} else if (")".equals(str) || "]".equals(str) || "}".equals(str) || "*/".equals(str)) {//有分割符
			return RIGHT;
		} else {
			return OTHER;
		}
	}
//校验匹配规则，分隔符str1和str2是否匹配
	public boolean matches(String str1, String str2) {
		if (("(".equals(str1) && ")".equals(str2)) || ("[".equals(str1) && "]".equals(str2))
				|| ("{".equals(str1) && "}".equals(str2)) || ("/*".equals(str1) && "*/".equals(str2))) {
			return true;
		}
		return false;
	}

	private boolean isLegal(String str) throws Exception {
		if (!"".equals(str) && str != null) {
			SqStack sqStack = new SqStack(100);//新建最大存储空间为100的顺序栈
			int length = str.length();
			for (int i = 0; i < length; i++) {
				char c = str.charAt(i);//指定索引处的char值
				String t = String.valueOf(c);//转化成字符串类型
				if (i != length) {//c不是最后一个字符
					//分隔符是“/*”或者“*/”
					if (('/' == c && '*' == str.charAt(i + 1)) || ('*' == c && '/' == str.charAt(i + 1))) {
						t = t.concat(String.valueOf(str.charAt(i + 1)));
						//与最后一个字符相连
						//跳过一个字符
						++i;
					}
				}
				if (LEFT == verifyFlag(t)) {//为左分割符
					sqStack.push(t);//入栈
				} else if (RIGHT == verifyFlag(t)) {//为又分割符
					if (sqStack.isEmpty() || !matches(sqStack.pop().toString(), t)) {//右分隔符与栈顶元素不匹配
						throw new Exception("错误：java语句不合法！");
					}
				}
			}
			if (sqStack.isEmpty()) {//栈中没有匹配的字符串
				throw new Exception("错误：java语句不合法！");
			}
			return true;
		} else {
			throw new Exception("错误：java语句为空！");
		}
	}

	public static void main(String[] args) throws Exception {
		Example3_1 e = new Example3_1();
		System.out.println("请输入java语句：");
		in = new Scanner(System.in);
		if (e.isLegal(in.nextLine())) {
			System.out.println("java语句合法！");
		} else {
			System.out.println("错误：java语句不合法！");
		}
	}

}
