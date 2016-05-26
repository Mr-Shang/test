package Stack;

public interface StackI {
	public void clear() throws Exception;
	public boolean isEmpty() throws Exception;
	public int length() throws Exception;
	public Object peek() throws Exception;
	public void push(Object object) throws Exception;
	public Object pop() throws Exception;
}
