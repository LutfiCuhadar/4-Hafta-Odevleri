package kodlama.io.Kodlama.io.Devs.Bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.Bussiness.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service //bu sınıf bir business nesnesidir.(bunu anlatır bu yapı)
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() { 
		 //iş kuralları
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage add(ProgrammingLanguage programmingLanguage) throws Exception {
		if(isIdExist(programmingLanguage.getId())) throw new Exception("Programlama dilinin ID'si tekrar edemez");
		if(isNameExist(programmingLanguage)) throw new Exception("Aynı programlama dili tekrar edemez");
		return programmingLanguageRepository.add(programmingLanguage);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage, int id) throws Exception {
		if(!isIdExist(programmingLanguage.getId())) throw new Exception("Böyle bir ID bulunmamaktadır");
		if(isNameExist(programmingLanguage)) throw new Exception("Aynı programlama dili tekrar edemez");
		programmingLanguageRepository.update(programmingLanguage, id);
	}

	@Override
	public void delete(int id) throws Exception {
		if(!isIdExist(id)) throw new Exception("Böyle bir ID bulunmamaktadır");
		programmingLanguageRepository.delete(id);
		
	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		if(!isIdExist(id)) throw new Exception("Böyle bir ID bulunmamaktadır");
		programmingLanguageRepository.getById(id);
		return null;
	}
	
	private boolean isNameExist(ProgrammingLanguage programmingLanguage) {
		for(ProgrammingLanguage programmingLanguage2: getAll()) {
			if(programmingLanguage.getLanguageName().equals(programmingLanguage2.getLanguageName())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isIdExist(int id) {
		for(ProgrammingLanguage language : getAll()) {
			if(language.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	

}
