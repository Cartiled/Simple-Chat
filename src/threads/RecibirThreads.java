package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecibirThreads extends Thread {
	private BufferedReader reader;
	private Socket socket;
	private boolean done = true;

	public RecibirThreads(Socket socket) {
		try {
			this.socket = socket;
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void run() {
		String str = "";
		done = false;
		while (!done) {
			try {
				str = reader.readLine();
				if (str != null) {
					System.out.println(str);
					if (str.equals("salir")) {
						System.out.println("fin de la conversasion");
						done = true;
						socket.close();
					}
				} else {
					done = true;
					socket.close();
					System.out.println("fin de la conversasion");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
