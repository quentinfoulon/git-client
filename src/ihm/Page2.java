package ihm;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import java.net.Socket;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import chat.Chat_ClientServeur;
public class Page2 {
	public static Thread chat;
	
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 * @return 
	 * @wbp.parser.entryPoint
	 */
	public static Runnable main2(Socket socket) {
		try {
			
			chat = new Thread(new Chat_ClientServeur(socket));
			chat.start();
			Page2 window = new Page2();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1500, 800);
		shell.setText("SWT Application");
		
		Label lblConnect = new Label(shell, SWT.NONE);
		lblConnect.setBounds(10, 10, 70, 20);
		lblConnect.setText("Connect\u00E9");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("Mon compte");
		
		Menu menu_2 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_2);
		
		MenuItem mntmNewItem = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem.setText("Option");
		
		MenuItem mntmNewItem_1 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_1.setText("Mot de passe");
		
		Menu menu_1 = new Menu(shell);
		shell.setMenu(menu_1);

	}
}
