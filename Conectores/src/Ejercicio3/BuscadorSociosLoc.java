package Ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class BuscadorSociosLoc {

	private JFrame frmBuscasocioslocalidad;
	private JTextField txtIdSocio;
	private JTextField txtNombreSocio;
	private JTextField txtEstaturaSocio;
	private JTextField txtEdadSocio;
	private JTextField txtLocalidadSocio;
	private JTextField txtBuscaSocio;

	/**
	 * @return the txtIdSocio
	 */
	public JTextField getTxtIdSocio() {
		return txtIdSocio;
	}

	/**
	 * @param txtIdSocio the txtIdSocio to set
	 */
	public void setTxtIdSocio(JTextField txtIdSocio) {
		this.txtIdSocio = txtIdSocio;
	}

	/**
	 * @return the txtNombreSocio
	 */
	public JTextField getTxtNombreSocio() {
		return txtNombreSocio;
	}

	/**
	 * @param txtNombreSocio the txtNombreSocio to set
	 */
	public void setTxtNombreSocio(JTextField txtNombreSocio) {
		this.txtNombreSocio = txtNombreSocio;
	}

	/**
	 * @return the txtEstaturaSocio
	 */
	public JTextField getTxtEstaturaSocio() {
		return txtEstaturaSocio;
	}

	/**
	 * @param txtEstaturaSocio the txtEstaturaSocio to set
	 */
	public void setTxtEstaturaSocio(JTextField txtEstaturaSocio) {
		this.txtEstaturaSocio = txtEstaturaSocio;
	}

	/**
	 * @return the txtEdadSocio
	 */
	public JTextField getTxtEdadSocio() {
		return txtEdadSocio;
	}

	/**
	 * @param txtEdadSocio the txtEdadSocio to set
	 */
	public void setTxtEdadSocio(JTextField txtEdadSocio) {
		this.txtEdadSocio = txtEdadSocio;
	}

	/**
	 * @return the txtLocalidadSocio
	 */
	public JTextField getTxtLocalidadSocio() {
		return txtLocalidadSocio;
	}

	/**
	 * @param txtLocalidadSocio the txtLocalidadSocio to set
	 */
	public void setTxtLocalidadSocio(JTextField txtLocalidadSocio) {
		this.txtLocalidadSocio = txtLocalidadSocio;
	}

	private static AccesoBdatos abd;
	private ResultSet socios;
	private int filas, posicion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscadorSociosLoc window = new BuscadorSociosLoc();
					window.frmBuscasocioslocalidad.setVisible(true);
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
	public BuscadorSociosLoc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscasocioslocalidad = new JFrame();
		frmBuscasocioslocalidad.getContentPane().setBounds(new Rectangle(0, 0, 500, 7000));
		frmBuscasocioslocalidad.setTitle("BuscaSociosLocalidad");
		frmBuscasocioslocalidad.setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\usuario\\Pictures\\Saved Pictures\\Doom_slayer.jpeg"));
		frmBuscasocioslocalidad.getContentPane().setMaximumSize(new Dimension(2147483646, 2147483647));
		frmBuscasocioslocalidad.setBounds(100, 100, 450, 300);
		frmBuscasocioslocalidad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuscasocioslocalidad.getContentPane().setLayout(null);

		JLabel lblIdSocio = new JLabel("IDSocio:");
		lblIdSocio.setBounds(10, 14, 66, 14);
		frmBuscasocioslocalidad.getContentPane().add(lblIdSocio);

		JLabel lblNombresocio = new JLabel("NombreSocio:");
		lblNombresocio.setBounds(10, 46, 66, 14);
		frmBuscasocioslocalidad.getContentPane().add(lblNombresocio);

		JLabel lblEstaturaSocio = new JLabel("Estatura:");
		lblEstaturaSocio.setBounds(10, 77, 66, 14);
		frmBuscasocioslocalidad.getContentPane().add(lblEstaturaSocio);

		JLabel lblEdadSocio = new JLabel("Edad:");
		lblEdadSocio.setBounds(10, 110, 66, 14);
		frmBuscasocioslocalidad.getContentPane().add(lblEdadSocio);

		JLabel lblLocalidadSocio = new JLabel("Localidad:");
		lblLocalidadSocio.setBounds(10, 147, 66, 14);
		frmBuscasocioslocalidad.getContentPane().add(lblLocalidadSocio);

		JLabel lblCm = new JLabel("cm");
		lblCm.setBounds(218, 77, 22, 14);
		frmBuscasocioslocalidad.getContentPane().add(lblCm);

		JLabel lblAnhos = new JLabel("años");
		lblAnhos.setBounds(218, 110, 36, 14);
		frmBuscasocioslocalidad.getContentPane().add(lblAnhos);

		txtBuscaSocio = new JTextField();
		txtBuscaSocio.setToolTipText("Busca socios por la localidad en la que viven");
		txtBuscaSocio.setBounds(243, 18, 164, 20);
		frmBuscasocioslocalidad.getContentPane().add(txtBuscaSocio);
		txtBuscaSocio.setColumns(10);

		JLabel lblTotalSocios = new JLabel("");
		lblTotalSocios.setBounds(101, 207, 183, 14);
		frmBuscasocioslocalidad.getContentPane().add(lblTotalSocios);

		JButton btnBuscaSocio = new JButton("Buscar");
		btnBuscaSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					socios = abd.consultaLocalidad(txtBuscaSocio.getText());
					socios.last();
					filas = socios.getRow();
					if (filas > 0) {
						socios.first();
						posicion = 1;
						txtIdSocio.setText(socios.getString(1));
						txtNombreSocio.setText(socios.getString(2));
						txtEstaturaSocio.setText(socios.getString(3));
						txtEdadSocio.setText(socios.getString(4));
						txtEdadSocio.setText(socios.getString(5));
						lblTotalSocios.setText("Socio 1 de " + filas);
					} else {
						JOptionPane.showMessageDialog(null, "No se han encontrado socios de " + txtBuscaSocio.getText(),
								"Advertencia", JOptionPane.INFORMATION_MESSAGE);
						txtBuscaSocio.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscaSocio.setBounds(276, 59, 89, 23);
		frmBuscasocioslocalidad.getContentPane().add(btnBuscaSocio);

		JButton btnPrevio = new JButton("Anterior");
		btnPrevio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posicion == 1) {
					JOptionPane.showMessageDialog(null, "No hay registros previos", "Advertencia",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					posicion--;
					try {
						socios.absolute(posicion);
						txtIdSocio.setText(socios.getString(1));
						txtNombreSocio.setText(socios.getString(2));
						txtEstaturaSocio.setText(socios.getString(3));
						txtEdadSocio.setText(socios.getString(4));
						txtEdadSocio.setText(socios.getString(5));
						lblTotalSocios.setText("Socio 1 de " + filas);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnPrevio.setEnabled(false);
		btnPrevio.setBounds(56, 227, 89, 23);
		frmBuscasocioslocalidad.getContentPane().add(btnPrevio);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posicion == filas) {
					JOptionPane.showInternalMessageDialog(null, "No existen registros posteriores", "Advertencia",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					posicion++;
					try {
						socios.absolute(posicion);
						txtIdSocio.setText(socios.getString(1));
						txtNombreSocio.setText(socios.getString(2));
						txtEstaturaSocio.setText(socios.getString(3));
						txtEdadSocio.setText(socios.getString(4));
						txtEdadSocio.setText(socios.getString(5));
						lblTotalSocios.setText("Socio 1 de " + filas);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(183, 227, 89, 23);
		frmBuscasocioslocalidad.getContentPane().add(btnSiguiente);

		txtLocalidadSocio = new JTextField();
		txtLocalidadSocio.setBounds(86, 146, 86, 20);
		frmBuscasocioslocalidad.getContentPane().add(txtLocalidadSocio);
		txtLocalidadSocio.setEditable(false);
		txtLocalidadSocio.setColumns(10);

		txtEdadSocio = new JTextField();
		txtEdadSocio.setBounds(86, 102, 86, 20);
		frmBuscasocioslocalidad.getContentPane().add(txtEdadSocio);
		txtEdadSocio.setEditable(false);
		txtEdadSocio.setColumns(10);

		txtEstaturaSocio = new JTextField();
		txtEstaturaSocio.setBounds(86, 71, 86, 20);
		frmBuscasocioslocalidad.getContentPane().add(txtEstaturaSocio);
		txtEstaturaSocio.setEditable(false);
		txtEstaturaSocio.setColumns(10);

		txtNombreSocio = new JTextField();
		txtNombreSocio.setBounds(86, 36, 86, 20);
		frmBuscasocioslocalidad.getContentPane().add(txtNombreSocio);
		txtNombreSocio.setEditable(false);
		txtNombreSocio.setColumns(10);

		txtIdSocio = new JTextField();
		txtIdSocio.setBounds(86, 11, 86, 20);
		frmBuscasocioslocalidad.getContentPane().add(txtIdSocio);
		txtIdSocio.setEditable(false);
		txtIdSocio.setColumns(10);

	}
}
