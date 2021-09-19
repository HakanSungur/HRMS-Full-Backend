package hrmsfullBackend.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seeker_languages")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cV"})
public class JobSeekerLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id")
	private int id;
	
	@Column(name="language_degree")
	@Min(1)
	@Max(5)
	@NotNull
	@NotBlank
	private int languageDegree;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="language_id")
	private Language language;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="cv_id")
	private CV cV;
}
