
public class Programa {

		public static void main(String[] args) {
		//Instacia��o das telas
		TelaSenha telaSenha = new TelaSenha();
		telaSenha.setVisible(true);
		
		TelaConsultorio telaConsultorio = new TelaConsultorio();
		telaConsultorio.setVisible(true);
		telaSenha.registrarObserver(telaConsultorio);
		
		TelaAtendimento telaAtendimento = new TelaAtendimento();
		telaAtendimento.setVisible(true);
		telaSenha.registrarObserver(telaAtendimento);
		//Inicializa��o dos servidores das classes
		telaSenha.notificar();
	}
	
}
