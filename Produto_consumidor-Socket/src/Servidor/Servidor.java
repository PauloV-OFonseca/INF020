package Servidor;
import java.io.*;
import java.util.*;
import java.net.*;

public class Servidor {
	private int porta = 12345;
	private List<PrintStream> clientes = new ArrayList<>();;
	
	public static void main(String[] args) throws IOException{
		new Servidor();
	}
	
	public Servidor() throws IOException{
		ServerSocket servidor = new ServerSocket(this.porta);
		System.out.println("Servidor rodando na porta: " + this.porta);
		
		while(true) {
			System.out.println("Aguardando conexoes");
			Socket cliente = servidor.accept();
			System.out.println("Um novo cliente foi aceito!!");
			System.out.println("Conectados atualmente: " + (clientes.size()+1));
			
			PrintStream ps = new PrintStream(cliente.getOutputStream());
			this.clientes.add(ps);
		}
	}
	
}