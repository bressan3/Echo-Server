import java.net.*;
import java.io.*;

public class EchoServerThread extends Thread {
	private Socket clientSocket;
	
	private EchoServerThread(Socket clientSocket){
		this.clientSocket = clientSocket;
		start();
	}
	
	public static void main (String args[]) throws Exception{
		int port = 4444;
		ServerSocket serverSocket = new ServerSocket(port);
		System.err.println("Started server on port " + port);
		
		//aguarda conexao
		while(true)
			new EchoServerThread (serverSocket.accept());
	}
	
	public void run(){
		System.err.println("Accepted connection from client.");
		try{
		// Cria as “streams” para o socket (buffer) 
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
		// espera a leitura do dado (até terminar conexão) 
		String s;
		while ((s = in.readLine()) != null) {
		out.println(s);
		}
		            
		// Fecha a conexão (e o socket) 
		System.err.println("Closing connection with client"); 
		out.close(); 
		in.close(); 
		clientSocket.close();
		}
		catch (IOException e) {System.exit(1);}
	}
}