package ihm;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.IOException;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import client.client;
import client.connexion;
import client.mdpserver;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class mdp {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Socket socket;
	private mdpserver mdps;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main2() {
		try {
			mdp window = new mdp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		shell.setSize(212, 191);
		shell.setText("Recuperation MDP");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 26, 70, 20);
		lblNewLabel.setText("login");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(93, 26, 78, 26);
		
		text_1 = new Text(shell,SWT.PASSWORD | SWT.BORDER);
		text_1.setBounds(93, 72, 78, 26);
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(10, 75, 70, 20);
		lblEmail.setText("email");
		
		Button btnNouveauMdp = new Button(shell, SWT.NONE);
		btnNouveauMdp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Demande de MDP");
				System.out.println(text.getText());
				
				System.out.println(text_1.getText());
				client c=new client();
				socket=c.recupSocket();
				mdps=new mdpserver(socket,text_1.getText(),text.getText());
				mdps.run();
				if (mdps.mdpnew()){
					//m.getShell().setText("test3");
					//t2 = new Thread(new Chat_ClientServeur(socket));
					//t2.start();
					shell.close();
					
					//159429
				} else{
						try {
						socket.close();
						} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
					}
				
			}
		});
		btnNouveauMdp.setBounds(35, 104, 107, 30);
		btnNouveauMdp.setText("Nouveau MDP");

	}
}
