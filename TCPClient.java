package tcpclient;

import java.io.*;
import java.net.*;

public class TCPClient 
{

    public static void main(String[] args) throws Exception {
        
        String frase; // frase digitada pelo usuário
        String fraseModificada; // frase modificada pelo servidor
        String servidor; // Nome do servidor

        System.out.println("Teste de Socket - Cliente");
        System.out.println("-------------------------\n");

        // Prepara a leitura da variável do teclado
        BufferedReader doUsuario = 
            new BufferedReader(new InputStreamReader(System.in));

        // Lê o nome do servidor
        System.out.print("Informe o nome/endereço IP do servidor:");
        servidor = doUsuario.readLine();

        while (true) {
 
            // Inicia o socket do cliente com o computador especificado em servidor
            Socket socketCliente = new Socket(servidor, 80);

            // Prepara para escrever no socket   
            DataOutputStream paraServidor = 
                new DataOutputStream(socketCliente.getOutputStream());
  
            // Prepara para ler do socket
            BufferedReader doServidor = 
                new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            System.out.print("Informe uma frase:");
            frase = doUsuario.readLine();
            paraServidor.writeBytes(frase + "\r\n");
            fraseModificada = doServidor.readLine();

            System.out.println("DO USUARIO: " + frase);
            System.out.println("DO SERVIDOR: " + fraseModificada);
        }
 
    }
    
}