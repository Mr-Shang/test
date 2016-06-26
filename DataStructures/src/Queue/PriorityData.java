package Queue;

/**
 * 优先级队列
 * 
 * @author 东
 *
 */
public class PriorityData {
	public Object elem;// 结点的数据元素值
	public int priority;// 结点的优先级

	public PriorityData(Object elem, int priority) {
		this.elem = elem;
		this.priority = priority;
	}

}
