package threads;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EnviarThreads extends Thread {
	
	private Scanner sc = new Scanner(System.in);
	private PrintWriter out = null;

	public EnviarThreads(Socket socket) {
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	}
	
	public void run() {
		String input = new String();
		while(true) {
			input = sc.nextLine();
			out.println(input);
			out.flush();
			
		}
	}

	
}
