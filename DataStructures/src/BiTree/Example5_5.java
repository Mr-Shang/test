package BiTree;

/**
 * 由先序和中序建立二叉树，输出后序遍历
 * 
 * @author 东
 *
 */
public class Example5_5 {

	public static void main(String[] args) throws Exception {
		String preOrder = "ABDEGCFH";
		String inOrder = "DBGEAFCH";
		BiTree T = new BiTree(preOrder, inOrder, 0, 0, preOrder.length());
		System.out.println("后根遍历：");
		T.postRootTraverse();
	}

}
