package hrmsfullBackend.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobadverts")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "favorites"})
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;
	
	@Column(name="description")
	@NotNull
	private String description;

	@Column(name="salary")
	@NotNull
	private int salary;
	
	@Column(name="position_count")
	@NotNull
	private int positionCount;
	
	@Column(name="dead_line")
	@NotNull
	private LocalDate deadLine;
	
	@Column(name="airtime")
	@NotNull
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	//Burada oto artıyor sonra tekrar bak. Araştır.
	private LocalDateTime airDate=LocalDateTime.now();
	
	@Column(name="up_time")
	@NotNull
	private String upTime;
	
	@Column(name="type_of_employment")
	@NotNull
	private String typeOfEmployment;
	
	@Column(name="is_active")
	@NotNull
	private boolean isActive=true;
	
	@Column(name="is_confirmed")
	@NotNull
	private boolean isConfirmed=false;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToMany(mappedBy = "jobAdvert", cascade = CascadeType.DETACH)
	private List<Favorite> favorites;
	
}
