package hrmsfullBackend.hrms.entities.concretes;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@Table(name="cities")
@NoArgsConstructor
public class City {
	
	@Id
	@NotNull
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="city_name")
	@NotNull
	private String cityName;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private List<JobAdvert> jobadverts;
	

}
