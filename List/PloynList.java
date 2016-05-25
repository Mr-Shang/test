package List;

import java.util.Scanner;

public class PloynList extends LinkList {

	private static Scanner in;

	public PloynList(int n) throws Exception {
		head.data = new PolynNode(0, -1);// 初始化头结点
		in = new Scanner(System.in);
		for (int i = 0; i < n; i++) {// 输入n个数据域的值
			double coef = in.nextDouble();// 系数值
			int expn = in.nextInt();// 指数值
			insert(new PolynNode(coef, expn));// 插入到有序链表
		}
	}

	// 按指数递增序列插入到多项式的有序链表
	public void insert(PolynNode e) throws Exception {
		int j = 0;
		while (j < length()) {// 与有序链表中的已有的想进行指数比较
			PolynNode t = (PolynNode) get(j);
			if (t.expn > e.expn) {
				break;
			}
			j++;
		}
		insert(j, e);// 调用父类的插入函数
	}

	// 判定函数，比较多项式中两项的指数，按a的指数值小于，等于，大于b的指数值分别韩慧-1,0,1
	public int cmp(PolynNode a, PolynNode b) {
		if (a.expn < b.expn) {// a和b的指数进行比较
			return -1;
		} else if (a.expn == b.expn) {
			return 0;
		} else {
			return 1;
		}
	}

	// 多项式加法：pa=pa+pb，利用两个多项式的结点构成“和多项式”，并返回LA
	public PloynList addPolyn(PloynList la, PloynList lb) {
		Node ha = la.head;// ha指向新形成的链表的尾节点
		Node qa = la.head.next;// qa指向la中需要计算的当前项
		Node qb = lb.head.next;// qb指向lb中需要计算的当前项
		while (qa != null && qb != null) {// qa，qb同时非空
			PolynNode a = (PolynNode) qa.data;
			PolynNode b = (PolynNode) qb.data;
			switch (cmp(a, b)) {
			case -1:// 多项式la中当前结点是最小值
				ha.next = qa;
				ha = qa;
				qa = qa.next;
				break;
			case 0:// 两者的指数相等
				double sum = a.coef + b.coef;// 求系数和
				if (sum != 0.0) {// 修改多项式la中当前结点的系数值
					a.coef = sum;
					ha.next = qa;
					ha = qa;
					qa = qa.next;// 指向下一结点
					qb = qb.next;
				} else {// 删除多项式la中当前的值
					qa = qa.next;// 指向下一节点
					qb = qb.next;
				}
				break;
			case 1:// 多项式lb中当前节点的指数值小
				ha.next = qb;
				ha = qb;
				qb = qb.next;
				break;
			}
		}
		ha.next = (qa != null ? qa : qb);// 插入剩余的结点
		return la;
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		System.out.println("请输入A多项式的项数：");
		int m = in.nextInt();
		System.out.println("请分别输入多项式A各项的系数和指数：");
		PloynList la = new PloynList(m);
		System.out.println("请输入B多项式的项数：");
		int n = in.nextInt();
		System.out.println("请分别输入多项式B各项的系数和指数：");
		PloynList lb = new PloynList(n);
		la = la.addPolyn(la, lb);
		System.out.println("求和之后的多项式为：");
		la.display();
	}

	// 重载父类的display方法
	public void display() {
		for (int i = 0; i < length(); i++) {
			try {
				PolynNode e = (PolynNode) get(i);
				System.out.println("系数为：" + e.coef + " 指数为： " + e.expn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
