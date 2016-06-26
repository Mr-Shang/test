package BiTree;

public class DebugBiTree {
	public BiTree createBiTree(){
		BiTreeNode d=new BiTreeNode('D');
		BiTreeNode g=new BiTreeNode('G');
		BiTreeNode h=new BiTreeNode('H');
		BiTreeNode e=new BiTreeNode('E',g,null);
		BiTreeNode b=new BiTreeNode('B',d,e);
		BiTreeNode f=new BiTreeNode('F',null,h);
		BiTreeNode c=new BiTreeNode('C',f,null);
		BiTreeNode a=new BiTreeNode('A',b,c);
		return new BiTree(a);
	}

	public static void main(String[] args) throws Exception {
		DebugBiTree debugBiTree=new DebugBiTree();
		BiTree biTree=debugBiTree.createBiTree();
		BiTreeNode root=biTree.getRoot();
		System.out.println("（递归）先根遍历序列为：");
		biTree.preRootTraverse(root);
		System.out.println();
		System.out.println("（非递归）先根遍历序列：");
		biTree.preRootTraverse();
		System.out.println();
		System.out.println("（递归）中根遍历学列：");
		biTree.inRootTraverse(root);
		System.out.println();
		System.out.println("(非递归)中根遍历序列：");
		biTree.inRootTraverse();
		System.out.println();
		System.out.println("（递归）后根遍历序列：");
		biTree.postRootTraverse(root);
		System.out.println();
		System.out.println("（非递归）后根遍历序列：");
		biTree.postRootTraverse();
		System.out.println();
		System.out.println("层次遍历：");
		biTree.levelTraverse();
		System.out.println();
	}

}
