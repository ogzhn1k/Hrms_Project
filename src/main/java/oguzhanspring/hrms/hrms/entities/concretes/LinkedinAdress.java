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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "linkedinAdresses")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class LinkedinAdress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "linkedin_id")
	private int linkedinId;
	
	@Column(name = "linkedin_adress")
	@NotBlank
	@NotNull
	private String linkedinAdress;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	@NotBlank
	@NotNull
	@JsonIgnore
	private Resume resume;
}
