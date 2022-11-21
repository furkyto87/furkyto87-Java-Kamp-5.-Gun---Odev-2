package Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTechnologyRequest {
	private int technologyId;
	private int languageId;
	private String technologyName;
}
