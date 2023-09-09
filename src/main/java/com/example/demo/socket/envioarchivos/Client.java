package com.example.demo.socket.envioarchivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private final Integer PORT = 15;
	private final String IP = "localhost";

	public Client() {
		
		try {
			Socket clientSocket = new Socket(IP,PORT);
			System.out.println("---------1 Iniciando comunicación ----------");		
			
			File fileDestino = new File("C:/Users/Franklin/Documents/cliente/Java-Tarco2.png");
			FileOutputStream fos = new FileOutputStream(fileDestino);
			DataInputStream entrada = new DataInputStream(clientSocket.getInputStream());
			
			int byteLeidos;
			while( (byteLeidos = entrada.read()) != -1) {
				fos.write(byteLeidos);
			}
			
			fos.close();
			entrada.close();
					
			System.out.println("---------2 Finalizando comunicación --------");
			
			clientSocket.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		new Client();
		
	}
	
	
}
