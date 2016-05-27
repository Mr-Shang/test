package Queue;

public interface QueueI {
	public void clear() throws Exception;

	public boolean isEmpty() throws Exception;

	public int length() throws Exception;

	public Object peek() throws Exception;

	public void offer(Object object) throws Exception;

	public Object poll() throws Exception;
}
