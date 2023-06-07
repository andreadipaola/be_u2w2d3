package app.prenotazione;

import java.time.LocalDate;
import java.util.UUID;

import app.postazione.Postazione;
import app.utente.Utente;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PrenotazionePayload {
	@NotNull(message = "l'id è obbligatorio")
	UUID idPostazione;
	@NotNull(message = "la postazione è obbligatoria")
	Postazione postazione;
	@NotNull(message = "la data di prenotazione è obbligatoria")
	LocalDate dataPrenotazione;
	@NotNull(message = "l'utente è obbligatorio")
	Utente utente;;
}
