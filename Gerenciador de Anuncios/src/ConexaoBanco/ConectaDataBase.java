package ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Anuncio;
import Entidades.Cliente;

public class ConectaDataBase {
	
	private Connection conexao = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void CriaConexao() {
		
		String url = "jdbc:mysql://127.0.0.1:3306/";
	    String user = "root";
	    String password = "123456";
	    
	    try {
	    	
	    	this.conexao = DriverManager.getConnection(url, user, password);
	    	this.statement = this.conexao.createStatement();
	    	
	    	//CRIANDO DATA BASE
	    	String query = "create database if not exists GerenciadorAnuncio;";
	    	String useDB = "USE GerenciadorAnuncio;";
	    	int resultSet = this.statement.executeUpdate(query);
	    	resultSet = this.statement.executeUpdate(useDB);
	    	this.statement = this.conexao.createStatement();
	    	
	    }
	    catch(SQLException e) {
	    	System.out.println("error:  "+e.getMessage());
	    }
	}
	
	//-------------CADASTRO DOS CLIENTES--------------
	
	public void CriaTabelaClientes(Cliente cliente) {
		
		try {
			String query = "create table if not exists Clientes (IdClientes int primary key auto_increment, nomeCliente varchar(100), cpf varchar (14), IdAnuncios int);";
			int resulteSet = this.statement.executeUpdate(query);
			this.statement = this.conexao.createStatement();
			
		}catch (SQLException e) {
			System.out.println("error :  "+ e.getMessage());
		}
	}
	
	public boolean CadastrarClientes(Cliente cliente) {
		
		try {
			String query = "insert into Clientes (nomeCliente, cpf) values ('" + cliente.getNomeCliente() + "', '" + cliente.getCPF() +"');";
			int resultSet = this.statement.executeUpdate(query);
			this.statement = this.conexao.createStatement();
			return true;

		}catch (SQLException e) {
			System.out.println("error:  " + e.getMessage());
			return false;
		}
	}
	
	
	public ArrayList<Cliente> CarregaTodosClientes(){
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try {
			String query = "select * from Clientes;";
			this.resultSet = this.statement.executeQuery(query);
			this.statement = this.conexao.createStatement();
			
			while(this.resultSet.next()) {
				
				Cliente clientes = new Cliente();
				clientes.setIdCliente(Integer.parseInt(this.resultSet.getString("IdClientes")));
				clientes.setNomeCliente(this.resultSet.getString("NomeCliente"));
				clientes.setCPF(this.resultSet.getString("CPF"));
				
				listaClientes.add(clientes);
			}
			
		}catch (SQLException e) {
			System.out.println("error :"+ e.getMessage());
		}
		
		return listaClientes;
		
	}
	
	
	
	//-------------CADASTRO DE ANUNCIOS--------------
	
	public void CriaTabelaAnuncios(Anuncio anuncio) {
		
		try {
			String query = "create table if not exists Anuncios( IdAnuncios int primary key auto_increment, nomeAnuncio varchar(50), diaI int, mesI int, anoI int, diaF int, mesF int, anoF int, Investimento varchar(4));";
			int resulteSet = this.statement.executeUpdate(query);
			this.statement = this.conexao.createStatement();
		
	
		}catch (SQLException e) {
			System.out.println("error :  "+ e.getMessage());
		}
	
	}
	

	public boolean CadastraAnuncios(Anuncio anuncio) {	

		try {
			String query = "insert into Anuncios (nomeAnuncio, diaI, mesI, anoI, diaF, mesF, anoF, Investimento) values ('" + anuncio.getNomeAnuncio() + "', '" + anuncio.getDiaI() + "', '"+ anuncio.getMesI()+"', '"+ anuncio.getAnoI()+"','"+anuncio.getDiaF()+"','"+anuncio.getMesF()+"','"+anuncio.getAnoF()+"','"+anuncio.getInvestimento()+"');";
			int resultSet = this.statement.executeUpdate(query);
			this.statement = this.conexao.createStatement();
			return true;

		}catch (SQLException e) {
			System.out.println("error:  " + e.getMessage());
			return false;
		}
	}
	
	public ArrayList<Anuncio> CarregaTodosAnuncios(){
		
		ArrayList<Anuncio> listarAnuncios = new ArrayList<Anuncio>();
		
		try {
			String query = "select * from Anuncios;";
			this.resultSet = this.statement.executeQuery(query);
			this.statement = this.conexao.createStatement();
			
			while (this.resultSet.next()) {
				
				Anuncio anuncios = new Anuncio();
				anuncios.setIdAnuncio(Integer.parseInt(this.resultSet.getString("IdAnuncios")));
				anuncios.setNomeAnuncio(this.resultSet.getString("nomeAnuncio"));
				anuncios.setDiaI(Integer.parseInt(this.resultSet.getString("diaI")));
				anuncios.setMesI(Integer.parseInt(this.resultSet.getString("mesI")));
				anuncios.setAnoI(Integer.parseInt(this.resultSet.getString("anoI")));
				anuncios.setDiaF(Integer.parseInt(this.resultSet.getString("diaF")));
				anuncios.setMesF(Integer.parseInt(this.resultSet.getString("mesF")));
				anuncios.setAnoF(Integer.parseInt(this.resultSet.getString("anoF")));
				anuncios.setInvestimento(this.resultSet.getString("Investimento"));
				
				listarAnuncios.add(anuncios);
			}
		}catch (SQLException e) {
			System.out.println("error :"+ e.getMessage());
		}
		
		return listarAnuncios;
	}
	
	
	//------------------VINCULAR ANUNCIO COM CLIENTE----------------
	
	public boolean VinculaAnuncioCliente(int IdAnuncio, int IdClientes) {
		
		try {
			String query = "update Clientes set IdAnuncios = " + IdAnuncio + "where IdClientes = " +IdClientes;
			int resulSet = this.statement.executeUpdate(query);
			this.statement = this.conexao.createStatement();
			return true;
			

		}catch (SQLException e) {
			System.out.println("error :" +e.getMessage());
			return false;
		}
	}

}
