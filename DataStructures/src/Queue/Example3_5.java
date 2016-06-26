package Queue;

import List.SqList;

/**
 * 将1~n的自然数排列成环形，使得每相邻两数之和为素数，从而构成一个环。
 * 
 * @author 东
 *
 */
public class Example3_5 {
	// 判断正整数是否是素数
	public boolean isPrime(int num) {
		if (num == 1) // 整数1返回false
			return false;
		Double n = Math.sqrt(num);// 求平方根
		for (int i = 2; i <= n.intValue(); i++)
			if (num % i == 0) // 模为0返回false
				return false;
		return true;
	}

	public SqList makePrimeRing(int n) throws Exception {
		if (n % 2 != 0) // n为奇数则素数环不存在
			throw new Exception("素数环不存在！");
		SqList L = new SqList(n);// 构造一个顺序表，存放素数环的数据元素
		L.insert(0, 1);// 初始化顺序表的收元素为1
		LinkQueue Q = new LinkQueue();// 构造一个链队列，用来存放自然数
		for (int i = 2; i <= n; i++) // 初始化链队列
			Q.offer(i);
		return insertRing(L, Q, 2, n);// 返回素数环
	}

	// 在一个顺序表中插入第m个数，使其与顺序表第m-1个数的和为素数，若m等于n，则还要满足第m个数与1的和也是素数，程序返回顺序表。
	public SqList insertRing(SqList L, LinkQueue Q, int m, int n) throws Exception {
		int count = 0;// 记录遍历队列中的数据元素的个数，防止在一次循环中重复遍历
		while (!Q.isEmpty() && count <= n - m) {// 队列不为空且为重复遍历队列
			int p = (Integer) Q.poll();
			int q = (Integer) L.get(L.length() - 1);// 取出顺序表中的最后一个数据元素，
			if (m == n) {// 为队列的最后一个数据元素
				if (isPrime(p + q) && isPrime(p + 1)) {// 满足素数环的条件
					L.insert(L.length(), p);// 插入到顺序表的表尾
					return L;
				} else 
					Q.offer(p);// 不满足素数环的条件，将p入队尾
			} else if (isPrime(p + q)) {// 未遍历到队列的最后一个数据元素，且满足素数环的条件
				L.insert(L.length(), p);// 插入到顺序表的表尾
				if (insertRing(L, Q, m + 1, n) != null) // 递归调用，若返回值不为空，即成功找到素数环
					return L;
				L.remove(L.length() - 1);// 移出顺序表表尾的元素
				Q.offer(p);
			} else 
				Q.offer(p);// 加入到队的尾部
			++count;// 遍历次数加1
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		Example3_5 e = new Example3_5();
		SqList L = e.makePrimeRing(6);
		// System.out.println(L);
		for (int i = 0; i < L.length(); i++) 
			System.out.print(L.get(i) + " ");
	}

}
