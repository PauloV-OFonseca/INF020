package rmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.net.*;

import semaforo.ProdutorConsumidorController;

public class RMIServidor extends UnicastRemoteObject implements ReceiveMessageInterface {

	private static final long serialVersionUID = 0;
	
	int porta;
	String endereço;
	Registry registry;
	ProdutorConsumidorController pc;
	
	public RMIServidor() throws RemoteException {
		try {
			this.pc = ProdutorConsumidorController.getInstance();
			endereço = (InetAddress.getLocalHost()).toString();
		} catch (Exception e) {
			throw new RemoteException("can't get inet address.");
		}
		porta = 3232;
		System.out.println("Endereço = " + endereço + ", port = " + porta);
		try {
			registry = LocateRegistry.createRegistry(porta);
			registry.rebind("rmiServer", this);
		} catch (RemoteException e) {
			throw e;
		}
	}
	
	public void receiveMessage(String message) throws RemoteException {
		if (message.contains("2".toLowerCase()))
			this.pc.runConsumer();
		else
			this.pc.runProducer(message);
	}

	

	static public void main(String args[]) {
		try {
			RMIServidor s =new RMIServidor();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}