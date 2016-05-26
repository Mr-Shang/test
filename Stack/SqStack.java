package Stack;

/**
 * 栈的顺序存储
 * 
 * @author 东
 *
 */
public class SqStack implements StackI {
	private Object[] stackElem;// 对象数组
	private int top;// 在非空栈中，top始终指向栈顶元素的下一个位置存储位置，当栈空时，top为0
	// 栈的构造函数，构造一个存储空间容量为maxSize的空栈

	public SqStack(int maxSize) {
		top = 0;// 初始化空栈
		stackElem = new Object[maxSize];// 为栈分配maxSize个存储单元
	}

	// 栈置空
	@Override
	public void clear() throws Exception {
		top = 0;
	}

	// 判断栈是否为空
	@Override
	public boolean isEmpty() throws Exception {
		return top == 0;
	}

	// 求栈中数据元素的个数
	@Override
	public int length() throws Exception {
		return top;
	}

	// 取栈顶元素
	@Override
	public Object peek() throws Exception {
		if (!isEmpty()) {// 栈非空
			return stackElem[top - 1];// 返回栈顶元素
		} else {
			return null;
		}
	}

	// 入栈,先判断栈是否满,先存数据在将指针加1
	@Override
	public void push(Object object) throws Exception {
		if (top == stackElem.length) {// 判断栈是否满
			throw new Exception("栈已经满了！");
		} else {
			stackElem[top++] = object;// 将元素入栈
		}
	}

	// 弹栈，判断栈是否为空，先将指针减1，再返回数据元素
	@Override
	public Object pop() throws Exception {
		if (isEmpty()) {// 判断栈是否为空
			return null;
		} else {
			return stackElem[--top];
		}
	}

	// 输出栈中的数据元素,从栈顶到栈低
	public void display() {
		for (int i = top - 1; i >= 0; i--) {
			System.out.print(stackElem[i].toString() + " ");
		}
		System.out.println();
	}

}
