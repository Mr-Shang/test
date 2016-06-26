package Stack;

/**
 * 实现大数的加法
 * 
 * @author 东 1、将两个数相应位从高到低依次压入栈sA和sB中。
 *         2、若两个加数栈都非空，则依次从栈中弹出栈顶的数字相加，和存入变量partialSum中，，若有进位，则将和的个位数压入结果栈sum中，
 *         并将进位数加入到下一位数字相加的和中，若没有进位，则直接将和压入结果栈sumn中。
 *         3、若某个加数栈为空，则将非空加数栈中的栈顶数字依次弹出与进位相加，和的个位数压入结果栈sum中，知道此该栈为空为止，若最高位有进位，
 *         则最后将1压入到栈sum中。 4、若两个加数购为空，则栈sum中保存的数就是计算结果，
 */
public class Example3_2 {
	public String add(String a, String b) throws Exception {
		LinkStack sum = new LinkStack();// 大数的和。
		LinkStack sA = numSplit(a);// 加数字符串以单个字符的形式放入栈中
		LinkStack sB = numSplit(b);// 被加数字符串以单个字符的形式翻入栈中
		int partiaSum;// 对于两个为的求和
		boolean isCarry = false;// 进位标示
		while (!sA.isEmpty() && !sB.isEmpty()) {// 加数和被加数都不为空
			partiaSum = (Integer) sA.pop() + (Integer) sB.pop();// 对于两个位求和，并在栈中去除加数和被加数中的该位。
			if (isCarry) {// 低位进位
				partiaSum++;// 进位加到此位上
				isCarry = false;// 重置进位标示
			}
			if (partiaSum >= 10) {// 需要进位
				partiaSum -= 10;
				sum.push(partiaSum);
				isCarry = true;// 标示进位
			} else {// 位和不需要进位
				sum.push(partiaSum);// 和放入栈中
			}
		}
		LinkStack temp = !sA.isEmpty() ? sA : sB;// 引用指向加数和被加数中非空栈
		while (!temp.isEmpty()) {
			if (isCarry) {// 最后一次执行加法运算中需要进位
				int t = (Integer) temp.pop();// 取出加数或被加数没有参加的位
				++t;// 进位加到此位上
				if (t >= 10) {// 需要进位
					t -= 10;
					sum.push(t);
				} else {
					sum.push(t);
					isCarry = false;// 重置进位标示
				}
			} else {// 最后一次执行加法运算中不需要进位
				sum.push(temp.pop());// 把加数或者被加数中非空的值放入和中
			}
		}
		if (isCarry) {// 最高位需要进位
			sum.push(1);// 进位放入栈中
		}
		String str = new String();
		while (!sum.isEmpty()) {
			str = str.concat(sum.pop().toString());// 把栈中元素转化成字符串
		}
		return str;
	}

	// 字符串以单个字符的形式放入栈中，并去除字符串中的空格，返回以单个字符为元素的栈
	private LinkStack numSplit(String str) throws Exception {
		LinkStack s = new LinkStack();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);// 指定索引处的char值
			if (' ' == c) {// 去除空格
				continue;
			} else if ('0' <= c && '9' >= c) {// 数字放入栈中
				s.push(Integer.valueOf(String.valueOf(c)));
			} else {
				throw new Exception("错误：输出了非数字类型字符！");
			}
		}
		return s;
	}

	public static void main(String[] args) throws Exception {
		Example3_2 e = new Example3_2();
		System.out.println("两个大数的和为：" + e.add("123456789123456789", "123456789123456789"));
	}

}
