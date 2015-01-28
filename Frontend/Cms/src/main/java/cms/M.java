package cms;

public class M {
	
	public static void main(String[] args) {
		String string = "";
		for (int i = 0; i < 10000; i++) {
			string += "a";
		}
		Array array = new Array(string);
		Thread thread1 = new Thread(new R(array));
		Thread thread2 = new Thread(new R2(array));
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(string.length());
	}
}
class Array{
	String string;
	public Array(String string) {
		this.string = string;
	}
}
