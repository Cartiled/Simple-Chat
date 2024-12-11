package platform;

import java.io.IOException;
import java.net.Socket;

import threads.EnviarThreads;
import threads.RecibirThreads;

public class Clienrte {
	
	private static Socket client;
	public static void main(String[] args) {
		
		
		try {
			client = new Socket("localhost", 7000);
			System.out.println("conexion realizada");
			
			EnviarThreads enviar = new  EnviarThreads(client);
			RecibirThreads recibir = new RecibirThreads(client);
			enviar.start();
			recibir.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
