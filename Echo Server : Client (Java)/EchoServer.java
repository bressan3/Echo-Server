import java.io.*;
import java.net.*;

public class EchoServer {
	
	public static void main(String[] args) throws Exception {
		int port = 4444;
		ServerSocket serverSocket = new ServerSocket(port);
		System.err.println("Started server on port " + port);
		
		while (true) {
			// espera blocante até alguma equisição de conexão
			Socket clientSocket = serverSocket.accept();
			System.err.println("Accepted connection from client");
	
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
	}
}