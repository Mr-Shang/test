package Queue;

import List.Node;

/**
 * 优先级队列
 * 
 * @author 东
 *
 */
public class PriorityQueue implements QueueI {
	private Node front;// 队首的引用
	private Node rear;// 队尾的引用

	public PriorityQueue() {
		front = rear = null;
	}

	@Override
	public void clear() throws Exception {
		front = rear = null;
	}

	@Override
	public boolean isEmpty() throws Exception {
		return front == null;
	}

	@Override
	public int length() throws Exception {
		Node p = front;
		int length = 0;
		while (p != null) {
			p = p.next;
			++length;
		}
		return length;
	}

	@Override
	public Object peek() throws Exception {
		if (front == rear) {
			return null;
		} else {
			return front.data;
		}
	}

	@Override
	public void offer(Object object) throws Exception {
		PriorityData priorityData = (PriorityData) object;
		Node s = new Node(priorityData);// 构造一个新节点
		if (front == null) {// 队列为空
			front = rear = s;// 修改队列的首尾结点
		} else {
			Node p = front, q = front;
			while (p != null && priorityData.priority >= ((PriorityData) p.data).priority) {// 新结点的数据域的值与队列结点的数据域的值进行比较
				q = p;
				p = p.next;
			}
			if (p == null) {// p为空
				rear.next = s;// 将新节点加入到队尾
				rear = s;// 修改队尾指针
			} else if (p == front) {//// p的优先级大于队首结点的优先级
				s.next = front;// 将新节点加入到队首
				front = s;// 修改队首结点
			} else {
				q.next = s;// 将新节点加入到队中部
				s.next = p;
			}
		}
	}

	@Override
	public Object poll() throws Exception {
		if (front == rear) {
			return null;
		} else {
			Node p = front;
			front = front.next;
			return p.data;
		}
	}

	public void display() throws Exception {
		if (!isEmpty()) {
			Node p = front;
			while (p != null) {
				PriorityData priorityData = (PriorityData) p.data;
				System.out.println(priorityData.elem + " " + priorityData.priority);
				p = p.next;
			}
		} else {
			System.out.println("此队为空！");
		}
	}

}
