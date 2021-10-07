package hrmsfullBackend.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseekers", uniqueConstraints = {@UniqueConstraint(columnNames = {"identity_number"})})
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cV", "favorites"})
public class JobSeeker extends User {

	@Column(name="first_name")
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	private String lastName;
	
	@Column(name="identitiy_number")
	@NotNull
	private String identityNumber;
	
	@Column(name="birth_date")
	@NotNull
	private LocalDate birthDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker",cascade = CascadeType.DETACH)
	private List<CV> cVs;
	
	@OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
	private List<Favorite> favorites;
}
