package gestionEmpleados;

import java.awt.EventQueue;
import Generado.*;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AplicacionEmpleados {

	private JFrame frmGestinEmpleados;
	private JTextField txtNumEmp;
	private JTextField txtApellido;
	private JTextField txtOficio;
	private JTextField txtSalario;
	private JTextField txtComision;
	private JLabel lblOficio;
	private JTextField txtFecha;
	private JComboBox<String> CombBoxDirector;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnModificar;
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
		frmGestinEmpleados.setTitle("GESTIÓN EMPLEADOS");
		frmGestinEmpleados.setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\dam2alu2\\Pictures\\Saved Pictures\\Doom_guy.jpg"));
		frmGestinEmpleados.setBounds(100, 100, 510, 407);
		frmGestinEmpleados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestinEmpleados.getContentPane().setLayout(null);

		JLabel lblNumEmpleado = new JLabel("N\u00BAEMPLEADO");
		lblNumEmpleado.setBounds(25, 26, 79, 14);
		frmGestinEmpleados.getContentPane().add(lblNumEmpleado);

		txtNumEmp = new JTextField();
		lblNumEmpleado.setLabelFor(txtNumEmp);
		txtNumEmp.setBounds(114, 23, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtNumEmp);
		txtNumEmp.setColumns(10);

		JButton btnBuscarEmpleado = new JButton("Buscar \uD83D\uDD0EEmpleado");
		btnBuscarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() != null) {
					SessionFactory sf = miSessionFactory.getSf();// llama a la clase principal, y después a la
					// creada
					Session sesion = sf.openSession();
					String hql = "from Empleados WHERE emp_no = " + txtNumEmp.getText();
					Query query = sesion.createQuery(hql);
					Empleados empleado = (Empleados) query.uniqueResult();

					txtOficio.setText(empleado.getOficio());
					txtApellido.setText(empleado.getApellido());
					txtSalario.setText(empleado.getSalario().toString());
					txtComision.setText(empleado.getComision().toString());
					txtFecha.setText(empleado.getFechaAlt().toString());

					sesion.close();
					sf.close();

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

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(114, 66, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtApellido);

		lblOficio = new JLabel("OFICIO");
		lblOficio.setBounds(25, 112, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblOficio);

		txtOficio = new JTextField();
		txtOficio.setColumns(10);
		txtOficio.setBounds(114, 109, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtOficio);

		JLabel lblSalario = new JLabel("SALARIO");
		lblSalario.setBounds(25, 163, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblSalario);

		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(114, 160, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtSalario);

		JLabel lblNumEmpleado_4 = new JLabel("COMISION");
		lblNumEmpleado_4.setBounds(25, 227, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblNumEmpleado_4);

		txtComision = new JTextField();
		txtComision.setColumns(10);
		txtComision.setBounds(114, 224, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtComision);

		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(239, 230, 63, 14);
		frmGestinEmpleados.getContentPane().add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(328, 227, 86, 20);
		frmGestinEmpleados.getContentPane().add(txtFecha);

		JComboBox<String> CombBoxDepartamento = new JComboBox<String>();
		CombBoxDepartamento.setModel(new DefaultComboBoxModel<String>(
				new String[] { "10/CONTABILIDAD", "20/INVESTIGACION", "30/VENTAS", "40/PRODUCCION" }));
		CombBoxDepartamento.setToolTipText("Elige un Departamento");
		CombBoxDepartamento.setBounds(290, 92, 176, 20);
		frmGestinEmpleados.getContentPane().add(CombBoxDepartamento);

		CombBoxDirector = new JComboBox<String>();
		// CombBoxDirector.setModel(new DefaultComboBoxModel<String>(new String[] {
		// "kk", "qlo", "pedo" }));
		CombBoxDirector.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				SessionFactory sf = miSessionFactory.getSf();
				Session session = sf.openSession();
				String query = "FROM Empleados e WHERE e.oficio = 'DIRECTOR'";
				Query q = session.createQuery(query);

				// List<Empleados> lista = q.list();
				// Iterator iterator = lista.iterator();

				List<Empleados> lista = q.list();
				Iterator<Empleados> iterator = lista.iterator();
				System.out.println("Número de Directores: " + lista.size());
				while (iterator.hasNext()) {
					Empleados directores = iterator.next();
					String[] apellidosDirectores = new String[] { directores.getApellido() };

					String ListaDirectores[] = new String[apellidosDirectores.length];

					for (int i = 0; i < apellidosDirectores.length; i++) {

						// String apellidoDirector = "*";
						ListaDirectores[i] = apellidosDirectores[i];
						// System.out.println(apellidoDirector);
					} // txtApellido.setText(directores.getApellido());
						// txtOficio.setText(directores.getOficio());
						// txtComision.setText(directores.getComision().toString());// es double
					CombBoxDirector.setModel(new DefaultComboBoxModel<String>(ListaDirectores));

				}
				session.close();
				// System.exit(0);
			}
		});
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
	}
}
