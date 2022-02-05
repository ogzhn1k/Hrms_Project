package oguzhanspring.hrms.hrms.entities.concretes;

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
@Table(name = "schools")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private int schoolId;
	
	@Column(name = "school_name")
	@NotBlank
	@NotNull
	private String schoolName;
	
	@Column(name = "department")
	@NotBlank
	@NotNull
	private String department;
	
	@Column(name = "in_year")
	@NotBlank
	@NotNull
	private int inYear;
	
	@Column(name = "graduation_year")
	private int graduationYear;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
