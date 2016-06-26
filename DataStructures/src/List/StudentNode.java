package List;

import java.util.Scanner;

/**
 * 学生成绩的管理，具有查询，修改，删除，增加和求全班各门课平均分的功能
 * 
 * @author 东
 *
 */
public class StudentNode {
	public int number;// 学号
	public String name;// 姓名
	public String sex;// 性别
	public double english;// 英语成绩
	public double math;// 数学成绩

	public StudentNode() {// 无参构造函数
		this(0, null, null, 0.0, 0.0);
	}

	public StudentNode(int number, String name, String sex, double english, double math) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.english = english;
		this.math = math;
	}

	public StudentNode(Scanner in) {
		this(in.nextInt(), in.next(), in.next(), in.nextDouble(), in.nextDouble());
	}

}
