package Graph;

import java.util.Scanner;

/**
 * 一个具有n个顶点的图G，可以将图G的临接矩阵存储在一个二维数组中。
 * 
 * @author 东
 *
 */
public class MGraph implements IGraph {
	public final static int INFINITY = Integer.MAX_VALUE;
	private GraphKind kind;// 图的种类标志
	private int vexNum, arcNum;// 图的当前顶点数和边数
	private Object[] vexs;// 顶点
	private int[][] arcs;// 临阶矩阵
	private Scanner in;

	public MGraph() {
		this(null, 0, 0, null, null);
	}

	public MGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs, int[][] arcs) {
		super();
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		this.arcs = arcs;
	}

	// 创建图
	@Override
	public void createGraph() throws Exception {
		in = new Scanner(System.in);
		System.out.println("请输入图的类型：");
		GraphKind kind = GraphKind.valueOf(in.next());
		switch (kind) {
		case UDG:
			createUDG();
			return;
		case DG:
			createDG();
			return;
		case UDN:
			createUDN();
			return;
		case DN:
			createDN();
			return;
		}
	}

	// 创建无向图
	public void createUDG() {

	};

	// 创建有向图
	public void createDG() {

	};

	// 创建无向网
	public void createUDN() throws Exception {
		in = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数，图的边数：");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = new Object[vexNum];
		System.out.println("请分别输入图的各个顶点：");
		for (int v = 0; v < vexNum; v++) {
			vexs[v] = in.next();
		}
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++) {
			for (int u = 0; u < vexNum; u++) {
				arcs[v][u] = INFINITY;
			}
		}
		System.out.println("请输入各个边的两个顶点及其权值：");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(in.next());
			int u = locateVex(in.next());
			arcs[v][u] = arcs[u][v] = in.nextInt();
		}
	}

	// 创建有向网
	public void createDN() throws Exception {
		in = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数和边数：");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = new Object[vexNum];
		System.out.println("请分别输入图的各个顶点：");
		for (int v = 0; v < vexNum; v++) {
			vexs[v] = in.next();
		}
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++) {
			for (int u = 0; u < vexNum; u++) {
				arcs[v][u] = INFINITY;
			}
		}
		System.out.println("请输入各个边的两个顶点及其权值：");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(in.next());
			int u = locateVex(in.next());
			arcs[v][u] = in.nextInt();
		}
	}

	// 返回顶点数
	@Override
	public int getVexNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	// 返回边数
	@Override
	public int getArcNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	// 返回v表示的结点值，0<=v<=vexnum
	@Override
	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum) {
			throw new Exception("第" + v + "个顶点不存在！");
		}
		return vexs[v];
	}

	// 给定顶点的值vex，返回其在图中的位置，如果图中不包含此顶点，则返回-1.
	@Override
	public int locateVex(Object vex) throws Exception {
		for (int v = 0; v < vexNum; v++) {
			if (vexs[v].equals(vex)) {
				return v;
			}
		}
		return -1;
	}

	// 返回v的第一个邻接点，若v没有邻接点，则返回-1，0<=v<=vexnum
	@Override
	public int firstAdjVex(int v) throws Exception {
		if (v<0&&v>=vexNum) {
			throw new Exception("第"+v+"个顶点不存在！");
		}
		for (int j = 0; j < vexNum; j++) {
			if (arcs[v][j]!=0&&arcs[v][j]<INFINITY) {
				return j;
			}
		}
		return -1;
		
	}

	// 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0<v,w<vexnum
	@Override
	public int nextAdjVex(int v, int w) throws Exception {
		if (v<0&&v>=vexNum) {
			throw new Exception("第"+v+"个顶点不存在！");
		}
		for (int j = w+1; j < vexNum; j++) {
			if (arcs[v][j]!=0&&arcs[v][j]<INFINITY) {
				return j;
			}
		}
		return -1;
	}

	public GraphKind getKind() {
		return kind;
	}

	public void setKind(GraphKind kind) {
		this.kind = kind;
	}

	public Object[] getVexs() {
		return vexs;
	}

	public void setVexs(Object[] vexs) {
		this.vexs = vexs;
	}

	public int[][] getArcs() {
		return arcs;
	}

	public void setArcs(int[][] arcs) {
		this.arcs = arcs;
	}

}
