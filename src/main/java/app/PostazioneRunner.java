package app;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import app.edificio.Edificio;
import app.postazione.enums.TipoPostazione;
import app.prenotazione.Prenotazione;
import app.utente.UtenteService;

@Component
@Order(3)
public class PostazioneRunner implements ApplicationRunner {
	@Autowired
	UtenteService utenteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		for (int i = 0; i < 20; i++) {
			try {
				String descrizione = faker.lorem().sentence();
				TipoPostazione tipo = getRandomEnumValue(TipoPostazione.class);
				Random random = new Random();
				int maxOccupanti = random.nextInt(50 - 20 + 1) + 20;
				Edificio edificio;
				List<Prenotazione> prenotazioni;

				// Ho usato la privma versione del metodo create per popolare il DB
//				postazioneService.create(postazione);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static <T extends Enum<?>> T getRandomEnumValue(Class<T> enumClass) {
		T[] values = enumClass.getEnumConstants();
		Random random = new Random();
		int index = random.nextInt(values.length);
		return values[index];
	}

}