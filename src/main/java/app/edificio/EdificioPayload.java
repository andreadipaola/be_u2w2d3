package app.edificio;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EdificioPayload {
	@NotNull(message = "Il nome è obbligatorio")
	@Size(min = 3, max = 30, message = "Nome min 3 caratteri, massimo 30")
	String nome;
	@NotNull(message = "L'indirizzo è obbligatorio")
	String indirizzo;
	@NotNull(message = "La città è obbligatoria")
	String citta;
	@NotNull(message = "Devi inserire almeno una postazione")
	String postazioni;
}
