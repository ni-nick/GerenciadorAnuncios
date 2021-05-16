package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexaoBanco.ConectaDataBase;
import Entidades.Anuncio;
import Entidades.Cliente;
import TrataDados.TrataDados;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;

public class CadastrarAnuncio extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeAnuncio;
	private JTextField txtDiaI;
	private JTextField txtInvestimento;
	private JTextField txtMesI;
	private JTextField txtAnoI;
	private JTextField txtDiaF;
	private JTextField txtMesF;
	private JTextField txtAnoF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAnuncio frame = new CadastrarAnuncio();
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
	public CadastrarAnuncio() {
		setTitle("Cadastrar An\u00FAncios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNomeAnuncio = new JTextField();
		txtNomeAnuncio.setBounds(148, 21, 394, 20);
		contentPane.add(txtNomeAnuncio);
		txtNomeAnuncio.setColumns(10);
		
		JLabel labelNomeAnuncio = new JLabel("Nome do An\u00FAncio: ");
		labelNomeAnuncio.setBounds(10, 24, 128, 14);
		contentPane.add(labelNomeAnuncio);
		
		txtDiaI = new JTextField();
		txtDiaI.setToolTipText("");
		txtDiaI.setBounds(148, 94, 37, 20);
		contentPane.add(txtDiaI);
		txtDiaI.setColumns(10);
		
		txtMesI = new JTextField();
		txtMesI.setToolTipText("");
		txtMesI.setColumns(10);
		txtMesI.setBounds(189, 94, 37, 20);
		contentPane.add(txtMesI);
		
		txtAnoI = new JTextField();
		txtAnoI.setToolTipText("");
		txtAnoI.setColumns(10);
		txtAnoI.setBounds(229, 94, 37, 20);
		contentPane.add(txtAnoI);
		
		txtDiaF = new JTextField();
		txtDiaF.setToolTipText("");
		txtDiaF.setColumns(10);
		txtDiaF.setBounds(148, 127, 37, 20);
		contentPane.add(txtDiaF);
		
		txtMesF = new JTextField();
		txtMesF.setToolTipText("");
		txtMesF.setColumns(10);
		txtMesF.setBounds(189, 127, 37, 20);
		contentPane.add(txtMesF);
		
		txtAnoF = new JTextField();
		txtAnoF.setToolTipText("");
		txtAnoF.setColumns(10);
		txtAnoF.setBounds(229, 127, 37, 20);
		contentPane.add(txtAnoF);
		
		JLabel labelDataInicio = new JLabel("Data de In\u00EDcio:");
		labelDataInicio.setBounds(10, 97, 113, 14);
		contentPane.add(labelDataInicio);
		
		JLabel labelDataTermino = new JLabel("Data de T\u00E9rmino:");
		labelDataTermino.setBounds(10, 133, 113, 14);
		contentPane.add(labelDataTermino);
		
		txtInvestimento = new JTextField();
		txtInvestimento.setBounds(148, 165, 118, 20);
		contentPane.add(txtInvestimento);
		txtInvestimento.setColumns(10);
		
		JLabel labelInvestimento = new JLabel("Investimento por dia R$:");
		labelInvestimento.setBounds(10, 168, 139, 14);
		contentPane.add(labelInvestimento);
		
		JButton bntVoltar = new JButton("Voltar");
		bntVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				CadastrarCliente cliente = new CadastrarCliente();
				cliente.setVisible(true);
				
				setVisible(false);
			}
		});
		bntVoltar.setBounds(257, 225, 89, 23);
		contentPane.add(bntVoltar);
		
		JButton bntOK = new JButton("OK");
		bntOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Anuncio anuncios = new Anuncio();
				anuncios.setNomeAnuncio(txtNomeAnuncio.getText());
				anuncios.setDiaI(Integer.parseInt(txtDiaI.getText()));
				anuncios.setMesI(Integer.parseInt(txtMesI.getText()));
				anuncios.setAnoI(Integer.parseInt(txtAnoI.getText()));
				anuncios.setDiaF(Integer.parseInt(txtDiaF.getText()));
				anuncios.setMesF(Integer.parseInt(txtMesF.getText()));
				anuncios.setAnoF(Integer.parseInt(txtAnoF.getText()));
				anuncios.setInvestimento((txtInvestimento.getText()));
				
				TrataDados trataDados = new TrataDados();
				ConectaDataBase conectaDB = new ConectaDataBase();
				conectaDB.CriaConexao();
				
				if(trataDados.TrataDadosAnuncio(anuncios)) {
					if(conectaDB.CadastraAnuncios(anuncios)) {
						
						JOptionPane.showMessageDialog(null, "Anúncio cadastrado com sucesso!");
						txtNomeAnuncio.setText("");
						txtDiaI.setText("");
						txtMesI.setText("");
						txtAnoI.setText("");
						txtDiaF.setText("");
						txtMesF.setText("");
						txtAnoF.setText("");
						txtInvestimento.setText("");	
					}
					else 
						JOptionPane.showMessageDialog(null, "Não foi possível cadastrar anúncio, dados inválidos!");
				}
				
			}
			
		});
		bntOK.setBounds(356, 225, 89, 23);
		contentPane.add(bntOK);
		
		JButton bntLimpar = new JButton("Limpar");
		bntLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNomeAnuncio.setText("");
				txtDiaI.setText("");
				txtMesI.setText("");
				txtAnoI.setText("");
				txtDiaF.setText("");
				txtMesF.setText("");
				txtAnoF.setText("");
				txtInvestimento.setText("");	
			}
		});
		bntLimpar.setBounds(158, 225, 89, 23);
		contentPane.add(bntLimpar);
		
		
		JLabel lblDiamesano = new JLabel("dia/mes/ano");
		lblDiamesano.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDiamesano.setEnabled(false);
		lblDiamesano.setBounds(270, 130, 58, 14);
		contentPane.add(lblDiamesano);
		
		JLabel label = new JLabel("dia/mes/ano");
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setEnabled(false);
		label.setBounds(270, 97, 58, 14);
		contentPane.add(label);
		
		JButton btnAvanar = new JButton("Avan\u00E7ar");
		btnAvanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PaginaInicial inicio = new PaginaInicial();
				inicio.setVisible(true);
				
				setVisible(false);
			}
		});
		btnAvanar.setBounds(453, 225, 89, 23);
		contentPane.add(btnAvanar);
		
		JLabel lblNewLabel = new JLabel("Inserir apenas valores inteiros");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(148, 185, 128, 14);
		contentPane.add(lblNewLabel);
		
	}
}
