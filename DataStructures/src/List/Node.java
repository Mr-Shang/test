package List;

public class Node {
	public Object data;// 存放节点的值
	public Node next;// 后继节点的引用

	// 无参数时的构造函数，可以初始化一个空的结点
	public Node() {
		this(null, null);
	}

	// 带有一个参数是的构造函数，可以构造一个数值域为定值，指针域为空的结点
	public Node(Object data) {
		this(data, null);
	}

	// 带有两个参数是的构造函数，可以构造一个指针域和数据域都是指定参数的结点
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}

}
