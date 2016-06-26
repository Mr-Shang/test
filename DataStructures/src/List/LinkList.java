package List;

import java.util.Scanner;

public class LinkList implements ListI {

	public Node head;// 单链表的头指针
	private Scanner sc;
	private Scanner sc2;

	public LinkList() {// 单链表的构造函数
		head = new Node();// 初始化头结点
	}

	public LinkList(int n, boolean Order) throws Exception {// 构造一个长度为n的单链表
		this();// 初始化他的头结点
		if (Order) {// 用尾差法顺序建立单链表
			createFromTail(n);
		} else {// 用头插法顺序建立单链表
			createFromHead(n);
		}
	}

	// 用头插法建立单链表，其中单链表结点个数为n。
	public void createFromHead(int n) throws Exception {
		sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {// 逆序输入n个结点的数据域
			insert(0, sc.next());// 生成新的结点，插入到表头
		}
	}

	// 用尾插法建立单链表，其中单链表的结点个数为n
	public void createFromTail(int n) throws Exception {
		sc2 = new Scanner(System.in);
		for (int i = 0; i < n; i++) {// 输入n个结点的数据域值
			insert(length(), sc2.next());// 生成新的结点，插入到表尾
		}
	}

	// 将一个已经存在的单链表置空
	@Override
	public void clear() {
		head.data = null;
		head.next = null;
	}

	// 判断带有头结点的单链表是否为空
	@Override
	public boolean isEmpty() {
		return head.next == null;
	}

	// 求带头结点的单链表的长度
	@Override
	public int length() {
		Node p = head.next;// 初始化，p指向首节点，length为计数器
		int length = 0;
		while (p != null) {// 从首节点开始向后查找，直到p为空
			p = p.next;// 指向后继结点
			++length;// 长度加1
		}
		return length;
	}

	// 读取带有头结点的单链表中第i个结点
	@Override
	public Object get(int i) throws Exception {
		Node p = head.next;// 初始化，p指向首节点，j为计数器
		int j = 0;
		while (p != null && j < i) {// 从首节点开始向后查找，知道p指向第i个结点或p为空
			p = p.next;// 指向后继结点
			++j;// 计数器加1
		}
		if (j < i || p == null) {// i小于0或者大于表长减1时，不合法
			throw new Exception("第" + i + "个元素不存在");
		}
		return p.data;// 返回结点p的数据域的值
	}

	// 在带头结点的单链表的第i个结点之前扎入一个职位x的结点
	@Override
	public void insert(int i, Object x) throws Exception {
		Node p = head;// 初始化，p指向首节点，j为计数器
		int j = -1;
		while (p != null && j < i - 1) {// 寻找第i个结点的2前驱。
			p = p.next;
			++j;
		}
		if (j > i - 1 || p == null) {// i不合法
			throw new Exception("插入的位置不合法");// 抛出异常
		}
		Node s = new Node(x);// 生成新的结点
		s.next = p.next;// 修改链，是新的结点插入到单链表中
		p.next = s;
	}
	/*
	 * // 在不带头结点的单链表的第i个结点之前扎入一个职位x的结点
	 * 
	 * @Override public void insert(int i, Object x) throws Exception { Node p =
	 * head.next;//初始化，p指向首节点，j为计数器 int j = -1; while (p != null && j < i - 1)
	 * {//寻找第i个结点的2前驱。 p = p.next; ++j; } if (j > i - 1 || p == null) {//i不合法
	 * throw new Exception("插入的位置不合法");//抛出异常 } Node s=new Node(x); if (i==0)
	 * {//插入位置为表头时 s.next=head; head=s; } else{//插入的位置为表尾或者表中间时。 s.next=p.next;
	 * p.next=s; } }
	 */

	// 删除带头结点的单链表中第i个结点
	@Override
	public void remove(int i) throws Exception {
		Node p = head;// 初始化p指向头结点，j为计数器。
		int j = -1;
		while (p.next != null && j < i - 1) {// 寻找第i个结点，如果是结点元素值为x则变为p.next.data!=x,
			p = p.next;
			++j;
		}
		if (j > i - 1 || p.next == null) {
			throw new Exception("删除位置不合法");
		}
		p.next = p.next.next;// 修改指针，是待删除的结点从单链表中脱离出来
	}

	// 在带头结点的单链表中查找值为x的结点的位置
	@Override
	public int indexOf(Object x) {
		Node p = head.next;// 初始化，p指向首节点，j为计数器
		int j = 0;
		// 从单链表的首节点开始查找，知道p.data为x或者到达单链表的结尾
		while (p != null && !p.data.equals(x)) {
			p = p.next;// 指向下一个结点
			++j;// 计数器加1
		}
		if (p != null) {
			return j;// 返回x结点的位置
		} else {
			return -1;// x不在单链表中，返回-1
		}
	}

	// 输出单链表中所有结点
	@Override
	public void display() {
		Node node = head.next;
		while (node != null) {
			System.out.print(node.data + "　");
			node = node.next;
		}
		System.out.println();
	}

}
