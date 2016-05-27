package Queue;

import List.Node;
/**
 * 队列的链式存储
 * @author 东
 *
 */
public class LinkQueue implements QueueI {

	private Node front;// 队首指针
	private Node rear;// 队尾指针
	// 链队列的构造函数

	public LinkQueue() {
		front = rear = null;
	}

	// 置空
	@Override
	public void clear() throws Exception {
		front = rear = null;
	}

	// 判断是否为空
	@Override
	public boolean isEmpty() throws Exception {

		return front == null;
	}

	// 求队列的长度
	@Override
	public int length() throws Exception {
		Node p = new Node();
		int length = 0;
		while (p != null) {
			p = p.next;// 指针下移
			++length;// 计数器加1
		}
		return length;
	}

	// 取队首元素
	@Override
	public Object peek() throws Exception {
		if (front != null) {// 队列非空
			return front.data;// 返回队首元素的数据域
		} else {
			return null;
		}
	}

	// 入队
	@Override
	public void offer(Object object) throws Exception {
		Node p = new Node(object);// 初始化新结点
		if (front != null) {// 队列非空
			rear.next = p;
			rear = p;// 改变队尾指针
		} else {
			front = rear = p;
		}

	}

	// 出队
	@Override
	public Object poll() throws Exception {
		if (front != null) {// 队列非空
			Node p = front;// p指向队首指针
			front = front.next;// 队首结点出列
			if (p == rear) {// 被删除的结点是队尾结点时
				rear = null;
			}
			return p.data;// 返回队首结点的数据域的值
		} else {
			return null;
		}
	}

}
