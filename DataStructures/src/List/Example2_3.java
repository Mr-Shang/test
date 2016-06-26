package List;

import java.util.Scanner;

/**
 * 输出结点的前驱结点
 * 
 * @author 东
 *
 */
public class Example2_3 {

	private static Scanner scanner;

	public static void main(String[] args) throws Exception {
		int n = 10;
		LinkList linkList = new LinkList();
		for (int i = 0; i < n; i++) {
			linkList.insert(i, i);
		}
		System.out.println("请输入i的值： ");
		scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		if (0 < i && i <= n) {
			System.out.println("第" + i + "个元素的直接前驱是：" + linkList.get(i - 1));
		} else {
			System.out.println("第" + i + "个结点没有直接前驱");
		}
	}

}
