package ihm;

import client.client;
import client.connexion;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import chat.Chat_ClientServeur;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class main {
	private main window;
	protected Shell shell;
	private Socket socket;
	private Display display;
	private Text user;
	private Text mdp;
	private connexion conn;

	/**
	 * Launch the application.
	 * @param args
	 * @return 
	 * @wbp.parser.entryPoint
	 */
	/*public static void main(String[] args) {
		try {
			main window = new main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	public Runnable main2(){
		try {
			 window = new main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Open the window.
	 */
	public void open() {
		try {
			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
			display = Display.getDefault();
			createContents();
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
				}
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(){
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(244, 211);
		shell.setText("Chat Interne - Connexion");
		
		user = new Text(shell, SWT.BORDER);
		user.setBounds(129, 26, 78, 26);
		
		mdp = new Text(shell,SWT.PASSWORD | SWT.BORDER);
		mdp.setBounds(129, 61, 78, 26);
		
		Button btnConnexion = new Button(shell, SWT.NONE);
		btnConnexion.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				System.out.println("Demande de connexion");
				System.out.println(mdp.getText());
				
				System.out.println(user.getText());
				client c=new client();
				socket=c.recupSocket();
				conn=new connexion(socket,mdp.getText(),user.getText());
				conn.run();
				if (conn.isConnect()){
					//m.getShell().setText("test3");
					//t2 = new Thread(new Chat_ClientServeur(socket));
					//t2.start();
					shell.close();
					Page2 p =new Page2();
					p.main2(socket);
					//159429
				} else{
						
					}
				
				
				
			}
		});
		btnConnexion.setBounds(80, 90, 90, 30);
		btnConnexion.setText("connexion");
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(27, 29, 70, 20);
		lblUsername.setText("username:");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(27, 64, 70, 20);
		lblPassword.setText("password:");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
				   // Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
				} catch (Exception e2) {}
				
				mdp m =new mdp();
				m.main2();
				
			}
		});
		btnNewButton.setBounds(27, 124, 90, 30);
		btnNewButton.setText("Mdp oubli\u00E9");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Inscription i =new Inscription();
				i.main2();
			}
		});
		btnNewButton_1.setBounds(129, 124, 90, 30);
		btnNewButton_1.setText("Inscription");

	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Text getUser() {
		return user;
	}

	public Text getMdp() {
		return mdp;
	}
	public Shell getShell() {
		return shell;
	}
}
