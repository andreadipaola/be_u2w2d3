package app.edificio;

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
@RequestMapping("/edificio")
public class EdificioController {
	@Autowired
	private EdificioService edificioService;

	// Versione 1
	@GetMapping("")
	public List<Edificio> getEdifici() {
		return edificioService.find();
	}

	// Versione 1
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Edificio saveEdificio(@RequestBody @Validated Edificio body) {
		return edificioService.create(body);
	}

	// Versione 1
	@GetMapping("/{edificioId}")
	public Edificio getEdificio(@PathVariable UUID edificioId) throws Exception {
		return edificioService.findById(edificioId);
	}

	// Versione 1
	@PutMapping("/{edificioId}")
	public Edificio updateEdificio(@PathVariable UUID edificioId, @RequestBody Edificio body) throws Exception {
		return edificioService.findByIdAndUpdate(edificioId, body);
	}

	// Versione 1
	@DeleteMapping("/{edificioId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEdificio(@PathVariable UUID edificioId) {
		edificioService.findByIdAndDelete(edificioId);
	}

}