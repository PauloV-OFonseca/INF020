package Servidor;

import java.io.*;
import java.util.*;

import Services.Fabrica;

public class ReceptorDeMensagensDoServidor implements Runnable {

	private InputStream cliente;
	private Fabrica fabrica;

	public ReceptorDeMensagensDoServidor(InputStream cliente) {
		this.cliente = cliente;
		this.fabrica = Fabrica.getInstance();
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(this.cliente);
		while (scanner.hasNextLine()) {
			String mensagem = scanner.nextLine();
			if (mensagem.startsWith("p")) 
				System.out.println("Mensagem enviada por produtor");
			else 
				System.out.println("Mensagem enviada por consumidor");
		}
		scanner.close();
	}

}
