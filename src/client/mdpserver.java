package client;
import ihm.Popup;
import ihm.main;
import ihm.mdp;

import java.net.*;
import java.util.Scanner;

import chat.Chat_ClientServeur;

import java.io.*;

public class mdpserver implements Runnable {

	private Socket socket = null;
	public static Thread t2;
	public static String login = null, pass = null, message1 = null, message2 = null, message3 = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private Scanner sc = null;
	private main m=null;
	private boolean iddone = false;
	private int id;
	
	public boolean mdpnew() {
		return iddone;
	}

	public mdpserver(Socket s , String mdp , String login ){
		
		socket = s;
		pass=mdp.trim();
		this.login=login.trim();
		//Test1 test1=new Test1();
		//test1.test2(s);
	}
	public int test(){
		
		return 0;
	}
	public void run() {
		
		try {
			
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
	
		
		out.println("mdp");
		out.flush();
		//System.out.println(in.readLine());
		System.out.println(login);
		out.println(login);
		out.flush();
		
		//System.out.println(in.readLine());
		out.println(pass);
		out.flush();
		
		if(in.readLine().equals("mdprecup")){
			
		System.out.println("je recup bien mon mdp "); 
		iddone = true;
		  }
		
		else {
			System.err.println("Vos informations sont incorrectes "); 
			Popup pop =new Popup();
			pop.main2("Mail ou Login incorrect");
		  }
		
		
		} catch (IOException e) {
			
			System.err.println("Le serveur ne répond plus ");
			Popup pop =new Popup();
			pop.main2("Le serveur ne répond plus");
			
		}
	}
	
	

}
