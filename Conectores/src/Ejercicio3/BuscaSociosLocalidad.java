
package Ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * @author David♥
 *
 */
public class BuscaSociosLocalidad implements ActionListener {

	private JFrame frmBsquedaDeSocios;
	private JTextField txtSocioId;
	private JTextField txtSocioNombre;
	private JTextField txtSocioEstatura;
	private JTextField txtSocioEdad;
	private JTextField txtSocioLocalidad;
	private JTextField txtBuscaSocio;
	private JButton btnBuscar;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JLabel lblCuenta;
	private JLabel lblAnhos;
	private JLabel lblCm;
	//
	private static AccesoBdatos abd;
	private ResultSet socios;
	private int filas = 0, posicion = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaSociosLocalidad window = new BuscaSociosLocalidad();
					window.frmBsquedaDeSocios.setVisible(true);
					abd = new AccesoBdatos();
					abd.conexion();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuscaSociosLocalidad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBsquedaDeSocios = new JFrame();
		frmBsquedaDeSocios.setBounds(100, 100, 491, 319);
		frmBsquedaDeSocios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBsquedaDeSocios.getContentPane().setLayout(null);
		frmBsquedaDeSocios.setTitle("Búsqueda de Socios por localidad");

		JLabel lblSocio = new JLabel("Socio");
		lblSocio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSocio.setBounds(51, 42, 46, 14);
		frmBsquedaDeSocios.getContentPane().add(lblSocio);

		JLabel lblSocioNombre = new JLabel("Nombre");
		lblSocioNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSocioNombre.setBounds(51, 67, 60, 14);
		frmBsquedaDeSocios.getContentPane().add(lblSocioNombre);

		JLabel lblSocioEstatura = new JLabel("Estatura");
		lblSocioEstatura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSocioEstatura.setBounds(51, 92, 60, 14);
		frmBsquedaDeSocios.getContentPane().add(lblSocioEstatura);

		JLabel lblSocioEdad = new JLabel("Edad");
		lblSocioEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSocioEdad.setBounds(51, 117, 46, 14);
		frmBsquedaDeSocios.getContentPane().add(lblSocioEdad);

		JLabel lblSocioLocalidad = new JLabel("Localidad");
		lblSocioLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSocioLocalidad.setBounds(51, 142, 60, 14);
		frmBsquedaDeSocios.getContentPane().add(lblSocioLocalidad);

		txtSocioId = new JTextField();
		txtSocioId.setBounds(119, 41, 46, 20);
		frmBsquedaDeSocios.getContentPane().add(txtSocioId);
		txtSocioId.setColumns(10);
		txtSocioId.setEditable(false);

		txtSocioNombre = new JTextField();
		txtSocioNombre.setBounds(119, 66, 207, 20);
		frmBsquedaDeSocios.getContentPane().add(txtSocioNombre);
		txtSocioNombre.setColumns(10);
		txtSocioNombre.setEditable(false);

		txtSocioEstatura = new JTextField();
		txtSocioEstatura.setBounds(119, 91, 35, 20);
		frmBsquedaDeSocios.getContentPane().add(txtSocioEstatura);
		txtSocioEstatura.setColumns(10);
		txtSocioEstatura.setEditable(false);

		txtSocioEdad = new JTextField();
		txtSocioEdad.setBounds(119, 116, 26, 20);
		frmBsquedaDeSocios.getContentPane().add(txtSocioEdad);
		txtSocioEdad.setColumns(10);
		txtSocioEdad.setEditable(false);

		txtSocioLocalidad = new JTextField();
		txtSocioLocalidad.setBounds(119, 139, 65, 20);
		frmBsquedaDeSocios.getContentPane().add(txtSocioLocalidad);
		txtSocioLocalidad.setEditable(false);
		txtSocioLocalidad.setColumns(10);

		txtBuscaSocio = new JTextField();
		txtBuscaSocio.setBounds(365, 29, 86, 20);
		frmBsquedaDeSocios.getContentPane().add(txtBuscaSocio);
		txtBuscaSocio.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(365, 61, 89, 23);
		frmBsquedaDeSocios.getContentPane().add(btnBuscar);

		btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnterior.setBounds(158, 226, 89, 23);
		frmBsquedaDeSocios.getContentPane().add(btnAnterior);
		btnAnterior.addActionListener(this);
		btnAnterior.setEnabled(false);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSiguiente.setBounds(277, 226, 89, 23);
		frmBsquedaDeSocios.getContentPane().add(btnSiguiente);
		btnSiguiente.addActionListener(this);
		btnSiguiente.setEnabled(false);

		lblCuenta = new JLabel("");
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuenta.setBounds(183, 171, 216, 14);
		frmBsquedaDeSocios.getContentPane().add(lblCuenta);

		lblAnhos = new JLabel("a\u00F1os");
		lblAnhos.setBounds(155, 119, 35, 14);
		frmBsquedaDeSocios.getContentPane().add(lblAnhos);

		lblCm = new JLabel("cm.");
		lblCm.setBounds(158, 94, 26, 14);
		frmBsquedaDeSocios.getContentPane().add(lblCm);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == btnBuscar) {

			try {
				socios = abd.consultaLocalidad(txtBuscaSocio.getText());
				socios.last();
				filas = socios.getRow();
				if (filas > 0) {
					btnAnterior.setEnabled(true);
					btnSiguiente.setEnabled(true);
					socios.first();
					posicion = 1;
					txtSocioId.setText(socios.getString("socioID"));
					txtSocioNombre.setText(socios.getString("nombre"));
					txtSocioEstatura.setText(socios.getString("estatura"));
					txtSocioEdad.setText(socios.getString("edad"));
					txtSocioLocalidad.setText(socios.getString("localidad"));
					lblCuenta.setText("Socio 1 de " + filas);

				} else {
					btnAnterior.setEnabled(false);
					btnSiguiente.setEnabled(false);
					txtSocioId.setText("");
					txtSocioNombre.setText("");
					txtSocioEstatura.setText("");
					txtSocioEdad.setText("");
					txtSocioLocalidad.setText("");
					lblCuenta.setText("");
					JOptionPane.showMessageDialog(null, "No se encontraron socios de " + txtBuscaSocio.getText());
					txtBuscaSocio.setText("");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// System.out.println("Filas: " + filas);
		}
		if (arg0.getSource() == btnAnterior) {
			System.out.println(posicion);
			if (posicion == 1) {
				JOptionPane.showMessageDialog(null, "No existen registros anteriores", "Primer Socio",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				posicion--;
				try {
					socios.absolute(posicion);
					txtSocioId.setText(socios.getString("socioID"));
					txtSocioNombre.setText(socios.getString("nombre"));
					txtSocioEstatura.setText(socios.getString("estatura"));
					txtSocioEdad.setText(socios.getString("edad"));
					txtSocioLocalidad.setText(socios.getString("localidad"));
					lblCuenta.setText("Socio " + posicion + " de " + filas);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (arg0.getSource() == btnSiguiente) {
			if (posicion == filas) {
				JOptionPane.showMessageDialog(null, "No existen registros posteriores", "�ltimo Socio",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				posicion++;
				try {
					socios.absolute(posicion);
					txtSocioId.setText(socios.getString("socioID"));
					txtSocioNombre.setText(socios.getString("nombre"));
					txtSocioEstatura.setText(socios.getString("estatura"));
					txtSocioEdad.setText(socios.getString("edad"));
					txtSocioLocalidad.setText(socios.getString("localidad"));
					lblCuenta.setText("Socio " + posicion + " de " + filas);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
