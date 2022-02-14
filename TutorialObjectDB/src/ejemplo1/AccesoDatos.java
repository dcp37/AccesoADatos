/**
 * 
 */
package ejemplo1;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.transaction.Transaction;

/**
 * @author David♥
 *
 */
public class AccesoDatos {
	private EntityManagerFactory emf;
	private EntityManager em;

	public void conectar() {
		emf = Persistence.createEntityManagerFactory("db/empleados.odb");
		em = emf.createEntityManager();
	}

	public void desconectar() {
		em.close();
		emf.close();
	}

	/**
	 * @param numDept Busca un departamento entre los existentes
	 * @return devuelve un objeto Departamento con el código buscado
	 */
	public DepartamentosEntity buscaDepartamento(int numDept) {
		return em.find(DepartamentosEntity.class, numDept);
	}

	@SuppressWarnings("deprecation")
	public void imprimeDepartamento(int numDept) {
		DepartamentosEntity de = buscaDepartamento(numDept);
		if (de == null) {
			System.out.println("No existe el departamento " + numDept);
		} else {
			Set<EmpleadosEntity> empleados = de.getEmpleados();
			String datos = "Datos del departamento " + numDept + ": ";
			datos += "Nombre: " + de.getNombre() + " - Localidad: " + de.getLocalidad() + "\n";
			if (empleados.isEmpty())
				datos += "No tiene empleados en este momento";
			else {
				datos += "Lista de empleados" + "\n";
				datos += "*******************";
			}
			for (EmpleadosEntity empleado : empleados) {
				datos += "\nNúmero de empleado: " + empleado.getEmpnoId() + "\n";
				datos += "Nombre: " + empleado.getNombre() + "\n";
				datos += "Oficio: " + empleado.getOficio() + "\n";
				if (empleado.getDirId() == null)
					datos += "Jefe: No tiene" + "\n";
				else
					datos += "Jefe: " + empleado.getDirId().getNombre() + "\n";
				Calendar.getInstance();
				//
				datos += "Año de alta: " + (empleado.getAlta().getYear() + 1900) + "\n";
				// hay que quitar esto...
				datos += "Salario: " + empleado.getSalario() + "\n";
				if (empleado.getComision() == null)
					datos += "Comisión: No tiene" + "\n";
				else {
					datos += "Comisión: " + empleado.getComision() + "\n";
				}
			}
			System.out.println(datos);
		}
	}

	public boolean insertarDepartamento(DepartamentosEntity de) {
		if (buscaDepartamento(de.getDptoId()) != null) {
			return false;
		} else {
			em.getTransaction().begin();
			em.persist(de);
			em.getTransaction().commit();
			return true;
		}
	}

	public boolean modificarDepartamento(DepartamentosEntity de) {
		DepartamentosEntity departamentoBuscado = buscaDepartamento(de.getDptoId());
		if (departamentoBuscado == null) {
			return false;
		} else {
			em.getTransaction().begin();
			departamentoBuscado.setNombre(de.getNombre());
			departamentoBuscado.setLocalidad(de.getLocalidad());
			em.persist(departamentoBuscado);
			em.getTransaction().commit();
			return true;
		}
	}

	/**
	 * @param numDept un número que corresponde al atributo del DepartamentoEntity
	 * @return true si el departamento no es nulo o si no está vacío
	 */
	public boolean borrarDepartamento(int numDept) {

		DepartamentosEntity departamentoBuscado = buscaDepartamento(numDept);
		if (departamentoBuscado == null || !departamentoBuscado.getEmpleados().isEmpty()) {
			return false;
		} else {
			em.getTransaction().begin();
			em.remove(departamentoBuscado);
			em.getTransaction().commit();
			return true;
		}
	}

	public void pruebaJPQL() {

		Query q1 = em.createQuery("SELECT COUNT(d) FROM DepartamentosEntity d");
		System.out.println("Total Departamentos: " + q1.getSingleResult());
		//
		TypedQuery<Long> tq1 = em.createQuery("SELECT COUNT(d) FROM DepartamentosEntity d", Long.class);
		System.out.println("Total Departamentos: " + tq1.getSingleResult());
		//
		TypedQuery<DepartamentosEntity> tq2 = em.createQuery("SELECT d FROM DepartamentosEntity d",
				DepartamentosEntity.class);
		List<DepartamentosEntity> l2 = tq2.getResultList();
		for (DepartamentosEntity r2 : l2) {
			System.out.println("Nombre :  " + r2.getNombre() + ", Localidad: " + r2.getLocalidad());
		}
		//
		TypedQuery<Object[]> tq3 = em.createQuery("SELECT d.nombre, d.localidad FROM DepartamentosEntity  d",
				Object[].class);
		List<Object[]> l3 = tq3.getResultList();
		for (Object[] r3 : l3) {
			System.out.println("Nombre :  " + r3[0] + ", Localidad: " + r3[1]);
		}
		// */
		TypedQuery<Object[]> tq4 = em.createQuery(
				"SELECT d.nombre, d.localidad FROM DepartamentosEntity d" + " WHERE d.dptoId != :n", Object[].class);
		tq4.setParameter("n", 10);
		List<Object[]> l4 = tq4.getResultList();
		for (Object[] r4 : l4) {
			System.out.println("Nombre :  " + r4[0] + ", Localidad: " + r4[1]);
		}
	}

	public void ejer8_1() {
		TypedQuery<EmpleadosEntity> tq = em.createQuery("SELECT e FROM EmpleadosEntity e", EmpleadosEntity.class);
		List<EmpleadosEntity> listaEmpleados = tq.getResultList();
		for (EmpleadosEntity empleado : listaEmpleados) {
			System.out.println(empleado.getNombre() + " -> " + empleado.getAlta() + "--");
		}
		System.out.println();
	}

	public void ejer8_2() {
		String carrera = "Carrera";
		TypedQuery<EmpleadosEntity> typedQuery = em.createQuery("SELECT e FROM EmpleadosEntity e ",
				EmpleadosEntity.class);
		List<EmpleadosEntity> listaEmpleados = typedQuery.getResultList();

		for (EmpleadosEntity empleado : listaEmpleados) {
			if (empleado.getNombre().contains(carrera)) {
				System.out.println(empleado.getNombre() + " -> " + empleado.getAlta() + "--");
			}
		}
	}

	public void ejer8_3() {
		TypedQuery<EmpleadosEntity> tqEmp = em.createQuery("SELECT e FROM EmpleadosEntity e ", EmpleadosEntity.class);
		List<EmpleadosEntity> listaEmpleados = tqEmp.getResultList();
		for (EmpleadosEntity empleados : listaEmpleados) {
			// System.out.println("kk1");
			if (empleados.getOficio().equals("Empleado")) {
				// System.out.println("kk2");
				if (empleados.getDepartamento().getNombre().equals("I+D")) {
					System.out.println(empleados.getNombre() + " " + empleados.getOficio() + " " + " "
							+ empleados.getDepartamento().getNombre());
				}
			}
		}
	}

	public void ejer8_4() {
		TypedQuery<EmpleadosEntity> tqEmp = em.createQuery("SELECT e FROM EmpleadosEntity e WHERE YEAR(e.alta)>=2003",
				EmpleadosEntity.class);
		List<EmpleadosEntity> listaEmpleados = tqEmp.getResultList();
		for (EmpleadosEntity empleados : listaEmpleados) {
			System.out.println(empleados.getNombre() + " " + empleados.getAlta());
		}
	}

	public void ejer8_5() {
		TypedQuery<EmpleadosEntity> tqEmp = em.createQuery(
				"SELECT e FROM EmpleadosEntity e ORDER BY e.departamento.nombre ASC", EmpleadosEntity.class);
		List<EmpleadosEntity> listaEmpleados = tqEmp.getResultList();
		for (EmpleadosEntity empleados : listaEmpleados) {
			System.out.println(empleados.getDepartamento().getNombre() + " " + empleados.getNombre());
		}

	}

	public void ejer8_6() {
		TypedQuery<Object[]> tq = em.createQuery(
				"SELECT d.nombre, count(d.empleados.getEmpnoId()), sum(d.empleados.getSalario()), max(d.empleados.getSalario())"
						+ " FROM DepartamentosEntity d" + " WHERE d.empleados != null",
				Object[].class);
		List<Object[]> lista = tq.getResultList();
		for (Object[] cosa : lista) {
			System.out.println(cosa[0] + " - " + cosa[1] + " - " + cosa[2] + cosa[3]);
		}
	}

	public void ejer8_7() {
		// igual que el anterior pero los departamentos que tengan 5 o más empleados
	}

	public void ejer8_8() {
		// empleados y sus jefes
		TypedQuery<EmpleadosEntity> tqEmp = em.createQuery("SELECT e FROM EmpleadosEntity e ", EmpleadosEntity.class);
		List<EmpleadosEntity> listaEmp = tqEmp.getResultList();
		for (EmpleadosEntity empleado : listaEmp) {
			System.out.println(empleado.getNombre() + " y su jefe es " + empleado.getDirId());
		}
	}

	public void ejer8_9() {
		// Nombre y total de empleados de los departamentos con algún empleado
		TypedQuery<DepartamentosEntity> tqDept = em.createQuery(
				"SELECT d FROM DepartamentosEntity d WHERE d.empleados != null", DepartamentosEntity.class);
		List<DepartamentosEntity> listaDept = tqDept.getResultList();
		for (DepartamentosEntity departamento : listaDept) {
			System.out.println(departamento.getNombre() + " - " + departamento.getEmpleados());
		}
	}

	public void ejer8_10() {
		TypedQuery<Object[]> typedQuery = em
				.createQuery("SELECT d.nombre, COUNT(d.empleados.empnoId) FROM DepartamentosEntity d", Object[].class);
		List<Object[]> lista = typedQuery.getResultList();
		for (Object[] resultado : lista) {
			System.out.println("Nombre :  " + resultado[0] + ", TotalEmpleados: " + resultado[1]);
		}
	}

	public void ejer8_11() {
		TypedQuery<Object[]> tq = em.createQuery(
				"SELECT d.dptoId, d.empleados.nombre, d.empleados.salario FROM DepartamentosEntity AS d ORDER BY d.dptoId DESC, d.empleados.salario ASC",
				Object[].class);
		List<Object[]> lista = tq.getResultList();
		for (Object[] elm : lista) {
			System.out.println(elm[0] + " - " + elm[1] + " - " + elm[2] + " - ");
		}

	}

	public void ejer8_12() {
		TypedQuery<EmpleadosEntity> tq = em.createQuery("SELECT e FROM EmpleadosEntity AS e WHERE e.dirId == null",
				EmpleadosEntity.class);
		List<EmpleadosEntity> lista = tq.getResultList();
		for (EmpleadosEntity empleado : lista) {
			System.out.println(empleado.getEmpnoId() + "-" + empleado.getNombre());
		}
	}

	public void ejer8_13() {
		TypedQuery<EmpleadosEntity> tq = em.createQuery("SELECT e FROM EmpleadosEntity AS e WHERE e.empnoId = 1039",
				EmpleadosEntity.class);
		List<EmpleadosEntity> lista = tq.getResultList();
		for (EmpleadosEntity empleado : lista) {
			System.out.println(empleado.getDepartamento().getDptoId() + " - " + empleado.getDepartamento().getNombre());
		}
	}

	public int incrementarSalario(int cantidad) {
		int filasModificadas;
		Query q = em.createQuery("UPDATE EmpleadosEntity SET salario = salario + " + cantidad);
		EntityTransaction t = em.getTransaction();
		t.begin();
		filasModificadas = q.executeUpdate();
		t.commit();
		return filasModificadas;
	}

	public int incrementarSalarioOficio(String oficio, int cantidad) {
		int filasModificadas;
		em.getTransaction().begin();
		Query q = em.createQuery("UPDATE EmpleadosEntity SET salario = salario + :din WHERE oficio = :ofi");
		q.setParameter("din", cantidad);
		q.setParameter("ofi", oficio);
		filasModificadas = q.executeUpdate();
		em.getTransaction().commit();
		return filasModificadas;
	}

	public int incrementarSalarioDepartamento(int numDept, int cantidad) {
		int filasModificadas;
		Query q = em.createQuery("UPDATE EmpleadosEntity AS e" + " SET salario = salario + " + cantidad
				+ " WHERE e.departamento.getDptoId() = " + numDept);
		EntityTransaction t = em.getTransaction();
		t.begin();
		filasModificadas = q.executeUpdate();
		t.commit();
		return filasModificadas;
	}

	public int borrarEmpleado(int numEmpl) {
		int filasModificadas;
		em.getTransaction().begin();
		Query q = em.createQuery("DELETE FROM EmpleadosEntity WHERE empnoId = :empId");
		q.setParameter("empId", numEmpl);
		filasModificadas = q.executeUpdate();
		em.getTransaction().commit();
		return filasModificadas;
	}
}
