package BiTree;

/**
 * 首先由标明空子树的先根遍历序列建立一棵二叉树，然后输出该二叉树的先根、中根、后根遍历
 * 
 * @author 东
 *
 */
public class Example5_6 {

	public static void main(String[] args) throws Exception {
		String preStr="AB##CD###";
		BiTree T=new BiTree(preStr);
		System.out.println("先根遍历：");
		T.preRootTraverse();
		System.out.println();
		System.out.println("中根遍历：");
		T.inRootTraverse();
		System.out.println();
		System.out.println("后根遍历：");
		T.postRootTraverse();
		System.out.println();
	}

}
