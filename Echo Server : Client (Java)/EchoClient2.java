import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class EchoClient2 {
	public static void main(String args[]) throws Exception{
		String screenName = "Usuario02";
        String host = new String ("127.0.0.1");
		int port = 4444;
		
		//conecta ao servidor e abre os streams
		Socket socket = new Socket(host, port);
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.err.println("connected to " + host + " on port " + port);
		
		//lê da entrada padrao stdin, envia, escreve resposta
		String s;
		System.out.println("Message: ");
        while ((s = stdin.readLine()) != null) {
        	out.println("[" + screenName + "]: " + s);
        	System.out.println("echo: " + in.readLine());
        	System.out.println("Message: ");
        }
		
		//encerra os sockets
		System.err.println("Closing connection to: " + host);
		out.close();
		in.close();
		socket.close();
	}
}
