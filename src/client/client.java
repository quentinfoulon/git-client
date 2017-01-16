package client;

import java.io.*;
import java.net.*;

import org.eclipse.swt.events.SelectionAdapter;

import ihm.Popup;
import ihm.main;

public class client {

	public static Socket socket = null;
	public static Thread t1;
	
	public client() {

		
	/*try {
		
		System.out.println("Demande de connexion");
		socket = new Socket("127.0.0.1",2009);
		System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
		main m2 =new main();
		
		t1 = new Thread(new connexion(socket,mdp,login,m));
		t1.start();
		
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
	}*/
	
	

	}
	
	public Socket recupSocket(){
		try {
			
			System.out.println("Demande de connexion");
			socket = new Socket("127.0.0.1",2009);
			System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
			main m2 =new main();
			
			//t1 = new Thread(new connexion(socket,mdp,login,m));
			//t1.start();
			
			
			
			
		} catch (UnknownHostException e) {
		  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
		} catch (IOException e) {
			Popup pop =new Popup();
			pop.main2("Aucun serveur a l'ecoute");
		  //System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
		}
		return socket;
		
		
	}



}
