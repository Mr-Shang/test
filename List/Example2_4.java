package List;

/**
 * 删除单链表中相同的结点
 * 
 * @author 东
 *
 */
public class Example2_4 {

	public static void main(String[] args) throws Exception {
		System.out.println("请输入单链表的10个结点的值： ");
		LinkList linkList = new LinkList(10, true);
		System.out.println("删除重复结点前单链表中的各个结点值为：");
		linkList.display();
		removeRepeatElem(linkList);
		System.out.println("删除重复结点后单链表中各个结点的值： ");
		linkList.display();
	}

	private static void removeRepeatElem(LinkList linkList) throws Exception {
		Node p = linkList.head.next, q;// 初始化，p指向首节点
		while (p != null) {// 从首节点向后查找，知道p为空
			int order = linkList.indexOf(p.data);// 记录p在单链表中的位置
			q = p.next;
			while (q != null) {// 与p的所有后继结点进行比较
				if (p.data.equals(q.data)) {// 删除重复的结点
					linkList.remove(order + 1);
				} else {
					++order;
				}
				q = q.next;
			}
			p = p.next;
		}
	}

}
