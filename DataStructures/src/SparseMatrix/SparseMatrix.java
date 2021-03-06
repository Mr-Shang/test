package SparseMatrix;

public class SparseMatrix {
	public TripleNode data[];// 三元组表
	public int rows;// 行数
	public int cols;// 列数
	public int nums;// 非零个数

	public SparseMatrix(int maxSize) {
		data = new TripleNode[maxSize];// 为顺序表分配配存储单元
		for (int i = 0; i < data.length; i++) {
			data[i] = new TripleNode();
		}
		rows = 0;
		cols = 0;
		nums = 0;
	}

	public void print() {
		int i;
		System.out.println("稀疏矩阵的三元组的存储结构：");
		System.out.println("行数： " + rows + " 列数： " + cols + " 非零元素的个数是：" + nums);
		System.out.println("行下标  列下标 元素值 ");
		for (i = 0; i < nums; i++) {
			System.out.println(data[i].row + "\t" + data[i].column + "\t" + data[i].value);
		}
	}

	/**
	 * 初始化三元顺序表 把叙述矩阵中的所有非零元插入到三元顺序表中
	 * 
	 * @param mat
	 */

	public SparseMatrix(int mat[][]) {
		int i, j, k = 0;
		int count = 0;
		rows = mat.length;// 行数
		cols = mat[0].length;// 列数
		for (i = 0; i < mat.length; i++) {// 统计非零元的个数
			for (j = 0; j < mat[i].length; j++) {
				if (mat[i][j] != 0) {
					count++;
				}
			}
		}
		nums = count;// 非零元的个数
		data = new TripleNode[nums];// 为非零元素申请空间
		for (i = 0; i < mat.length; i++) {
			for (j = 0; j < mat[i].length; j++) {
				if (mat[i][j] != 0) {
					data[k] = new TripleNode(i, j, mat[i][j]);// 建立三元组表
					k++;
				}
			}
		}
	}

	/**
	 * 矩阵转制
	 * 
	 * @return
	 */
	public SparseMatrix transpose() {
		SparseMatrix sparseMatrix = new SparseMatrix(nums);
		sparseMatrix.rows = cols;
		sparseMatrix.cols = rows;
		sparseMatrix.nums = nums;
		int q = 0;
		for (int col = 0; col < cols; col++) {
			for (int p = 0; p < nums; p++) {
				if (data[p].column == col) {
					sparseMatrix.data[q].row = data[p].column;
					sparseMatrix.data[q].column = data[p].row;
					sparseMatrix.data[q].value = data[p].value;
					q++;
				}
			}
		}
		return sparseMatrix;
	}

	/**
	 * 快速转置
	 * num[col]表示原矩阵中第col列的非零元素的个数，cpot【col】初始化表示原矩阵中第col列的第一个非零元素在转置算元祖表中的位置。
	 * copt【0】=0 copt【col】=copt【col-1】+num【col-1】
	 * 
	 * @return
	 */
	public SparseMatrix fastTranspose() {
		SparseMatrix sparseMatrix = new SparseMatrix(nums);
		sparseMatrix.cols = rows;
		sparseMatrix.rows = cols;
		sparseMatrix.nums = nums;
		int i, j = 0, k = 0;
		int[] num, cpot;
		if (nums > 0) {
			num = new int[cols];
			cpot = new int[cols];
			for (i = 0; i < cols; i++) {// 每一列的非零元个数数组的初始化，
				num[i] = 0;
			}
			for (i = 0; i < nums; i++) {// 计算每一列非零元的个数
				j = data[i].column;
				num[j]++;
			}
			cpot[0] = 0;
			for (i = 1; i < cols; i++) {// 计算每列第一个非零元在转置三元组表中的位置
				cpot[i] = cpot[i - 1] + num[i - 1];
			}
			for (i = 0; i < nums; i++) {// 三秒整个三元组表
				j = data[i].column;
				k = cpot[j];// 该元素在转置三元组表中的位置
				sparseMatrix.data[k].row = data[i].column;// 转置
				sparseMatrix.data[k].column = data[i].row;
				sparseMatrix.data[k].value = data[i].value;
				cpot[j]++;// 该列下一个非零元的存放位置
			}
		}
		return sparseMatrix;
	}
}
