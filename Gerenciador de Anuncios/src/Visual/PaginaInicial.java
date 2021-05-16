package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaginaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaInicial frame = new PaginaInicial();
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
	public PaginaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemvindoAoCadastra = new JLabel("    Bem-vindo ao Cadastra An\u00FAncios");
		lblBemvindoAoCadastra.setFont(new Font("Source Serif Pro Semibold", Font.BOLD, 15));
		lblBemvindoAoCadastra.setBounds(27, 11, 246, 26);
		contentPane.add(lblBemvindoAoCadastra);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadastrarCliente cliente = new CadastrarCliente();
				cliente.setVisible(true);
				
				setVisible(false);
			}
		});
		btnCadastrarCliente.setBounds(52, 85, 189, 26);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnNewButton = new JButton("Vincular An\u00FAncio Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VinculaAnuncioeCliente vincular = new VinculaAnuncioeCliente();
				vincular.setVisible(true);
				
				
				setVisible(false);
			}
		});
		btnNewButton.setBounds(52, 136, 189, 26);
		contentPane.add(btnNewButton);
	}

}
