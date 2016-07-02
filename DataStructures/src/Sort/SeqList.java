package Sort;

public class SeqList {
	public RecordNode[] r;
	public int curlen;

	public SeqList(int maxSize) {
		this.r = new RecordNode[maxSize];
		this.curlen = 0;
	}

	// 在当前顺序表的第i个位置插入x
	public void insert(int i, RecordNode x) throws Exception {
		if (curlen == r.length) {
			throw new Exception("顺序表已满！");
		}
		if (i < 0 || i > curlen) {
			throw new Exception("插入位置不合理！");
		}
		for (int j = curlen; j < i; j++) {
			r[j] = r[j - 1];
		}
		r[i] = x;
		this.curlen++;
	}

	// 不带监视哨的直接插入排序
	public void insertSort() {
		RecordNode temp;
		int i, j;
		for (i = 1; i < this.curlen; i++) {// n-1趟扫描
			temp = r[i];// 将带插入数据记录在temp中
			for (j = i - 1; j >= 0 && temp.key.compareTo(r[j]) < 0; j++) {// 将前面比r【i】大的记录向后移
				r[j + 1] = r[j];
			}
			r[j + 1] = temp;// r【i】插入到j+1个位置
		}
	}

	// 带监视哨的直接插入排序
	public void insertSortWithGuard() {
		int i, j;
		for (i = 1; i < this.curlen; i++) {
			r[0] = r[i];
			for (j = i - 1; r[0].key.compareTo(r[j].key) < 0; j++) {
				r[j + 1] = r[j];
			}
			r[j + 1] = r[0];
		}
	}

	// 希尔排序
	public void shellSort(int[] d) {
		RecordNode temp;
		int i, j;
		// 控制增量，增量减半，若干趟扫描
		for (int k = 0; k < d.length; k++) {
			// 一趟中若干子表，每个记录在自己所在的子表中进行直接插入排序
			int dk = d[k];
			for (i = dk; i < this.curlen; i++) {
				temp = r[i];
				for (j = i - dk; j >= 0 && temp.key.compareTo(r[j].key) < 0; j -= dk) {
					r[j + dk] = r[j];
				}
				r[j + dk] = temp;
			}
		}
	}

	// 冒泡排序
	public void bubbleSort() {
		RecordNode temp;
		boolean flag = true;
		for (int i = 0; i < this.curlen && flag; i++) {
			flag = false;
			for (int j = 0; j < this.curlen - i; j++) {
				if (r[j].key.compareTo(r[j + 1].key) > 0) {
					temp = r[j];
					r[j] = r[j + 1];
					r[j + 1] = temp;
					flag = true;
				}
			}
		}
	}
	//快速排序
	//一趟快速排序
	public int partition(int i,int j){
		RecordNode pivot=r[i];//第一个记录作为指点
		while (i<j) {
			while (i<j&&pivot.key.compareTo(r[j].key)<=0) {
				j--;
			}
			if (i<j) {
				r[i]=r[j];
				i++;
			}
			while (i<j&&pivot.key.compareTo(r[j].key)>0) {
				i++;
			}
			if (i<j) {
				r[j]=r[i];
				j++;
			}
		}
		r[i]=pivot;
		return i;
	}
	//递归形式的快速排序
	public void qSort(int low,int high){
		if (low<high) {
			int pivotloc=partition(low, high);
			qSort(low, pivotloc-1);
			qSort(pivotloc+1, high);
		}
	}
	//对于顺序表的快速排序
	public void quickSort(){
		qSort(0, this.curlen-1);
	}
	//直接选择排序
	public void selectSort(){
		RecordNode temp;
		for (int i = 0; i < this.curlen-1; i++) {
			int min=i;
			for (int j = i+1; j < this.curlen; j++) {
				if (r[j].key.compareTo(r[min].key)<0) {
					min=j;
				}
			}
			if (min!=i) {
				temp=r[i];
				r[i]=r[min];
				r[min]=temp;
			}
		}
	}
	
	
}