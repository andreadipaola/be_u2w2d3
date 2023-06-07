package app.utente;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.exceptions.NotFoundException;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepo;

	// Versione 1
	public Utente create(Utente u) {
		return utenteRepo.save(u);
	}

	// Versione 1
	public List<Utente> find() {
		return utenteRepo.findAll();
	}

	public void insert(Utente u) {
		try {
			utenteRepo.save(u);
			System.out.println("Utente creato con successo");
		} catch (Exception ex) {
			System.out.println("ATTENZIONE!!!  C'è stato un errore durante la creazione dell'utente");
		}
	}

//	public Utente create(UtentePayload u) {
//		utenteRepo.findByEmail(u.getEmail()).ifPresent(user -> {
//			throw new BadRequestException(
//					"ATTENZIONE!!! L'email con la quale stai cercando di registarti è già in uso da un altro utente");
//		});
//		Utente newUser = new Utente(u.geNome(), u.getCognome(), u.getEmail());
//		return utenteRepo.save(newUser);
//	}

	// Versione 1
	public Utente findById(UUID id) throws NotFoundException {
		return utenteRepo.findById(id).orElseThrow(() -> new NotFoundException("ATTENZIONE!!! Utente non trovato!"));
	}

	// Versione 1
	public Utente findByIdAndUpdate(UUID id, Utente u) throws NotFoundException {
		Utente found = this.findById(id);

		found.setUtenteId(id);
		found.setNome(u.getNome());
		found.setCognome(u.getCognome());
		found.setEmail(u.getEmail());

		return utenteRepo.save(found);
	}

	// Versione 1
	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Utente found = this.findById(id);
		utenteRepo.delete(found);
	}

//	public Page<Utente> find(int page, int size, String sortBy) {
//		if (size < 0)
//			size = 10;
//		if (size > 100)
//			size = 100;
//		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//
//		return utenteRepo.findAll(pageable);
//	}

}
