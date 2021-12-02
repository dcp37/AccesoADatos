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
import java.sql.Date;
import javax.swing.JFormattedTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class AplicacionEmpleados {

	private JFrame frmGestinEmpleados;
	private JTextField txtNumEmp;
	private JTextField txtApellido;
	private JTextField txtOficio;
	private JTextField txtSalario;
	private JFormattedTextField txtComision;
	private JLabel lblOficio;
	private JTextField txtFecha;
	private JComboBox<String> CombBoxDirector;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JCalendar calendario;
	private JTextFieldDateEditor txtfechaedit;

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
				Query q = session.createQuery(query);

				// List<Empleados> lista = q.list();
				// Iterator iterator = lista.iterator();

				Iterator<Empleados> iterator = q.iterate();
				while (iterator.hasNext()) {
					Empleados directores = iterator.next();
					CombBoxDirector.addItem(directores.getApellido());
				}
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
				SessionFactory sf = miSessionFactory.getSf();// llama a la clase principal, y después a la
				// creada
				Session sesion = sf.openSession();
				if (e.getSource() != null) {

					String hql = "from Empleados WHERE emp_no = " + txtNumEmp.getText();
					if (txtNumEmp.getText().isEmpty()) {
						txtNumEmp.setText(JOptionPane.showInputDialog("No has introducido un número de empleado"));

					} else {

						Query query = sesion.createQuery(hql);
						Empleados empleado = (Empleados) query.uniqueResult();

						txtOficio.setText(empleado.getOficio());
						txtApellido.setText(empleado.getApellido());
						txtSalario.setText(empleado.getSalario().toString());
						txtComision.setValue(empleado.getComision());
						txtFecha.setText(empleado.getFechaAlt().toString());
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

		JComboBox<String> CombBoxDepartamento = new JComboBox<String>();
		CombBoxDepartamento.setModel(new DefaultComboBoxModel<String>(
				new String[] { "10/CONTABILIDAD", "20/INVESTIGACION", "30/VENTAS", "40/PRODUCCION" }));
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
				SessionFactory sf = miSessionFactory.getSf();
				Session sesion = sf.openSession();
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
					String hql = "FROM Empleados WHERE empno = " + txtNumEmp.getText();
					Query query = sesion.createQuery(hql);
					if (query.uniqueResult() == null) {
						sesion.beginTransaction();

						Departamentos d = new Departamentos(Byte.parseByte("1"), "", "", null);
						Empleados em = new Empleados(Short.parseShort(txtNumEmp.getText()), d, "apellido", "oficio",
								(short) 5, Date.valueOf(txtFecha.getText()), Float.valueOf(txtSalario.getText()),
								Float.valueOf(txtComision.getText()));

						sesion.save(em);
						sesion.beginTransaction().commit();
						JOptionPane.showConfirmDialog(null, "Se ha introducido un nuevo empleado");
					} else {
						JOptionPane.showConfirmDialog(null, "No se ha podido insertar un nuevo empleado");
					}
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

		txtFecha = new JTextField();
		// txtFecha.setEditable(false);
		txtFecha.setBounds(116, 214, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
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
				txtFecha.setText(String.format("%tF", calendario.getDate()));
			}
		});
		calendario.setBounds(237, 204, 318, 209);
		frmGestinEmpleados.getContentPane().add(calendario);
	}
}
