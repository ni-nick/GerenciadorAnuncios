package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexaoBanco.ConectaDataBase;
import Entidades.Cliente;
import TrataDados.TrataDados;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class CadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCliente frame = new CadastrarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarCliente() {
		setTitle("Cadastrar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(94, 46, 287, 20);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(94, 77, 143, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel labelNomeCliente = new JLabel("Nome: ");
		labelNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNomeCliente.setBounds(29, 49, 55, 14);
		contentPane.add(labelNomeCliente);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCPF.setBounds(29, 80, 55, 14);
		contentPane.add(labelCPF);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = new Cliente();
				cliente.setNomeCliente(txtNomeCliente.getText());
				cliente.setCPF(txtCPF.getText());
				
				TrataDados trataDados = new TrataDados();
				ConectaDataBase conectaDB = new ConectaDataBase();
				conectaDB.CriaConexao();
				
				if(trataDados.TrataDadosCliente(cliente)) {
					if(conectaDB.CadastrarClientes(cliente)) {
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
						txtNomeCliente.setText("");
						txtCPF.setText("");
					}
					else
						JOptionPane.showMessageDialog(null, "Não foi possível cadastrar cliente, nome ou CPF inválidos!");
				}
				
			}
		});
		btnOk.setBounds(208, 214, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNomeCliente.setText(" ");
				txtCPF.setText(" ");
			}
		});
		btnLimpar.setBounds(109, 214, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PaginaInicial inicio = new PaginaInicial();
				inicio.setVisible(true);
				
				setVisible(false);
			}
		});
		btnCancelar.setBounds(10, 214, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAvancar = new JButton("Avan\u00E7ar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastrarAnuncio cadastro = new CadastrarAnuncio();
				cadastro.setVisible(true);
				
				
				setVisible(false);
			}
		});
		btnAvancar.setBounds(307, 214, 89, 23);
		contentPane.add(btnAvancar);
		
		JLabel lblNewLabel = new JLabel("Adicione n\u00FAmeros e caracteres");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(94, 100, 148, 14);
		contentPane.add(lblNewLabel);
	}
}
