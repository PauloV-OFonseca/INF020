package rmi;

import java.rmi.registry.*;
import java.util.Scanner;

public class RMICliente {
	static public void main(String args[]) {
		ReceiveMessageInterface rmiServer;
		Registry registry;
		String serverAddress = "127.0.0.1";
		String serverPort = "3232";
		String input;
		Scanner inputClient = new Scanner(System.in);
		String process = "";

		try {
			while (!process.equalsIgnoreCase("1") 
					&& !process.equalsIgnoreCase("2")) {
				System.out.println("Escolha uma opção parar gerar o processo desejado.");
				System.out.println("Opções:");
				System.out.println("1 para Produtor");
				System.out.println("2 para Consumidor");
				process = inputClient.nextLine();
			}

			String output = process.substring(0, 1).toUpperCase() + process.substring(1);
			System.out.println(output + " selecionado.");
			
			if (process.equals("1"))
				System.out.println("\nDigite algo para produzir");
			else
				System.out.println("\nAperte ENTER para consumir");
			System.out.println("Digite 0 terminara o processo");
			registry = LocateRegistry.getRegistry(serverAddress, 
					(Integer.valueOf(serverPort)).intValue());
			rmiServer = (ReceiveMessageInterface) (registry.lookup("rmiServer"));
			
			while (inputClient.hasNextLine()) {
				input = inputClient.nextLine();
				if (input.equals("0")) {
					System.out.println(output + " terminado.");
					break;
				}
				rmiServer.receiveMessage(process + ": " +input);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		inputClient.close();
	}
}
