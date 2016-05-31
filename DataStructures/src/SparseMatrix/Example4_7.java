package SparseMatrix;

import java.util.Scanner;

public class Example4_7 {
	private static Scanner in;

	public static void main(String args[]) {
		int n;
		in = new Scanner(System.in);
		System.out.println("请输入魔方的阶数（奇数）：");
		n = in.nextInt();
		System.out.println(n + "阶魔方：");
		new Magic(n);
	}
}
