package Kodlama.io.Devs.programmingTechnologies.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.programmingTechnologies.business.abstracts.LanguageService;
import Kodlama.io.Devs.programmingTechnologies.business.requests.LanguageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.LanguageRequests.DeleteLanguageRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.LanguageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.programmingTechnologies.business.responses.LanguageResponses.GetAllLanguagesResponse;
import Kodlama.io.Devs.programmingTechnologies.business.responses.LanguageResponses.GetByIdLanguagesResponse;
import Kodlama.io.Devs.programmingTechnologies.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.programmingTechnologies.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();

		for (Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setLanguageId(language.getLanguageId());
			responseItem.setLanguageName(language.getLanguageName());
			languagesResponse.add(responseItem);
		}

		return languagesResponse;

	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {

		Language language = new Language();
		language.setLanguageName(createLanguageRequest.getLanguageName());

		if (language.getLanguageName() == "") {

			throw new RuntimeException("Programlama Dili Boş Geçilemez");
		}

		for (Language programminglanguage : languageRepository.findAll()) {
			if (programminglanguage.getLanguageName().equals(language.getLanguageName())) {

				throw new RuntimeException("Programlama dili mevcuttur. Tekrar eklenemez");
			}

		}

		for (Language programminglanguage : languageRepository.findAll()) {
			if (programminglanguage.getLanguageId() == language.getLanguageId()) {

				throw new RuntimeException("Programlama dili id'si mevcuttur. Tekrar eklenemez");
			}

		}

		this.languageRepository.save(language);
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {

		Language language = languageRepository.findById(deleteLanguageRequest.getLanguageId()).get();
		languageRepository.delete(language);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {

		if (updateLanguageRequest.getLanguageName().isEmpty() || (updateLanguageRequest.getLanguageId() == ' ')) {

			throw new Exception("Programlama dili Adı ve id'si boş bırakılamaz !!!");
		}

		for (Language programminglanguage : languageRepository.findAll()) {
			if (updateLanguageRequest.getLanguageName().equals(programminglanguage.getLanguageName())) {
				throw new Exception("Programlama dili mevcuttur. Tekrar edemez !!!");
			}
		}

		for (Language programminglanguage : languageRepository.findAll()) {
			if (updateLanguageRequest.getLanguageId() != programminglanguage.getLanguageId()) {
				if (updateLanguageRequest.getLanguageName().equals(programminglanguage.getLanguageName())) {
					throw new Exception("Programlama dili bulunmamaktadır !!!");
				}
			}
		}
		
		Language language = languageRepository.findById(updateLanguageRequest.getLanguageId()).get();
		language.setLanguageId(updateLanguageRequest.getLanguageId());
		language.setLanguageName(updateLanguageRequest.getLanguageName());
		this.languageRepository.save(language);
	}

	@Override
	public GetByIdLanguagesResponse getById(int language_id) throws Exception {
		List<Language> languages = this.languageRepository.findAll();
		GetByIdLanguagesResponse getIdResponse = new GetByIdLanguagesResponse();

		for (Language language : languages) {

			if (language.getLanguageId() == language_id) {
				getIdResponse.setLanguageId(language.getLanguageId());
				getIdResponse.setLanguageName(language.getLanguageName());

			}

		}

		return getIdResponse;
	}

}
