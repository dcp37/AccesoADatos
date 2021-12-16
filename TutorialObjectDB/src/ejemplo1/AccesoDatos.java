/**
 * 
 */
package ejemplo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

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
		TypedQuery<EmpleadosEntity> tq = em.createQuery("SELECT e FROM EmpleadosEntity e",
				EmpleadosEntity.class);
		List<EmpleadosEntity> listaEmpleados = tq.getResultList();
		for (EmpleadosEntity empleado : listaEmpleados) {
			System.out.println(empleado.getNombre() + " -> " + empleado.getAlta() + "--");
		}
		System.out.println();
	}
}
