package app.edificio;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.exceptions.NotFoundException;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository edificioRepo;

	// Versione 1
	public Edificio create(Edificio e) {
		return edificioRepo.save(e);
	}

	// Versione 1
	public List<Edificio> find() {
		return edificioRepo.findAll();
	}

	// Versione 1
	public Edificio findById(UUID id) throws NotFoundException {
		return edificioRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("ATTENZIONE!!! Edificio non trovato!"));
	}

	// Versione 1
	public Edificio findByIdAndUpdate(UUID id, Edificio e) throws NotFoundException {
		Edificio found = this.findById(id);

		found.setEdificioId(id);
		found.setNome(e.getNome());
		found.setIndirizzo(e.getIndirizzo());
		found.setCitta(e.getCitta());
		// NON SO SE E'GIUSTO
		found.setPostazioni(e.getPostazioni());

		return edificioRepo.save(found);
	}

	// Versione 1
	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Edificio found = this.findById(id);
		edificioRepo.delete(found);
	}

}