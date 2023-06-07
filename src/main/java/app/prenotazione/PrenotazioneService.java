package app.prenotazione;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import app.exceptions.BadRequestException;
import app.exceptions.NotFoundException;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepo;

	public void insert(Prenotazione p) {
		try {
			prenotazioneRepo.save(p);
			System.out.println("Prenotazione creata con successo");
		} catch (Exception ex) {
			System.out.println("ATTENZIONE!!!  C'è stato un errore durante la creazione della prenotazione");
		}
	}

	public Prenotazione create(PrenotazionePayload p) {
		prenotazioneRepo.findById(p.getIdPostazione().toString(postazione -> {
			throw new BadRequestException(
					"ATTENZIONE!!! L'email con la quale stai cercando di registarti è già in uso da un altro utente");
		});
		Prenotazione newPrenotazione = new Prenotazione(p.getPostazione(), p.getDataPrenotazione(), p.getUtente());
		return prenotazioneRepo.save(newPrenotazione);
	}

	public Prenotazione findById(UUID id) throws NotFoundException {
		return prenotazioneRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("ATTENZIONE!!! Prenotazione non trovato!"));
	}

	public Prenotazione findByIdAndUpdate(UUID id, Prenotazione p) throws NotFoundException {
		Prenotazione found = this.findById(id);

		found.setPrenotazioneId(id);
		found.setPostazione(p.getPostazione());
		found.setDataPrenotazione(p.getDataPrenotazione());
		found.setDataScadenza(p.getDataScadenza());
		found.setUtente(p.getUtente());

		return prenotazioneRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Prenotazione found = this.findById(id);
		prenotazioneRepo.delete(found);
	}

	public Page<Prenotazione> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return prenotazioneRepo.findAll(pageable);
	}

}
