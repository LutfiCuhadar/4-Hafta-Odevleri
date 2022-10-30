package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository //bu sınıf bir dataAccess nesnesidir. (Bunu anlatır bu yapı)
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> languages;
	
	public InMemoryProgrammingLanguageRepository() {
		languages = new ArrayList<ProgrammingLanguage>(); 
		languages.add(new ProgrammingLanguage(1, "Java"));
		languages.add(new ProgrammingLanguage(2, "C#"));
		languages.add(new ProgrammingLanguage(3, "Python"));
	}


	@Override
	public List<ProgrammingLanguage> getAll() {
		return languages;
	}


	@Override
	public ProgrammingLanguage add(ProgrammingLanguage programmingLanguage) {
		languages.add(programmingLanguage); //üstteki return'ün değeri(languages)
		return getById(programmingLanguage.getId());
	}


	@Override
	public void update(ProgrammingLanguage programmingLanguage, int id) {
		ProgrammingLanguage programmingLanguageToUpdate = getById(id);
		programmingLanguageToUpdate.setLanguageName(programmingLanguage.getLanguageName());
	}


	@Override
	public void delete(int id) {
		languages.remove(id);
		
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		return languages.stream().filter(p -> p.getId() == id).findFirst().get();
	}

}
