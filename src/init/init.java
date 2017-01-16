package init;

import ihm.main;
public class init {
	public static Thread t2;
	public static void main(String[] args) {
		
		
		main m=new main();
		t2=new Thread(m.main2());
		//m.main2();
	}
}
