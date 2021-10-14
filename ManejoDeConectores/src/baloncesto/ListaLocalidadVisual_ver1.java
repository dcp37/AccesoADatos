package baloncesto;

//Alberto Carrera Mart�n
//28 abril 2021
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ListaLocalidadVisual_ver1 implements ActionListener {

	private JFrame frmBsquedaDeSocios;
	private JTextField txtSocio;
	private JTextField txtNombre;
	private JTextField txtEstatura;
	private JTextField txtEdad;
	private JTextField txtLocalidad;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JLabel lblCuenta;
	private JLabel lblAos;
	private JLabel lblCm;
	//
	private static AccesoBdatos abd;
	private ResultSet listado;
	private int filas = 0, posicion = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaLocalidadVisual_ver1 window = new ListaLocalidadVisual_ver1();
					window.frmBsquedaDeSocios.setVisible(true);
					abd = new AccesoBdatos();
					abd.conectar();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // del main de ListaLocalidadVisual

	/**
	 * Create the application.
	 */
	public ListaLocalidadVisual_ver1() {
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
		frmBsquedaDeSocios.setTitle("Búsqueda de Socios por localidad ver 1 (sin sentencias preparadas)");

		JLabel lblSocio = new JLabel("Socio");
		lblSocio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSocio.setBounds(51, 42, 46, 14);
		frmBsquedaDeSocios.getContentPane().add(lblSocio);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(51, 67, 60, 14);
		frmBsquedaDeSocios.getContentPane().add(lblNombre);

		JLabel lblEstatura = new JLabel("Estatura");
		lblEstatura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstatura.setBounds(51, 92, 60, 14);
		frmBsquedaDeSocios.getContentPane().add(lblEstatura);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEdad.setBounds(51, 117, 46, 14);
		frmBsquedaDeSocios.getContentPane().add(lblEdad);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocalidad.setBounds(51, 142, 60, 14);
		frmBsquedaDeSocios.getContentPane().add(lblLocalidad);

		txtSocio = new JTextField();
		txtSocio.setBounds(119, 41, 46, 20);
		frmBsquedaDeSocios.getContentPane().add(txtSocio);
		txtSocio.setColumns(10);
		txtSocio.setEditable(false);

		txtNombre = new JTextField();
		txtNombre.setBounds(119, 66, 207, 20);
		frmBsquedaDeSocios.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setEditable(false);

		txtEstatura = new JTextField();
		txtEstatura.setBounds(119, 91, 35, 20);
		frmBsquedaDeSocios.getContentPane().add(txtEstatura);
		txtEstatura.setColumns(10);
		txtEstatura.setEditable(false);

		txtEdad = new JTextField();
		txtEdad.setBounds(119, 116, 26, 20);
		frmBsquedaDeSocios.getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		txtEdad.setEditable(false);

		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(119, 139, 65, 20);
		frmBsquedaDeSocios.getContentPane().add(txtLocalidad);
		txtLocalidad.setEditable(false);
		txtLocalidad.setColumns(10);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(365, 29, 86, 20);
		frmBsquedaDeSocios.getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);

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

		lblAos = new JLabel("a\u00F1os");
		lblAos.setBounds(155, 119, 35, 14);
		frmBsquedaDeSocios.getContentPane().add(lblAos);

		lblCm = new JLabel("cm.");
		lblCm.setBounds(158, 94, 26, 14);
		frmBsquedaDeSocios.getContentPane().add(lblCm);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == btnBuscar) {

			try {
				String cadenaSQL = "SELECT * FROM Socio";
				if (!txtBuscar.getText().isEmpty())
					cadenaSQL = cadenaSQL + " WHERE localidad = '" + txtBuscar.getText() + "'";
				listado = abd.consultaLocalidadFormulario(cadenaSQL);
				listado.last();
				filas = listado.getRow();
				if (filas > 0) {
					btnAnterior.setEnabled(true);
					btnSiguiente.setEnabled(true);
					listado.first();
					posicion = 1;
					txtSocio.setText(listado.getString("socioID"));
					txtNombre.setText(listado.getString("nombre"));
					txtEstatura.setText(listado.getString("estatura"));
					txtEdad.setText(listado.getString("edad"));
					txtLocalidad.setText(listado.getString("localidad"));
					lblCuenta.setText("Socio 1 de " + filas);

				} else {
					btnAnterior.setEnabled(false);
					btnSiguiente.setEnabled(false);
					txtSocio.setText("");
					txtNombre.setText("");
					txtEstatura.setText("");
					txtEdad.setText("");
					txtLocalidad.setText("");
					lblCuenta.setText("");
					JOptionPane.showMessageDialog(null, "No se encontraron socios de " + txtBuscar.getText());
					txtBuscar.setText("");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("Filas: " + filas);
		} // de bot�n buscar
			//
		if (arg0.getSource() == btnAnterior) {
			System.out.println(posicion);
			if (posicion == 1) {
				JOptionPane.showMessageDialog(null, "No existen registros anteriores", "Primer Socio",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				posicion--;
				try {
					listado.absolute(posicion);
					txtSocio.setText(listado.getString("socioID"));
					txtNombre.setText(listado.getString("nombre"));
					txtEstatura.setText(listado.getString("estatura"));
					txtEdad.setText(listado.getString("edad"));
					txtLocalidad.setText(listado.getString("localidad"));
					lblCuenta.setText("Socio " + posicion + " de " + filas);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // de bot�n Anterior
			//
			//
		if (arg0.getSource() == btnSiguiente) {
			if (posicion == filas) {
				JOptionPane.showMessageDialog(null, "No existen registros posteriores", "�ltimo Socio",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				posicion++;
				try {
					listado.absolute(posicion);
					txtSocio.setText(listado.getString("socioID"));
					txtNombre.setText(listado.getString("nombre"));
					txtEstatura.setText(listado.getString("estatura"));
					txtEdad.setText(listado.getString("edad"));
					txtLocalidad.setText(listado.getString("localidad"));
					lblCuenta.setText("Socio " + posicion + " de " + filas);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} // de bot�n Siguiente

	}
}
