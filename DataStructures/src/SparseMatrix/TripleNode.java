package SparseMatrix;

/**
 * 稀疏矩阵的三元组表示法 结点定义
 * 
 * @author 东
 *
 */
public class TripleNode {
	public int row;// 行号
	public int column;// 列号
	public int value;// 元素值

	public TripleNode(int row, int column, int value) {
		super();
		this.row = row;
		this.column = column;
		this.value = value;
	}

	public TripleNode() {
		this(0, 0, 0);
	}

}
