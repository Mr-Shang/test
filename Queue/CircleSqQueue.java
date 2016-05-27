package Queue;

/**
 * 顺序循环队列
 * 出队和入队的时间复杂度为O(1),其他操作的时间复杂度也为O（1）
 * @author 东
 *
 */
public class CircleSqQueue implements QueueI {
	private Object[] queueElem;// 队列的存储空间
	private int front;// 队列的头引用，若队列不为空，指向队首元素
	private int rear;// 队列的尾引用，若队列不为空，指向队尾元素的下一个存储位置
	// 循环队列类的构造函数

	public CircleSqQueue(int maxSize) {
		front = rear = 0;// 队首，队尾初始化为0
		queueElem = new Object[maxSize];// 为队列分配maxSize的存储单元
	}

	// 队列置空
	@Override
	public void clear() throws Exception {
		front = rear = 0;
	}

	// 判断队列是否为空
	@Override
	public boolean isEmpty() throws Exception {
		return front == rear;
	}

	// 求队列的长度
	public int length() throws Exception {
		return (rear - front + queueElem.length) % queueElem.length;
	}

	// 读取队首元素
	@Override
	public Object peek() throws Exception {
		if (front == rear) {
			return null;
		} else {
			return queueElem[front];// 返回队首元素
		}
	}

	// 入队
	@Override
	public void offer(Object object) throws Exception {
		if (front == (rear + 1) % queueElem.length) {// 队列满
			throw new Exception("队列已满！");
		} else {
			queueElem[rear] = object;// 将object放入到rear所指向的存储位置中，使其成为新的队尾元素
			rear = (rear + 1) % queueElem.length;// 修改队尾指针
		}
	}

	// 出队
	@Override
	public Object poll() throws Exception {
		if (front == rear) {// 队列为空
			throw new Exception("队列为空！");
		} else {
			front = (front + 1) % queueElem.length;// 修改队首指针
			return queueElem[front];// 返回队首元素
		}
	}

	// 输出队列中所有数据元素
	public void display() throws Exception {
		if (!isEmpty()) {
			for (int i = front; i != rear; i = (i + 1) % queueElem.length) {
				System.out.print(queueElem[i].toString() + " ");
			}
			System.out.println();
		} else {
			System.out.println("此队列为空！");
		}
	}

}
