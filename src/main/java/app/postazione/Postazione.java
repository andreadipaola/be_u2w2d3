package app.postazione;

import java.util.Set;
import java.util.UUID;

import app.edificio.Edificio;
import app.postazione.enums.TipoPostazione;
import app.prenotazione.Prenotazione;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Postazione {

	@Id
	@GeneratedValue
	@Column(name = "postazione_id")
	private UUID postazioneId;

	private String descrizione;

	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;

	@Column(name = "max_occupanti")
	private int maxOccupanti;

	@ManyToOne
	@JoinColumn(name = "edificio_id")
	private Edificio edificio;

	@OneToMany(mappedBy = "postazione")
	private Set<Prenotazione> prenotazioni;

	public Postazione(String descrizione, TipoPostazione tipo, int maxOccupanti, Edificio edificio,
			Set<Prenotazione> prenotazioni) {
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.maxOccupanti = maxOccupanti;
		this.edificio = edificio;
		this.prenotazioni = prenotazioni;
	}

}
