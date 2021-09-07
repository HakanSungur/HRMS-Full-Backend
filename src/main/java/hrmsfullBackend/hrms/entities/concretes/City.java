package hrmsfullBackend.hrms.entities.concretes;
import javax.persistence.*;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
	
	@Id
	@NotNull
	@Column(name="cities")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="city_name")
	@NotNull
	private String cityName;
	
	/*
	 * Bu kısıma ilişkilendirme yapılacak.
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private List<JobAdvert> jobadverts;
	*/

}
