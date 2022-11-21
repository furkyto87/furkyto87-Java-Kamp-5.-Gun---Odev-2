package Kodlama.io.Devs.programmingTechnologies.business.responses.LanguageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguagesResponse {
	private int languageId;
	private String languageName;
}
