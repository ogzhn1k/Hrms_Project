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
@Table(name = "jobExperiences")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exp_id")
	private int expId;
	
	@Column(name = "work_place")
	@NotBlank
	@NotNull
	private String workplace;
	
	@Column(name = "position")
	@NotBlank
	@NotNull
	private String position;
	
	@Column(name = "start_year")
	@NotBlank
	@NotNull
	private int startYear;
	
	@Column(name = "finish_year")
	private int finishYear;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;

}
