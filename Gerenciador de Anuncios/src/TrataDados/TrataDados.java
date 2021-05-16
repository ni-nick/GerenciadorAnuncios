package TrataDados;

import javax.swing.JOptionPane;

import ConexaoBanco.ConectaDataBase;
import Entidades.Anuncio;
import Entidades.Cliente;

public class TrataDados {
	
	ConectaDataBase conectaDB = new ConectaDataBase();
	
	public boolean TrataDadosCliente(Cliente cliente) {
		
		if(cliente.getNomeCliente().isEmpty() && cliente.getCPF().isEmpty())
			return false;
		
		return true;
		
	}
	
	public boolean TrataDadosAnuncio(Anuncio anuncio) {
		
		if(anuncio.getNomeAnuncio().isEmpty() && anuncio.getInvestimento().isEmpty())
			return false;
		
		return true;	
	
	}

}
