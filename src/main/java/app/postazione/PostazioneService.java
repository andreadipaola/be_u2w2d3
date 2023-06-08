package app.postazione;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.exceptions.NotFoundException;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneRepository postazioneRepo;

	// Versione 1
	public Postazione create(Postazione p) {
		return postazioneRepo.save(p);
	}

	// Versione 1
	public List<Postazione> find() {
		return postazioneRepo.findAll();
	}

	// Versione 1
	public Postazione findById(UUID id) throws NotFoundException {
		return postazioneRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("ATTENZIONE!!! Postazione non trovata!"));
	}

	// Versione 1
	public Postazione findByIdAndUpdate(UUID id, Postazione p) throws NotFoundException {
		Postazione found = this.findById(id);

		found.setPostazioneId(id);
		found.setDescrizione(p.getDescrizione());
		found.setTipo(p.getTipo());
		found.setMaxOccupanti(p.getMaxOccupanti());
		found.setEdificio(p.getEdificio());
		// NON SO SE E'GIUSTO
		found.setPrenotazioni(p.getPrenotazioni());
		return postazioneRepo.save(found);
	}

	// Versione 1
	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Postazione found = this.findById(id);
		postazioneRepo.delete(found);
	}

}