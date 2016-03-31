
public abstract class Command implements Runnable {
	
	protected String name;
	protected abstract void f();
	
	@Override
	public void run() {
		f();
	}
	
}
