/**
 * 
 */
package mensajes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;



/**
 * @author DAM2Alu2
 *
 */
@Entity
public class Mensaje {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@Size(min = 3)
	@Column(nullable = false)
	private String texto;
	private Date fecha;
	@ManyToOne
	private Autor autor;
	@Version
	private int version;
}
