package oguzhanspring.hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name = "seekers")
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Seeker extends User{
	

	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;
	
	@Column(name = "surname")
	@NotBlank
	@NotNull
	private String surname;
	
	@Column(name = "tc_number")
	@NotBlank
	@NotNull
	private String tcid;
	
	@Column(name = "birth_year")
	@NotBlank
	@NotNull
	private int birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "seeker",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Resume> resumes;
}
