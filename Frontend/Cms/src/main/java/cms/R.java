package cms;

import cms.Array;

public class R implements Runnable {

	Array string;
	public R(Array string) {
		this.string = string;
	}
	public void run() {
		while (true) {
			synchronized (string) {
				System.out.println(string.string.length() + "R");
				string.string += "a";
				//string.notify();
				System.out.println(string.string.length() + "R");
			}
		}
	}
}
class R2 implements Runnable {

	Array string;
	public R2(Array string) {
		this.string = string;
	}
	public void run() {
		while (true) {
			synchronized (string) {
				System.out.println(string.string.length() + "R2");
				string.string = string.string.substring(0, string.string.length() - 2);
				//string.notify();
				System.out.println(string.string.length() + "R2");
			}
		}
	}

}

