package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexaoBanco.ConectaDataBase;
import Entidades.Anuncio;
import Entidades.Cliente;
import TrataDados.TrataDados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class VinculaAnuncioeCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeAnuncio;
	private JTextField txtNomeCliente;
	private JTextField txtCPF;
	private JComboBox  cbAnuncio;
	private JComboBox  cbCliente;
	
	private ArrayList<Cliente> listarClientes = new ArrayList<Cliente>();
	private ArrayList<Anuncio> listarAnuncios = new ArrayList<Anuncio>();
	
	ConectaDataBase conectaDB = new ConectaDataBase();
	private JTextField txtInvestimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VinculaAnuncioeCliente frame = new VinculaAnuncioeCliente();
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
	public VinculaAnuncioeCliente() {
		setTitle("Vincular Cliente ao An\u00FAncio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.conectaDB.CriaConexao();
		
		JLabel lblNomeDoAnuncio = new JLabel("Nome do An\u00FAncio: ");
		lblNomeDoAnuncio.setBounds(10, 172, 109, 14);
		contentPane.add(lblNomeDoAnuncio);
		
		JLabel lblInvestimentoR = new JLabel("Investimento R$:");
		lblInvestimentoR.setBounds(10, 199, 98, 14);
		contentPane.add(lblInvestimentoR);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente: ");
		lblNomeDoCliente.setBounds(10, 253, 98, 14);
		contentPane.add(lblNomeDoCliente);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 278, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNomeDoAnncio = new JLabel("Selecione um An\u00FAncio:");
		lblNomeDoAnncio.setBounds(10, 27, 119, 14);
		contentPane.add(lblNomeDoAnncio);
		
		JLabel lblNomeDoCliente_1 = new JLabel("Selecione um Cliente:");
		lblNomeDoCliente_1.setBounds(10, 81, 119, 14);
		contentPane.add(lblNomeDoCliente_1);
		
		txtNomeAnuncio = new JTextField();
		txtNomeAnuncio.setEditable(false);
		txtNomeAnuncio.setBounds(139, 169, 341, 20);
		contentPane.add(txtNomeAnuncio);
		txtNomeAnuncio.setColumns(10);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setBounds(139, 250, 341, 20);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setEnabled(true);
		txtCPF.setEditable(false);
		txtCPF.setText("");
		txtCPF.setBounds(139, 275, 124, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		cbAnuncio = new JComboBox();
		cbAnuncio.setBounds(139, 24, 341, 20);
		cbAnuncio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			
				if(cbAnuncio.getItemCount()!=0) {
					txtNomeAnuncio.setText(listarAnuncios.get(cbAnuncio.getSelectedIndex()).getNomeAnuncio());
					txtInvestimento.setText(listarAnuncios.get(cbAnuncio.getSelectedIndex()).getInvestimento());
				}
				
			}
		});
		contentPane.add(cbAnuncio);
		
		cbCliente = new JComboBox();
		cbCliente.setBounds(139, 78, 341, 20);
		cbCliente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(cbCliente.getItemCount()!=0) {
					txtNomeCliente.setText(listarClientes.get(cbCliente.getSelectedIndex()).getNomeCliente());
					txtCPF.setText(listarClientes.get(cbCliente.getSelectedIndex()).getCPF());
				}
				
			}
		});
		contentPane.add(cbCliente);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PaginaInicial inicio = new PaginaInicial();
				inicio.setVisible(true);
				
				setVisible(false);
			}
		});
		btnVoltar.setBounds(391, 311, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnVincular = new JButton("Vincular");
		btnVincular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TrataDados trataDados = new TrataDados();
				Anuncio anuncio = new Anuncio();
				Cliente clientes = new Cliente();
				
				clientes.setIdCliente(listarClientes.get(cbCliente.getSelectedIndex()).getIdCliente());
				anuncio.setIdAnuncio(listarAnuncios.get(cbAnuncio.getSelectedIndex()).getIdAnuncio());
				
				int idAnuncio = listarAnuncios.get(cbAnuncio.getSelectedIndex()).getIdAnuncio();
				int idCliente = listarClientes.get(cbCliente.getSelectedIndex()).getIdCliente();
				int Investimento = Integer.parseInt(listarAnuncios.get(cbAnuncio.getSelectedIndex()).getInvestimento());
				
				if(conectaDB.VinculaAnuncioCliente(listarAnuncios.get(cbAnuncio.getSelectedIndex()).getIdAnuncio() , listarClientes.get(cbCliente.getSelectedIndex()).getIdCliente())){
					JOptionPane.showMessageDialog(null, "Anúncio vinculado ao cliente com sucesso!");
				}
				
				else
					JOptionPane.showMessageDialog(null, "Não foi possível vincular o anúncio ao cliente. Dados inconsistentes!");
				}
		});
		btnVincular.setBounds(292, 311, 89, 23);
		contentPane.add(btnVincular);
		
		txtInvestimento = new JTextField();
		txtInvestimento.setEditable(false);
		txtInvestimento.setBounds(139, 196, 124, 20);
		contentPane.add(txtInvestimento);
		txtInvestimento.setColumns(10);
		
		PreencheCBcliente();
		PreencheCBanuncio();
	}
	
	private void PreencheCBcliente() {
		
		listarClientes = this.conectaDB.CarregaTodosClientes();
		cbCliente.removeAllItems();
		
		for(int index = 0; index < listarClientes.size(); index ++)
			cbCliente.addItem(listarClientes.get(index).getNomeCliente()+ "   CPF:"+listarClientes.get(index).getCPF());
		
		return;
	}
	
	private void PreencheCBanuncio() {
		
		listarAnuncios = this.conectaDB.CarregaTodosAnuncios();
		cbAnuncio.removeAllItems();
		
		for(int index = 0; index < listarAnuncios.size(); index ++)
			cbAnuncio.addItem(listarAnuncios.get(index).getNomeAnuncio()+ "    R$"+listarAnuncios.get(index).getInvestimento());
		
		return;
		
	}
}
