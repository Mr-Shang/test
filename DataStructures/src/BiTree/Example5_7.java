package BiTree;

/**
 * 根据完全二叉树的顺序存储结构建立一棵二叉树的链式存储结构，输出该二叉树的先序，中序，后序遍历和树的深度
 * 
 * @author 东
 *
 */
public class Example5_7 {
	public BiTreeNode createBiTree(String sqBiTree,int index){
		BiTreeNode root=null;
		if (index<sqBiTree.length()) {
			root=new BiTreeNode(sqBiTree.charAt(index));
			root.lchild=createBiTree(sqBiTree, 2*index+1);
			root.rchild=createBiTree(sqBiTree, 2*index+2);
		}
		return root;
	}

	public static void main(String[] args) throws Exception {
		Example5_7 e=new Example5_7();
		String sqBiTree="ABCDEFGH";
		BiTreeNode root=e.createBiTree(sqBiTree, 0);
		BiTree T=new BiTree(root);
		System.out.println("中根遍历：");
		T.inRootTraverse();
		System.out.println();
		System.out.println("二叉树的深度："+T.getDepth(root));
	}

}
