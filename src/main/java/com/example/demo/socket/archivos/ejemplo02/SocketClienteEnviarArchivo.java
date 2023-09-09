package com.example.demo.socket.archivos.ejemplo02;

import java.net.*;
import java.io.*;

public class SocketClienteEnviarArchivo {

	private final String HOST = "localhost";
	private final Integer PUERTO = 3456;

	@SuppressWarnings("unused")
	public SocketClienteEnviarArchivo(String ruta) {
		try {
			Socket cliente = new Socket(HOST, PUERTO);

			// 1 ENVO DEL NOMBRE DEL ARCHIVO
			// ====================================
			// Permite el envio de cualquier objeto
			ObjectOutputStream ous = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
		
			
			// 2 ENVO DE LOS PAQUETES DE BYTES DEL ARCHIVO
			// ============================================
			File file = new File(ruta);
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
