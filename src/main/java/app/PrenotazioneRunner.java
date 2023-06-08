package app;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import app.utente.Utente;
import app.utente.UtenteService;

@Component
@Order(1)
public class PrenotazioneRunner implements ApplicationRunner {
	@Autowired
	UtenteService utenteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		for (int i = 0; i < 100; i++) {
			try {

				String nome = faker.name().firstName();
				String cognome = faker.name().lastName();
				String email = faker.internet().emailAddress();
				Utente utente = new Utente(nome, cognome, email);
				// Ho usato la privma versione del metodo create per popolare il DB
//					utenteService.create(utente);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
