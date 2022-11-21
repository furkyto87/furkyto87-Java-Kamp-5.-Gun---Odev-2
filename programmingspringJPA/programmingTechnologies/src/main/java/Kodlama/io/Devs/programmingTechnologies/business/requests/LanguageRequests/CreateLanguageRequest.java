package Kodlama.io.Devs.programmingTechnologies.business.requests.LanguageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguageRequest {
	private String languageName;
}