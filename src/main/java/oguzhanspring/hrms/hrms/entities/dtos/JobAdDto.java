package oguzhanspring.hrms.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdDto {
	
	private int advertisementId;
	private String cityName;
	private int minSalary;
	private int maxSalary;
	private int openPositionNumber;
	private Date lastApplication;
    private String jobDescription;
	private String jobName;
	private String companyName;
}
