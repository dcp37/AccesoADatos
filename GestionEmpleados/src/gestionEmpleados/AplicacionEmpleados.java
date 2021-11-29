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

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.util.Iterator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFormattedTextField;

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
		frmGestinEmpleados.setBounds(100, 100, 510, 407);
		frmGestinEmpleados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestinEmpleados.getContentPane().setLayout(null);

		JLabel lblNumEmpleado = new JLabel("N\u00BAEMPLEADO");
		lblNumEmpleado.setBounds(25, 26, 79, 14);
		frmGestinEmpleados.getContentPane().add(lblNumEmpleado);

		JButton btnBuscarEmpleado = new JButton("Buscar \uD83D\uDD0EEmpleado");
		btnBuscarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() != null) {
					SessionFactory sf = miSessionFactory.getSf();// llama a la clase principal, y después a la
					// creada
					Session sesion = sf.openSession();
					String hql = "from Empleados WHERE emp_no =" + txtNumEmp.getText();
					Query query = sesion.createQuery(hql);
					if (txtNumEmp.getText().isEmpty()) {
						txtApellido.setText("");
						txtOficio.setText("");
						txtSalario.setText("");

						JOptionPane.showMessageDialog(null, e);
						sesion.close();
						sf.close();
					}
					/*
					 * else if (query.getQueryString()!="") {
					 * 
					 * }
					 */
					else {

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
		btnBuscarEmpleado.setBounds(341, 22, 125, 23);

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
		lblNumEmpleado_4.setBounds(291, 202, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblNumEmpleado_4);

		txtComision = new JFormattedTextField();
		txtComision.setColumns(10);
		txtComision.setBounds(380, 199, 86, 20);
		txtComision.setValue(new Double(0.00));
		frmGestinEmpleados.getContentPane().add(txtComision);

		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(25, 217, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblFecha);

		JComboBox<String> CombBoxDepartamento = new JComboBox<String>();
		CombBoxDepartamento.setModel(new DefaultComboBoxModel<String>(
				new String[] { "10/CONTABILIDAD", "20/INVESTIGACION", "30/VENTAS", "40/PRODUCCION" }));
		CombBoxDepartamento.setToolTipText("Elige un Departamento");
		CombBoxDepartamento.setBounds(290, 92, 176, 20);
		frmGestinEmpleados.getContentPane().add(CombBoxDepartamento);

		CombBoxDirector = new JComboBox<String>();
		// CombBoxDirector.setModel(new DefaultComboBoxModel<String>(new String[] {
		// "kk", "qlo", "pedo" }));

		CombBoxDirector.setToolTipText("Elige un director");
		CombBoxDirector.setBounds(290, 137, 176, 20);
		frmGestinEmpleados.getContentPane().add(CombBoxDirector);

		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Session sesion = sessionF.getSf();
			}
		});
		btnInsertar.setBounds(37, 285, 89, 23);
		frmGestinEmpleados.getContentPane().add(btnInsertar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(160, 285, 89, 23);
		frmGestinEmpleados.getContentPane().add(btnEliminar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(292, 285, 113, 23);
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
		// txtFecha.setBounds(116, 214, 86, 20);
		// frmGestinEmpleados.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);

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
		calendario.setBounds(116, 214, 200, 200);
		
		frmGestinEmpleados.getContentPane().add(calendario);

	}
}
