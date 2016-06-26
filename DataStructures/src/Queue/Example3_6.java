package Queue;

public class Example3_6 {

	public static void main(String[] args)  {
		try {
			PriorityQueue priorityQueue = new PriorityQueue();
			priorityQueue.offer(new PriorityData(1, 20));
			priorityQueue.offer(new PriorityData(2, 30));
			priorityQueue.offer(new PriorityData(3, 40));
			priorityQueue.offer(new PriorityData(4, 10));
			priorityQueue.offer(new PriorityData(5, 20));
			System.out.println("进程服务的顺序：");
			System.out.println("进程ID" + " " + "进程优先级");
			while (!priorityQueue.isEmpty()) {
				PriorityData p = (PriorityData) priorityQueue.poll();
				System.out.println(" " + p.elem + "\t" + p.priority);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
