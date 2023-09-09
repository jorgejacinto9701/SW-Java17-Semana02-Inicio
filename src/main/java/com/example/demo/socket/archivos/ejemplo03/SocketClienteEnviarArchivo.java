package com.example.demo.socket.archivos.ejemplo03;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClienteEnviarArchivo {

	private final String HOST = "localhost";
	private final Integer PUERTO = 3456;

	@SuppressWarnings("unused")
	public SocketClienteEnviarArchivo(String rutas) {
		System.out.println(rutas);

		try {

			Socket cliente = new Socket(HOST, PUERTO);

			// 1 ENVO DEL NOMBRE DEL ARCHIVO
			// ====================================
			// Permite el envio de cualquier objeto
			ObjectOutputStream ous = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
			

			// 2 ENVO DE LOS PAQUETES DE BYTES DEL ARCHIVO
			// ============================================
			
			File file = new File("");
			FileInputStream fis = new FileInputStream(file);
			DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

			
			fis.close();
			salida.close();
			cliente.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
