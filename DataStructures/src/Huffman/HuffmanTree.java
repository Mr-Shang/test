package Huffman;

public class HuffmanTree {
//求哈弗曼编码的算法，W存放n个字符的权值
	public int[][] huffmanCoding(int[] W) {
		int n = W.length;//字符个数
		int m = 2 * n - 1;//哈弗曼结点个数
		HuffmanNode[] HM = new HuffmanNode[m];
		int i;
		for (i = 0; i < n; i++) {
			HM[i] = new HuffmanNode(W[i]);//构造具有n个权值的结点
		}
		for (i = n; i < m; i++) {//构建哈弗曼树
			//在HM【0……i-1】选择不再哈弗曼树中的且weight值最小的两个结点min1和min2
			HuffmanNode min1 = selectMin(HM, i - 1);
			min1.flag = 1;
			HuffmanNode min2 = selectMin(HM, i - 1);
			min2.flag = 1;
			HM[i] = new HuffmanNode();
			//构造min1和min2的父节点，并修改其父节点的权值
			min1.parent = HM[i];
			min2.parent = HM[i];
			HM[i].lchild = min1;
			HM[i].rchild = min2;
			HM[i].weight = min1.weight + min2.weight;
		}
		//从叶子结点到根节点逆向求每个字符的哈弗曼编码
		int[][] HuffCode = new int[n][n];//分配n个字符编码的存储空间
		for (int j = 0; j < n; j++) {
			int start = n - 1;//编码的开始位置，初始化为数组的结尾
			for (HuffmanNode c = HM[j], p = c.parent; p != null; c = p, p = p.parent) //从叶子结点到根逆向求编码
				if (p.lchild.equals(c)) {//左孩子编码为0
					HuffCode[j][start--]=0;
				}
				else{//右孩子编码为1
					HuffCode[j][start--]=1;
				}
			HuffCode[j][start]=-1;//编码的开始标志位-1，编码是-1之0.1序列
		}
		return HuffCode;
	}
//在HM【0……i-1】选择不再=在哈弗曼树种且weight值最小的结点
	private HuffmanNode selectMin(HuffmanNode[] HM, int end) {
		HuffmanNode min=HM[end];
		for (int i = 0; i <= end; i++) {
			HuffmanNode h=HM[i];
			if (h.flag==0&&h.weight<min.weight) {
				min=h;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] W={23,11,5,3,29,14,7,8};
		HuffmanTree T=new HuffmanTree();
		int[][] HM=T.huffmanCoding(W);//求哈弗曼编码
		System.out.println("哈弗曼编码为：");
		for (int i = 0; i < HM.length; i++) {//输出哈弗曼编码
			System.out.print(W[i]+" ");
			for (int j = 0; j < HM.length; j++) {
				if (HM[i][j]==-1) {//开始标志符读到数组结尾
					for (int k = j+1; k < HM[i].length; k++) {
						System.out.print(HM[i][k]);//输出
					}
					break;
				}
			}
			System.out.println();
		}
	}

}
