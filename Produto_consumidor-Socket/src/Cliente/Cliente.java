package Cliente;
import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {
	//Caso o cliente conecte-se ao servidor, ele pode se tornar um consumidor ou um produtor
	private String host = "127.0.0.1";
    private int porta = 12345;
    private Socket cliente;
    private Scanner entrada;
    private PrintStream saida;
    

    public static void main(String args[]) {
		new Cliente();
    }

    //Inicialização dos métodos de conexão do cliente
    public Cliente() {
        try {
            conectaSocket();
            recebeMsg();
        } catch (UnknownHostException ex) {
            System.out.println("Erro!! O servidor não foi encontrado :(!");
        } catch (IOException ex) {
            System.out.println("Erro de entrada ou saída!");
        }
    }

    public void conectaSocket() throws IOException{
        try {
            cliente = new Socket(host, porta);
        } catch (UnknownHostException ex) {
            conectaSocket();
        }
        entrada = new Scanner(System.in);
        saida = new PrintStream(cliente.getOutputStream());
        System.out.println("O cliente foi conectado ao servidor.");
    }

    //Continua enviando mensagens permanentemente ao servidor
    public void enviaMsg() throws IOException {
		String tipo = "";
		String mensagem;

		while (!tipo.equalsIgnoreCase("p") && !tipo.equalsIgnoreCase("c")) {
			System.out.println("Digite p para ser **produtor** e c para ser **Consumidor**?");
			tipo = entrada.nextLine();
		}
		
		
		if(tipo.equalsIgnoreCase("p"))
			System.out.println("Digite algo para produzir");
		else 
			System.out.println("Aperte enter para consumir");
		
		while(true) {
			while (entrada.hasNextLine()) {
				mensagem = entrada.nextLine();
				saida.println(tipo + " - "+ mensagem);
			}
		}
    }

    public void recebeMsg() throws IOException {
        System.out.println("Aguardando comando");
        enviaMsg();
    }

    public void desconectaSocket() throws IOException {
        entrada.close();
        saida.close();
        cliente.close();
    }
}