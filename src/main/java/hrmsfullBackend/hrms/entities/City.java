package hrmsfullBackend.hrms.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
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
