/**
 * 
 */
package mensajes;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/**
 * @author David♥
 *
 */
@Entity
public class Autor {
	@Id
	@GeneratedValue
	Long id;
	private String correo;
	private String nombre;
	@Version
	private int version;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Mensaje> mensajes = new HashSet<Mensaje>();	
	

}
