package app;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import app.postazione.Postazione;
import app.utente.UtenteService;

@Component
@Order(2)
public class EdificioRunner implements ApplicationRunner {
	@Autowired
	UtenteService utenteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		for (int i = 0; i < 20; i++) {
			try {
				String nome = faker.artist().name();
				String indirizzo = faker.address().fullAddress();
				String citta = faker.address().city();
				Set<Postazione> postazioni = new HashSet<>();
				// Ho usato la privma versione del metodo create per popolare il DB
//				postazioneService.create(postazione);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
