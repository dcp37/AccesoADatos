package gestionEmpleados;

import java.awt.EventQueue;
import Generado.*;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.util.Iterator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFormattedTextField;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.beans.PropertyChangeEvent;

public class AplicacionEmpleados {

	private JFrame frmGestinEmpleados;
	private JTextField txtNumEmp;
	private JTextField txtApellido;
	private JTextField txtOficio;
	private JTextField txtSalario;
	private JFormattedTextField txtComision;
	private JLabel lblOficio;

	private JComboBox<String> CombBoxDirector;
	private JComboBox<String> CombBoxDepartamento;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JCalendar calendario;
	private JTextFieldDateEditor txtfechaedit;
	private Empleados directores;
	private Departamentos departamentos;

	// private static SessionFactory sessionF;
	// private static Session sesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionEmpleados window = new AplicacionEmpleados();
					window.frmGestinEmpleados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicacionEmpleados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestinEmpleados = new JFrame();
		frmGestinEmpleados.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				SessionFactory sf = miSessionFactory.getSf();
				Session session = sf.openSession();
				String query = "FROM Empleados e WHERE e.oficio = 'DIRECTOR'";
				String queryd = "FROM Departamentos";
				Query q = session.createQuery(query);

				// List<Empleados> lista = q.list();
				// Iterator iterator = lista.iterator();

				Iterator<Empleados> iterator = q.iterate();
				while (iterator.hasNext()) {
					directores = iterator.next();
					CombBoxDirector.addItem(directores.getApellido() + "/" + directores.getEmpNo());
				}
				q = session.createQuery(queryd);
				Iterator<Departamentos> iteratord = q.iterate();
				while (iteratord.hasNext()) {
					departamentos = iteratord.next();
					CombBoxDepartamento.addItem(departamentos.getDeptNo() + "/" + departamentos.getDnombre());
				}

				/*
				 * query = "FROM Departamentos "; q = session.createQuery(query); iterator =
				 * q.iterate(); while (iterator.hasNext()) { departamentos = iterator.next();
				 * CombBoxDepartamento.addItem(departamentos.getDeptNo() + "/" +
				 * departamentos.getDnombre()); } sf.close();
				 */
				sf.close();
			}
		});
		frmGestinEmpleados.setTitle("GESTIÓN EMPLEADOS");
		frmGestinEmpleados.setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\dam2alu2\\Pictures\\Saved Pictures\\Doom_guy.jpg"));
		frmGestinEmpleados.setBounds(100, 100, 827, 502);
		frmGestinEmpleados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestinEmpleados.getContentPane().setLayout(null);

		JLabel lblNumEmpleado = new JLabel("N\u00BAEMPLEADO");
		lblNumEmpleado.setBounds(25, 26, 79, 14);
		frmGestinEmpleados.getContentPane().add(lblNumEmpleado);

		JButton btnBuscarEmpleado = new JButton("Buscar \uD83D\uDD0EEmpleado");
		btnBuscarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOficio.setText("");
				txtApellido.setText("");
				txtSalario.setText("");
				txtComision.setValue(0);
				txtfechaedit.setText("");

				if (e.getSource() != null) {
					String hql = "from Empleados as e WHERE e.empNo = " + txtNumEmp.getText();
					String hql2 = "";
					if (txtNumEmp.getText().isEmpty()) {
						txtNumEmp.setText(JOptionPane.showInputDialog("No has introducido un número de empleado"));
					} else {
						SessionFactory sf = miSessionFactory.getSf();// llama a la clase principal, y después a la
						// creada
						Session sesion = sf.openSession();
						Query query = sesion.createQuery(hql);
						Empleados empleado = (Empleados) query.uniqueResult();
						txtOficio.setText(empleado.getOficio());
						txtApellido.setText(empleado.getApellido());
						txtSalario.setText(empleado.getSalario().toString());
						txtComision.setValue(empleado.getComision());
						txtfechaedit.setText(empleado.getFechaAlt().toString());
						sesion.close();
						sf.close();
					}
				}

			}
		});
		btnBuscarEmpleado.setToolTipText("Busca un empleado por su n\u00FAmero");
		btnBuscarEmpleado.setBounds(676, 26, 125, 23);

		frmGestinEmpleados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestinEmpleados.getContentPane().add(btnBuscarEmpleado);

		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(25, 69, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblApellido);

		lblOficio = new JLabel("OFICIO");
		lblOficio.setBounds(25, 112, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblOficio);

		JLabel lblSalario = new JLabel("SALARIO");
		lblSalario.setBounds(25, 163, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblSalario);

		JLabel lblNumEmpleado_4 = new JLabel("COMISION");
		lblNumEmpleado_4.setBounds(626, 206, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblNumEmpleado_4);

		txtComision = new JFormattedTextField();
		txtComision.setColumns(10);
		txtComision.setBounds(715, 203, 86, 20);
		txtComision.setValue(new Double(0.00));
		frmGestinEmpleados.getContentPane().add(txtComision);

		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(25, 217, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblFecha);

		CombBoxDepartamento = new JComboBox<String>();
		/*
		 * CombBoxDepartamento.setModel(new DefaultComboBoxModel<String>( new String[] {
		 * "10/CONTABILIDAD", "20/INVESTIGACION", "30/VENTAS", "40/PRODUCCION" }));
		 */
		CombBoxDepartamento.setToolTipText("Elige un Departamento");
		CombBoxDepartamento.setBounds(625, 96, 176, 20);
		frmGestinEmpleados.getContentPane().add(CombBoxDepartamento);

		CombBoxDirector = new JComboBox<String>();
		// CombBoxDirector.setModel(new DefaultComboBoxModel<String>(new String[] {
		// "kk", "qlo", "pedo" }));

		CombBoxDirector.setToolTipText("Elige un director");
		CombBoxDirector.setBounds(625, 141, 176, 20);
		frmGestinEmpleados.getContentPane().add(CombBoxDirector);

		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					SessionFactory sf = miSessionFactory.getSf();
					System.out.println("SessionFactory echo");
					Session sesion = sf.openSession();
					System.out.println("Session echo");
					Transaction tx = sesion.beginTransaction();
					System.out.println("Transaction echo");

					short numEmp = Short.valueOf(txtNumEmp.getText());
					Departamentos d = departamentos;
					String apellEmp = txtApellido.getText();
					String ofiEmp = txtOficio.getText();
					short dirEmp = directores.getEmpNo();
					String fechaEmp = txtfechaedit.getText();
					Float salEmp = Float.valueOf(txtSalario.getText());
					Float comEmp = Float.valueOf(txtComision.getText());
					System.out.println("Inserción de datos echo");

					// comprobar si ya existe el número empleado
					if (txtNumEmp.getText().isEmpty()) {
						txtNumEmp.setText(JOptionPane.showInputDialog("No has introducido un número de empleado"));
					} else if (txtApellido.getText().isEmpty()) {
						txtApellido.setText(JOptionPane.showInputDialog("No has introducido un Apellido"));
					} else if (txtOficio.getText().isEmpty()) {
						txtOficio.setText(JOptionPane.showInputDialog("No has introducido un oficio"));
					} else if (txtSalario.getText().isEmpty()) {
						txtSalario.setText(JOptionPane.showInputDialog("No has introducido un salario"));
					} else {
						Empleados em = new Empleados(numEmp, d, apellEmp, ofiEmp, dirEmp, Date.valueOf(fechaEmp),
								salEmp, comEmp);
						sesion.save(em);
						tx.commit();
						/*
						 * Departamentos d = new Departamentos(Byte.parseByte("1"), "", "", null);
						 * Empleados em = new Empleados(Short.parseShort(txtNumEmp.getText()), d,
						 * "apellido", "oficio", (short) 5, Date.valueOf(txtfechaedit.getText()),
						 * Float.valueOf(txtSalario.getText()), Float.valueOf(txtComision.getText()));
						 */

						JOptionPane.showConfirmDialog(null, "Se ha introducido un nuevo empleado");
						tx.commit();
						sesion.close();
						JOptionPane.showConfirmDialog(null, "No se ha podido insertar un nuevo empleado");

					}
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		});
		btnInsertar.setBounds(10, 424, 248, 27);
		frmGestinEmpleados.getContentPane().add(btnInsertar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(283, 422, 248, 30);
		frmGestinEmpleados.getContentPane().add(btnEliminar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(553, 422, 248, 30);
		frmGestinEmpleados.getContentPane().add(btnModificar);

		txtOficio = new JTextField();
		txtOficio.setBounds(116, 109, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtOficio);
		txtOficio.setColumns(10);

		txtSalario = new JTextField();
		txtSalario.setBounds(116, 160, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtSalario);
		txtSalario.setColumns(10);

		txtfechaedit = new JTextFieldDateEditor();
		txtfechaedit.setBounds(116, 244, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtfechaedit);
		txtfechaedit.setColumns(10);
		txtfechaedit.setDateFormatString("yyyy-MM-dd");

		txtApellido = new JTextField();
		txtApellido.setBounds(116, 66, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		txtNumEmp = new JTextField();
		txtNumEmp.setBounds(116, 23, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtNumEmp);
		lblNumEmpleado.setLabelFor(txtNumEmp);
		txtNumEmp.setColumns(10);

		calendario = new JCalendar();
		calendario.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				txtfechaedit.setText(String.format("%tF", calendario.getDate()));
			}
		});
		calendario.setBounds(237, 204, 318, 209);
		frmGestinEmpleados.getContentPane().add(calendario);
	}
}
