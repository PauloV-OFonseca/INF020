package Cliente;
import java.io.*;
import java.net.*;

public class Cliente {
	private String host = "127.0.0.1";
    private int porta = 12345;
    private Socket cliente;
    private DataInputStream entrada;
    private DataOutputStream saida;
    

    public static void main(String args[]) {
		new Cliente();
    }

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
        entrada = new DataInputStream(cliente.getInputStream());
        saida = new DataOutputStream(cliente.getOutputStream());
        System.out.println("O cliente foi conectado ao servidor.");
    }

    public void enviaMsg() throws IOException {
        saida.writeInt(1);
        saida.writeUTF("Um");
    }

    public void recebeMsg() throws IOException {
        System.out.println("Aguardando comando");
        String comando = entrada.readUTF();
        System.out.println("Comando realizado: " + comando);
    }

    public void desconectaSocket() throws IOException {
        entrada.close();
        saida.close();
        cliente.close();
    }
}