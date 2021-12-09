package Servidor;
import java.io.*;
import java.util.*;

import Services.Fabrica;

import java.net.*;

public class Servidor {
	private int porta = 12345;
	private List<PrintStream> clientes = new ArrayList<>();;
	
	public static void main(String[] args) throws IOException{
		new Servidor();
	}
	
	//Inicialização dos métodos de conexão do servidor
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
			
			//Faz a chamada do runnable de recepção de mensagens enviadas ao servidor
			//pelo consumidor e pelo produtor
			ReceptorDeMensagensDoServidor receptor = new ReceptorDeMensagensDoServidor(cliente.getInputStream());
			new Thread(receptor).start();
		}
	}
	
}
