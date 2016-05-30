package Queue;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Stack.SqStack;

/**
 * 停车场管理
 * 
 * @author 东
 *
 */
public class Example3_7 {

	private SqStack S = new SqStack(100);// 顺序栈存放停车场内的信息
	private LinkQueue Q = new LinkQueue();// 链队列存放便道上的车辆信息
	private double fee = 2;// 每分钟停车的费用
	public final static int DEPARTURE = 0;// 表示车辆离开
	public final static int ARRIVE = 1;// 表示车辆到达
	// 内部类用于存放车辆信息
	private static Scanner in;

	public class CarInfo {
		public int state;// 车辆状态 离开/到达
		public GregorianCalendar arrTime;// 车辆到达时间
		public GregorianCalendar depTime;// 车辆离开时间
		public String license;// 车牌号
	}

	// 停车场管理，参数license表示车牌号码，action表示此车辆的动作，离开或者到达
	public void parkingManag(String license, String action) throws Exception {
		if ("arrive".equals(action)) {// 车辆到达
			CarInfo carInfo = new CarInfo();// 构造车辆信息
			carInfo.license = license;// 修改车辆状态
			if (S.length() < 10) {// 停车场未满
				carInfo.arrTime = (GregorianCalendar) GregorianCalendar.getInstance();// 当前时间初始化为到达时间
				carInfo.state = ARRIVE;// 车辆到达
				S.push(carInfo);// 入栈
				System.out.println(carInfo.license + "停放在停车场第" + S.length() + "个位置！");
			} else {// 停车场已满
				Q.offer(carInfo);// 入队列
				System.out.println(carInfo.license + "停在便道的第" + Q.length() + "个位置！");
			}
		} else if ("depart".equals(action)) {// 车辆离开
			CarInfo carInfo = null;
			int location = 0;// 车辆停放的位置
			SqStack S2 = new SqStack(S.length());// 构造一个新栈，用于存放应车辆离开为导致的其他车辆暂时退出车场
			for (int i = S.length(); i > 0; i--) {
				carInfo = (CarInfo) S.pop();//
				if (carInfo.license.equals(license)) {// 将要离开的车辆
					carInfo.depTime = (GregorianCalendar) GregorianCalendar.getInstance();
					carInfo.state = DEPARTURE;// 当前时间初始化为离开时间
					location = i;// 获取车辆的位置信息
					break;
				} else {// 其他车辆暂时退场
					S2.push(carInfo);
				}
			}
			while (!S2.isEmpty()) {// 其他车辆重新进入停车场
				S.push(S2.pop());
			}
			if (location != 0) {// 停车场内存在指定车牌号的车辆
				double time = (carInfo.depTime.getTimeInMillis() - carInfo.arrTime.getTimeInMillis()) / (1000 * 60);// 计算离开时间，
				DecimalFormat decimalFormat = new DecimalFormat("0.0");// 将double格式化，
				System.out.println(carInfo.license + "停放：" + decimalFormat.format(time) + "分钟，费用为："
						+ decimalFormat.format(time * fee));
			}
			if (!Q.isEmpty()) {// 便道上的第一个车辆入场
				carInfo = (CarInfo) Q.poll();
				carInfo.arrTime = (GregorianCalendar) GregorianCalendar.getInstance();
				carInfo.state = ARRIVE;// 将当前时间初始化为入场时间
				S.push(carInfo);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Example3_7 parkingManag = new Example3_7();
		for (int i = 1; i <= 12; i++) {
			parkingManag.parkingManag(String.valueOf(i), "arrive");
		}
		in = new Scanner(System.in);
		System.out.println("请输入车牌号：");
		String license = in.next();
		System.out.println("arrive or depart？");
		String action = in.next();
		parkingManag.parkingManag(license, action);
	}

}
