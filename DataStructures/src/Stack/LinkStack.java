package Stack;

import List.Node;

/**
 * 栈的链式存储
 * 
 * @author 东
 *
 */
public class LinkStack implements StackI {
	private Node top; // 栈顶元素的引用

	// 将栈置空
	@Override
	public void clear() throws Exception {
		top = null;
	}

	// 判断栈是否为空
	@Override
	public boolean isEmpty() throws Exception {
		return top == null;
	}

	// 求栈链的长度
	@Override
	public int length() throws Exception {
		Node p = top;// 初始化，p指向栈顶元素，length为计数器
		int length = 0;
		if (p != null) {// 从栈顶元素开始向后查找，直到p为空
			++length;// 长度加1
			p = p.next;// 指向p的后继结点
		}
		return length;
	}

	// 取栈顶元素并且返回其值
	@Override
	public Object peek() throws Exception {
		if (!isEmpty()) {// 栈非空
			return top.data;// 返回栈顶元素的值
		} else {
			return null;
		}
	}

	// 入栈
	@Override
	public void push(Object object) throws Exception {
		Node p = new Node(object);// 构建新的结点
		p.next = top;// 新节点成为当前栈的栈顶结点
		top = p;
	}

	// 出栈
	@Override
	public Object pop() throws Exception {
		if (isEmpty()) {
			// throw new Exception("栈为空");
			return null;
		} else {
			Node p = top;// p指向栈顶结点（被删除的结点）
			top = top.next;// 修改指针，使栈顶指针指向他的后继结点
			return p.data;// 返回被删除的数据
		}
	}

	// 输出栈中的数据元素,从栈顶到栈低
	public void display() {
		Node p = top;// 初始化栈，p指向栈顶元素
		while (p != null) {// 输出所有非空结点的值
			System.out.println(p.data.toString() + " ");
			p = p.next;// 指针后移
		}
		System.out.println();
	}
}
