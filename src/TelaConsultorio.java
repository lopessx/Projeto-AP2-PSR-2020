import java.awt.Color;
import java.awt.Font;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaConsultorio extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	
	private int senhaAtual = 0;
	private int senha;
	private JLabel lbNome;
	private JLabel lbSenha;

	public TelaConsultorio() {
		this.setTitle("Tela Consultório");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(650, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		this.lbNome = new JLabel("Tela Consultorio");
		this.lbNome.setFont(new Font("Serif", Font.BOLD, 32));
		this.lbNome.setBounds(20, 20, 400, 40);
		this.add(lbNome);
		

		this.lbSenha = new JLabel("Senha Atual: " + senhaAtual);
		this.lbSenha.setFont(new Font("Serif", Font.BOLD, 60));
		this.lbSenha.setBounds(20, 150, 500, 100);
		this.lbSenha.setForeground(Color.red);
		this.add(lbSenha);

	}
	
	
	//Função do observer que irá receber os dados enviados do servidor
	@Override
	public void atualizar(Subject subject) {
		if(subject instanceof TelaSenha) {
			
			
			try {
				
				ServerSocket ss = new ServerSocket(9594); 
				
				Socket s = ss.accept(); 
				
				DataInputStream dis = new DataInputStream(s.getInputStream());
				
				senha = dis.readInt();
				
				ss.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			//Aqui a tela é atualizada
			this.senhaAtual = senha;
			this.lbSenha.setText("Senha Atual: " + this.senhaAtual);
		}
	}

}
