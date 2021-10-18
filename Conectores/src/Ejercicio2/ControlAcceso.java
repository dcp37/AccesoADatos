package Ejercicio2;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ControlAcceso {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField pswrdUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlAcceso window = new ControlAcceso();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ControlAcceso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(null);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\usuario\\Desktop\\Imagenes\\Candado_Cerrado.PNG"));
		lblNewLabel.setBounds(99, 126, 211, 124);
		frame.getContentPane().add(lblNewLabel);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAceptar) {
					
					lblNewLabel.setIcon(new ImageIcon("C:\\Users\\usuario\\Desktop\\Imagenes\\Candado_Abierto.PNG"));
				}
			}
		});
		btnAceptar.setBounds(335, 90, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 39, 46, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasenha = new JLabel("Contraseña");
		lblContrasenha.setBounds(10, 70, 64, 14);
		frame.getContentPane().add(lblContrasenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(99, 36, 86, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pswrdUsuario = new JPasswordField();
		pswrdUsuario.setBounds(99, 67, 86, 20);
		frame.getContentPane().add(pswrdUsuario);

	}
}
