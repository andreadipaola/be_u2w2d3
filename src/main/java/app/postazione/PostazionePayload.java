package app.postazione;

import app.edificio.Edificio;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostazionePayload {
	@NotNull(message = "La descrizione è obbligatoria")
	@Size(min = 3, max = 30, message = "Descrizione min 3 caratteri, massimo 30")
	String descrizione;
	@NotNull(message = "L'indirizzo è obbligatorio")
	Integer maxOccupanti;
	@NotNull(message = "Devi inseirre il massimo numero di occupanti")
	String citta;
	@NotNull(message = "Devi inserire lédifizio di riferimento")
	Edificio edificio;
}
