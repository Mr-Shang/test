package BiTree;
/**
 * 结点类定义
 * @author 东
 *
 */
public class BiTreeNode {
	public Object data;//结点的数据
	public BiTreeNode lchild,rchild;//结点的左、右孩子域
	//构造一个空结点
	public BiTreeNode(){
		this(null);
	}
	//构造一棵左，右孩子域为空的二叉树
	public BiTreeNode(Object data){
		this(data,null,null);
	}
	//构造一棵数据域，左，右孩子域都不为空的二叉树
	public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
	

}
