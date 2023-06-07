package app.prenotazione;

import java.time.LocalDate;
import java.util.UUID;

import app.postazione.Postazione;
import app.utente.Utente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prenotazione {

	@Id
	@GeneratedValue
	@Column(name = "prenotazione_id")
	private UUID prenotazioneId;

	@Column(name = "data_prenotazione")
	private LocalDate dataPrenotazione;

	@Column(name = "data_scadenza")
	private LocalDate dataScadenza;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "postazione_id")
	private Postazione postazione;

	public Prenotazione(LocalDate dataPrenotazione, LocalDate dataScadenza, Utente utente, Postazione postazione) {
		this.dataPrenotazione = dataPrenotazione;
		this.dataScadenza = dataScadenza;
		this.utente = utente;
		this.postazione = postazione;
	}

}
