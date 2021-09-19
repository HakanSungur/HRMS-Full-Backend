package hrmsfullBackend.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="educations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cV"}) 
public class Education {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@Column(name="start_date")
	@NotNull
	@NotBlank
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@ManyToOne(cascade =CascadeType.DETACH)
	@JoinColumn(name="cv_id")
	private CV cV;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="school_id")
	private School school;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="deparment_id")
	private Department department;
}
