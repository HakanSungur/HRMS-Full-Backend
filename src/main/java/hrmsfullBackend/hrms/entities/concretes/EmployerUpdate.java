package hrmsfullBackend.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employer_updates", uniqueConstraints = {@UniqueConstraint(columnNames = {"company_name"})})
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdate {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@Column(name="company_name")
	@NotNull
	private String companyName;
	
	@Column(name="website")
	@NotNull
	private String website;
	
	@Column(name="phone_number")
	@NotNull
	private String phoneNumber;
	
	@Column(name="email")
	@NotNull
	private String email;
	
	@Column(name="password")
	@NotNull
	private String password;
	
	@Column(name="picture_url")
	private String pictureUrl="https://www.technopat.net/sosyal/eklenti/02d18dda75a869b005522046f5aa245b-jpg.646363/";
}
