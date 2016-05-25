package List;

/**
 * 实现一元多项式的加法
 *  定义多项式的结点
 * @author 东
 *
 */
public class PolynNode {
	public double coef;// 系数
	public int expn;// 指数

	public PolynNode(double coef, int expn) {
		super();
		this.coef = coef;
		this.expn = expn;
	}
}
