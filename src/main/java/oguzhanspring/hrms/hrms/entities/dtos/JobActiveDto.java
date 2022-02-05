package oguzhanspring.hrms.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobActiveDto {
	
	private String companyName;
	private String jobName;
	private int openPositionNumber;
	private Date lastApplication;
	private LocalDateTime broadDate;
}
