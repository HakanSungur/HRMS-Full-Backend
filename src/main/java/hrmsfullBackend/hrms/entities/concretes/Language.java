package hrmsfullBackend.hrms.entities.concretes;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="languages")
@AllArgsConstructor
@NoArgsConstructor

public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id")
	private int id;
	
	@Column(name="language_name")
	private String languageName;

	@JsonIgnore
	@OneToMany(mappedBy = "language",cascade = CascadeType.DETACH)
	private List<JobSeeker> jobSeekers;
	
}
