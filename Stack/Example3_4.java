package Stack;

/**
 * 汉诺塔 每次只移动一个圆盘 圆盘可以插在x、y、z中任何一个塔座上 任何时候都不能将一个较大的圆盘放在较小的圆盘上
 * 
 * @author 东
 *
 */
public class Example3_4 {

	private int c = 0;// 全局变量，对移动次数几率
	// 将塔座上x上按直径由小到大且自下而上的编号1至n的n个圆盘按规则移动到z上，y用作辅助塔座

	public void hanoi(int n, char x, char y, char z) {
		if (n == 1) {
			move(x, 1, z);// 将编号为1的圆盘从从x移动到z
		} else {
			hanoi(n - 1, x, z, y);// 将x上编号为1至n-1的圆盘移动到y，z做辅助
			move(x, n, z);// 将编号为n的圆盘从x移动到z
			hanoi(n - 1, y, x, z);// 将y上编号为1值n-1的圆盘移动到z上，x做辅助
		}
	}

	// 移动操作，将编号为n的圆盘从x移动到z
	private void move(char x, int i, char z) {
		System.out.println("第" + ++c + "次移动：" + i + "号圆盘," + x + "--->" + z);
	}

	public static void main(String[] args) {
		Example3_4 e = new Example3_4();
		e.hanoi(7, 'x', 'y', 'z');
	}

}
