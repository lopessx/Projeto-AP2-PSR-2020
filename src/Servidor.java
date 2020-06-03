import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		//Servidor irá funcionar enquanto houver senhas disponíveis
		int senha = 0;
		do {
		try {
			//Servidor que irá receber informações de tela senha
			ServerSocket ss = new ServerSocket(9595); 
			Socket s = ss.accept(); 
			DataInputStream dis = new DataInputStream(s.getInputStream());
			senha = dis.readInt();
			ss.close();
			//Mostrando o valor recebido da tela senha
			
			System.out.println(senha + " recebida");
			
			//Irá enviar dados para tela Consultorio
			s = new Socket("localhost", 9594);
			
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			dout.writeInt(senha);
			
			dout.flush();
			
			dout.close();
			
			s.close();
			//Irá enviar dados para tela Atendimento
			s = new Socket("localhost", 9593);
			
			dout = new DataOutputStream(s.getOutputStream());
			
			dout.writeInt(senha);
			
			dout.flush();
			
			dout.close();
			
			s.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}while(senha<15);
		System.out.println("Conexão finalizada");
	}
}
