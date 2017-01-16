package client;
import ihm.Popup;
import ihm.main; 

import java.net.*;
import java.util.Scanner;

import chat.Chat_ClientServeur;

import java.io.*;

public class connexion implements Runnable {

	private Socket socket = null;
	public static Thread t2;
	public static String login = null, pass = null, message1 = null, message2 = null, message3 = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private Scanner sc = null;
	private main m=null;
	private boolean connect = false;
	private int id;
	
	public boolean isConnect() {
		return connect;
	}

	public connexion(Socket s , String mdp , String login){
		this.m=m;
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
	
		
		out.println("connexion");
		out.flush();
		//System.out.println(in.readLine());
		System.out.println(login);
		out.println(login);
		//System.out.println(in.readLine());
		out.println(pass);
		out.flush();
		Thread.sleep(1000);
		String ValeurLue=in.readLine();
		System.out.println(ValeurLue); 
		if(ValeurLue.equals("connecter")){
			
		System.out.println("Je suis connecté "); 
		connect = true;
		  }
		
		else {
			System.err.println("Vos informations sont incorrectes "); 
			Popup pop =new Popup();
			pop.main2("Vos informations sont incorrectes");
		  }
		
		
		} catch (IOException e) {
			
			System.err.println("Le serveur ne répond plus ");
			Popup pop =new Popup();
			pop.main2("Le serveur ne répond plus");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

