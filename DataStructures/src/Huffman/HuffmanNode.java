package Huffman;
/**
 * 定义Huffman结点
 * @author 东
 *
 */
public class HuffmanNode {
	public int weight;//结点权值
	public int flag;//是否加入到huffman树的标识
	public HuffmanNode parent,lchild,rchild;//父亲、左孩子、右孩子结点
	
	public HuffmanNode() {//构造一个空节点
		this(0);
	}

	public HuffmanNode(int weight) {//构造一个具有权值的结点
		super();
		this.weight = weight;
		flag=0;
		parent=lchild=rchild=null;
	}
	

}
