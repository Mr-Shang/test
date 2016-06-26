package List;

import java.util.Scanner;

public class Example2_5 {

	private static Scanner in;

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		int m = 0, n = 0;
		System.out.println("请输入LA链表中结点的个数： ");
		m = in.nextInt();
		System.out.println("请按非递减的方式输入" + m + "个数字");
		LinkList la = new LinkList(m, true);
		System.out.println("请输入LB链表中结点的个数：");
		n = in.nextInt();
		System.out.println("请按非递减的方式输入" + m + "个数字");
		LinkList lb = new LinkList(n, true);
		System.out.println("将单链表LA和LB归并后，新的单链表LA中的各个数据元素：");
		mergeList_L(la, lb).display();
	}

	private static LinkList mergeList_L(LinkList la, LinkList lb) {
		Node pa = la.head.next;// 初始化，pa为la的首节点
		Node pb = lb.head.next;// 初始化，pb为lb的首节点
		Node pc = la.head;// 用la的头晕结点，初始化pc
		int da, db;// 结点值所对应的正数
		while (pa != null && pb != null) {// pa和pb同时非空
			da = Integer.valueOf(pa.data.toString());// 吧字符串转化为整数
			db = Integer.valueOf(pb.data.toString());// 把字符串转化为正数
			if (da <= db) {
				pc.next = pa;// 把la的结点加入到新的la中
				pc = pa;
				pa = pa.next;
			} else {
				pc.next = pb;// 把lb的结点加入到新的la中
				pc = pb;
				pb = pb.next;
			}
		}
		pc.next = (pa != null ? pa : pb);// 插入剩余的结点
		return la;
	}

}
