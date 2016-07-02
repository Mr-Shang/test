package Sort;

/**
 * 待排序顺序表记录类
 * 
 * @author 东
 *
 */
public class RecordNode {
	public Comparable key;// 关键字
	public Object element;// 数据元素

	public RecordNode(Comparable key) {
		super();
		this.key = key;
	}

	public RecordNode(Comparable key, Object element) {
		super();
		this.key = key;
		this.element = element;
	}

}
