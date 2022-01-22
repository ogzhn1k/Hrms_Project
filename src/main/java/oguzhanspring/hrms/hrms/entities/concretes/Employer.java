package oguzhanspring.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User{
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id")
	private int employerId;*/
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_site")
	private String webSite;
	
	/*@Column(name = "web_domain_mail")
	private String webDomainMail;*/
	
	@Column(name = "tel_number")
	private String telNumber;
	
	/*@Column(name = "password")
	private String password;
	
	@Column(name = "password_again")
	private String passwordAgain;*/

}
