package app.prenotazione;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.exceptions.NotFoundException;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepo;

	// Versione 1
	public Prenotazione create(Prenotazione p) {
		return prenotazioneRepo.save(p);
	}

	// Versione 1
	public List<Prenotazione> find() {
		return prenotazioneRepo.findAll();
	}

	// Versione 1
	public Prenotazione findById(UUID id) throws NotFoundException {
		return prenotazioneRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("ATTENZIONE!!! Utente non trovato!"));
	}

	// Versione 1
	public Prenotazione findByIdAndUpdate(UUID id, Prenotazione p) throws NotFoundException {
		Prenotazione found = this.findById(id);

		found.setPrenotazioneId(id);
		found.setDataPrenotazione(p.getDataPrenotazione());
		found.setDataScadenza(p.getDataScadenza());

		// NON SO SE E'GIUSTO
		found.setUtente(p.getUtente());
		found.setPostazione(p.getPostazione());

		return prenotazioneRepo.save(found);
	}

	// Versione 1
	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Prenotazione found = this.findById(id);
		prenotazioneRepo.delete(found);
	}

}
