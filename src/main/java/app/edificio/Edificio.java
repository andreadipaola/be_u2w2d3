package app.edificio;

import java.util.Set;
import java.util.UUID;

import app.postazione.Postazione;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "edifici")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Edificio {

	@Id
	@GeneratedValue
	@Column(name = "edificio_id")
	private UUID edificioId;

	private String nome;
	private String indirizzo;
	private String citta;

	@OneToMany(mappedBy = "edificio")
	private Set<Postazione> postazioni;

	public Edificio(String nome, String indirizzo, String citta, Set<Postazione> postazioni) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.postazioni = postazioni;
	}
}