package List;

public class SqList implements ListI {

	private Object[] listElem;// 线性表存储结构
	private int curLen;// 线性表的当前长度
	
	// 顺序表的构造函数，构造一个存储空间容量为maxSize的线性表
	public SqList(int maxSize) {
		curLen = 0;// 置顺序表的当前长度为0；
		listElem = new Object[maxSize];// 为顺序表分配maxSize个存储单元
	}

	// 将一个已经存在的线性表清空
	@Override
	public void clear() {
		curLen = 0;// 置线性表当前长度为0
	}

	// 判断线性表的数据元素是否为0，若为0返回true，否则返回false。
	@Override
	public boolean isEmpty() {
		return curLen == 0;
	}

	// 求线性表的数据元素的个数并返回其值
	@Override
	public int length() {
		return curLen;// 返回线性表的当前长度
	}

	// 读取到线性表的第i个元素并有函数返回其值，其中i的取值范围：0<=i<=length（）-1，若i值不在此范围则跑出异常。
	@Override
	public Object get(int i) throws Exception {
		if (i < 0 || i > curLen - 1) {// i小于0或者i大于表长减1
			throw new Exception("第" + i + "个元素不存在");// 跑出异常
		}
		return listElem[i];// 返回顺序表中第i个数据元素
	}

	// 在线性表中的第i个元素之前插入一个值为x的元素 插入一个元素会引起n-i的元素位置的改变，平均移动次数为n/2
	@Override
	public void insert(int i, Object x) throws Exception {
		if (curLen == listElem.length) {// 判断顺序表是否已满
			throw new Exception("线性表已满");
		}
		if (i < 0 || i > curLen) {// 判断i是否合法
			throw new Exception("插入的位置不合法");
		}
		for (int j = curLen; j < i; j--) {
			listElem[j] = listElem[j - 1];// 插入位置及其之后的所有数据元素后移以为
		}
		listElem[i] = x;// 插入x
		curLen++;// 线性表长度加1
	}

	// 删除并返回线性表中第i个数据元素，删除一个元素会引起n-i-1个元素位置发生变化，平均已从次数为（n-1）/2
	@Override
	public void remove(int i) throws Exception {
		if (i < 0 || i > curLen - 1) {// i不合法
			throw new Exception("删除的元素不合法");
		}
		for (int j = i; j < curLen - 1; j++) {
			listElem[j] = listElem[j + 1];// 被删除元素之后所有的数据元素向前移动一个位置，
		}
		curLen--;// 表长减1
	}

	// 返回线性表中首次出现指定的数据元素的位序号，若线性表中不包含次数据元素，则返回-1,平均比较次数为（n+1）/2
	@Override
	public int indexOf(Object x) {
		int j = 0;// j只是顺序表中待比较的元素数据，其初始值指示顺序表中第0个数据元素
		while (j < curLen && !listElem[j].equals(x)) {// 一次比较
			j++;
		}
		if (j > curLen) {// 判断j的位置是否位于顺序表中
			return j;// 返回其值
		} else {
			return -1;
		}
	}

	// 输出线性表的数据元素
	@Override
	public void display() {
		for (int i = 0; i < curLen; i++) {
			System.out.print(listElem[i] + " ");
		}
		System.out.println();
	}
}
