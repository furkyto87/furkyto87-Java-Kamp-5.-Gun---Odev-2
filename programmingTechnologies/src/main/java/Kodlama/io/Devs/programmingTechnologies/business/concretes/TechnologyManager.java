package Kodlama.io.Devs.programmingTechnologies.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.programmingTechnologies.business.abstracts.TechnologyService;
import Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.programmingTechnologies.business.responses.TechnologyResponses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.programmingTechnologies.business.responses.TechnologyResponses.GetByIdTechnologiesResponse;
import Kodlama.io.Devs.programmingTechnologies.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.programmingTechnologies.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.programmingTechnologies.entities.concretes.Language;
import Kodlama.io.Devs.programmingTechnologies.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
		this.technologyRepository = technologyRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {

		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> technologiesResponse = new ArrayList<GetAllTechnologiesResponse>();

		for (Technology technology : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setLanguageId(technology.getLanguage().getLanguageId());
			responseItem.setLanguageName(technology.getLanguage().getLanguageName());
			responseItem.setTechnologyId(technology.getTechnologyId());
			responseItem.setTechnologyName(technology.getTechnologyName());
			technologiesResponse.add(responseItem);
		}

		return technologiesResponse;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		List<Technology> technologies = technologyRepository.findAll();
		for (Technology technology : technologies) {
			if (createTechnologyRequest.getTechnologyName().equals(technology.getTechnologyName())) {
				throw new RuntimeException("Programlama dili alt teknolojisi mevcuttur. Tekrar eklenemez");
			}
		}

		if (createTechnologyRequest.getTechnologyName() == "") {
			throw new RuntimeException("Programlama dili alt teknolojisi boş geçilemez");
		}

		Technology technology = new Technology();
		Language language = this.languageRepository.findById(createTechnologyRequest.getLanguageId()).get();
		technology.setTechnologyName(createTechnologyRequest.getTechnologyName());
		technology.setLanguage(language);

		this.technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {

		Technology technology = technologyRepository.findById(deleteTechnologyRequest.getTechnologyId()).get();
		technologyRepository.delete(technology);
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {

		if (updateTechnologyRequest.getTechnologyName().isEmpty()
				|| (updateTechnologyRequest.getTechnologyId() == ' ')) {

			throw new Exception("Programlama dili teknolojisi adı ve id'si boş bırakılamaz !!!");
		}

		for (Technology programmingtechnology : technologyRepository.findAll()) {
			if (updateTechnologyRequest.getTechnologyName().equals(programmingtechnology.getTechnologyName())) {
				throw new Exception("Programlama dili teknolojisi mevcuttur. Tekrar edemez !!!");
			}
		}

		for (Technology programmingtechnology : technologyRepository.findAll()) {
			if (updateTechnologyRequest.getTechnologyId() != programmingtechnology.getTechnologyId()) {
				if (updateTechnologyRequest.getTechnologyName().equals(programmingtechnology.getTechnologyName())) {
					throw new Exception("Programlama dili teknolojisi bulunmamaktadır !!!");
				}
			}
		}
		
		Technology technology = this.technologyRepository.findById(updateTechnologyRequest.getTechnologyId()).get();
		Language language = this.languageRepository.findById(updateTechnologyRequest.getLanguageId()).get();
		technology.setTechnologyName(updateTechnologyRequest.getTechnologyName());
		technology.setLanguage(language);
		this.technologyRepository.save(technology);
	}

	@Override
	public GetByIdTechnologiesResponse getById(int technology_id) throws Exception {
		List<Technology> technologies = this.technologyRepository.findAll();
		GetByIdTechnologiesResponse getByIdTechnologiesResponse = new GetByIdTechnologiesResponse();

		for (Technology technology : technologies) {
			if (technology.getTechnologyId() == technology_id) {
				getByIdTechnologiesResponse.setLanguageId(technology.getLanguage().getLanguageId());
				getByIdTechnologiesResponse.setLanguageName(technology.getLanguage().getLanguageName());
				getByIdTechnologiesResponse.setTechnologyId(technology.getTechnologyId());
				getByIdTechnologiesResponse.setTechnologyName(technology.getTechnologyName());

			}

		}

		return getByIdTechnologiesResponse;
	}

}
