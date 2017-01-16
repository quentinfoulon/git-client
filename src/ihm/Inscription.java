package ihm;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.IOException;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import client.Inscriptionserver;
import client.client;
import client.mdpserver;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Inscription {

	protected Shell shell;
	private Text mdp2;
	private Text mdp;
	private Text mail;
	private Text login;
	private Socket socket;
	private Inscriptionserver Inss;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main2() {
		try {
			Inscription window = new Inscription();
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
		shell.setSize(261, 264);
		shell.setText("Inscription");
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setBounds(10, 10, 70, 20);
		lblLogin.setText("Login");
		
		Label lblMail = new Label(shell, SWT.NONE);
		lblMail.setBounds(10, 50, 70, 20);
		lblMail.setText("Mail");
		
		Label lblMdp = new Label(shell,  SWT.NONE);
		lblMdp.setBounds(10, 87, 70, 20);
		lblMdp.setText("MDP");
		
		Label lblConfirmationMdp = new Label(shell,  SWT.NONE);
		lblConfirmationMdp.setBounds(10, 123, 133, 20);
		lblConfirmationMdp.setText("Confirmation MDP");
		
		mdp2 = new Text(shell,SWT.PASSWORD | SWT.BORDER);
		mdp2.setBounds(149, 117, 78, 26);
		
		mdp = new Text(shell, SWT.PASSWORD | SWT.BORDER);
		mdp.setBounds(149, 81, 78, 26);
		
		mail = new Text(shell, SWT.BORDER);
		mail.setBounds(149, 44, 78, 26);
		
		login = new Text(shell, SWT.BORDER);
		login.setBounds(149, 4, 78, 26);
		
		Button btnSincrire = new Button(shell, SWT.NONE);
		btnSincrire.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(mdp.getText().trim().equals(mdp2.getText().trim())){
				//
				System.out.println("Demande d'inscription");
				client c=new client();
				socket=c.recupSocket();
				Inss=new Inscriptionserver(socket,mdp.getText().trim(),login.getText().trim(),mail.getText().trim());
				Inss.run();
				if (Inss.mdpnew()){
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
				
				//
				}else{
					Popup pop =new Popup();
					pop.main2("les mdps ne sont pas les memes");
				}
			}
		});
		btnSincrire.setBounds(137, 174, 90, 30);
		btnSincrire.setText("S'incrire");

	}

}
