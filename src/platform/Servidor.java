package platform;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import threads.EnviarThreads;
import threads.RecibirThreads;

public class Servidor {

	private static final int PORT = 7000;
	private static ServerSocket server = null;
	public static void main(String[] args) {

		try {
			 server = new ServerSocket(PORT);
			System.out.println("esperando una conexion.....");
			Socket socket = server.accept();
			System.out.println(socket.getInetAddress() + " se ha conectado");
			
			System.out.println("nombre de cliente" + socket);
			EnviarThreads enviar = new  EnviarThreads(socket);
			RecibirThreads recibir = new RecibirThreads(socket);
			
			enviar.start();
			recibir.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
