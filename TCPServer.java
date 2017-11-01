package tcpserver;

import java.io.*;
import java.net.*;

public class TCPServer 
{

    public static void main(String[] args) throws Exception {
 
        String fraseCliente; // Frase recebida do cliente
        String fraseMaiuscula; // Frase a ser enviada para o servidor

        // Cabeçalho
        System.out.println("Teste de Socket - Servidor");
        System.out.println("--------------------------\n");

        // Abre um socket para escutar na porta 6789
        ServerSocket socketBoasVindas = new ServerSocket(6789);

        // Entra em um laço infinito
        while(true) {
  
            // Cada conexão de cliente é tratada como um objeto da classe Socket
            Socket socketConexao = socketBoasVindas.accept();
  
            // Prepara para receber as informações enviadas do cliente
            BufferedReader doCliente = 
                new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));

            // Prepara para enviar as informações ao cliente
            DataOutputStream paraCliente = 
                new DataOutputStream(socketConexao.getOutputStream());

            // Recebe a frase informada pelo cliente e passa para maiúscula
            fraseCliente = doCliente.readLine();
            fraseMaiuscula = fraseCliente.toUpperCase() + '\n';

            // Imprime os valores recebido e a ser enviado
            System.out.println("FRASE DO CLIENTE: " + fraseCliente);
            System.out.println("FRASE DO SERVIDOR: " + fraseMaiuscula);

            // Envia as informações ao cliente
            paraCliente.writeBytes(fraseMaiuscula);
        }
    }

}
