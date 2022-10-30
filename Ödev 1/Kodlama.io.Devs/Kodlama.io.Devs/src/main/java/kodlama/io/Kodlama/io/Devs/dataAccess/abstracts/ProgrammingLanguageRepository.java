package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts; //Soyut yapı

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	List<ProgrammingLanguage> getAll(); 
	public ProgrammingLanguage add(ProgrammingLanguage programmingLanguage);
	public void update(ProgrammingLanguage programmingLanguage, int id);
	public void delete(int id);
	public ProgrammingLanguage getById(int id);
}
