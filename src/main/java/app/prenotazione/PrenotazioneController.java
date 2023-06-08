package app.prenotazione;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
	@Autowired
	private PrenotazioneService prenotazioneService;

	// Versione 1
	@GetMapping("")
	public List<Prenotazione> getPrenotazioni() {
		return prenotazioneService.find();
	}

	// Versione 1
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Prenotazione savePrenotazione(@RequestBody @Validated Prenotazione body) {
		return prenotazioneService.create(body);
	}

	// Versione 1
	@GetMapping("/{prenotazioneId}")
	public Prenotazione getPrenotazione(@PathVariable UUID prenotazioneId) throws Exception {
		return prenotazioneService.findById(prenotazioneId);
	}

	// Versione 1
	@PutMapping("/{prenotazioneId}")
	public Prenotazione updatePrenotazione(@PathVariable UUID prenotazioneId, @RequestBody Prenotazione body)
			throws Exception {
		return prenotazioneService.findByIdAndUpdate(prenotazioneId, body);
	}

	// Versione 1
	@DeleteMapping("/{prenotazioneId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePrenotazione(@PathVariable UUID prenotazioneId) {
		prenotazioneService.findByIdAndDelete(prenotazioneId);
	}

}
