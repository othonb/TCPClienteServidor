package webclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class WebClient 
{
// Método único da classe cliente 
public static void main(String[] args) throws Exception 
{
 String frase; // frase digitada pelo usuário
 String respostaServidor; // frase modificada pelo servidor
 String servidor; // Nome do servidor

 System.out.println("Teste de Socket - Cliente");
 System.out.println("-------------------------\n");

 // Prepara a leitura da variável do teclado
 BufferedReader doUsuario = 
  new BufferedReader(new InputStreamReader(System.in));

 // Lê o nome do servidor
 System.out.print("Informe o nome/endereço IP do servidor:");
 servidor = doUsuario.readLine();

 // Inicia o socket do cliente com o computador especificado em servidor
 Socket socketCliente = new Socket(servidor, 80);

 System.out.println("Conexao estabelecida...");

 // Prepara para escrever no socket   
 DataOutputStream paraServidor = 
  new DataOutputStream(socketCliente.getOutputStream());
  
 // Prepara para ler do socket
 BufferedReader doServidor = 
  new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

// Envia uma solicitação GET ao servidor
 paraServidor.writeBytes("GET / HTTP/1.1 \r\n");
 paraServidor.writeBytes("Host: " + servidor + "\r\n");
 paraServidor.writeBytes("\r\n");

 // Mensagem informando que enviou o GET
 System.out.println("Enviei o GET...");

 // Recebe do servidor
 respostaServidor = doServidor.readLine();
 while(respostaServidor != null)
 {
  System.out.println(respostaServidor);
  respostaServidor = doServidor.readLine();
 }

 socketCliente.close();
}
    
}