package List;

import java.util.Scanner;

/**
 * 输出元素的前驱节点
 * 
 * @author 东
 *
 */
public class Main {

	private static Scanner in;

	public static void main(String[] args) throws Exception {
		int n = 10;
		SqList sqList = new SqList(80);
		for (int i = 0; i < n; i++) {
			sqList.insert(i, i);
		}
		System.out.println("请输入i的值： ");
		in = new Scanner(System.in);
		int i = in.nextInt();
		if (0 < i && i <= n) {
			System.out.println("第" + i + "个元素的直接前驱是： " + sqList.get(i - 1));
		} else {
			System.out.println("第" + i + "个元素不存在前驱");
		}
	}

}
