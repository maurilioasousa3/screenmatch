package start.spring.io.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import start.spring.io.screenmatch.model.Serie;
import start.spring.io.screenmatch.service.ConsumoApi;
import start.spring.io.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=f73a26de");
		ConverteDados conversor = new ConverteDados();
		Serie serie = conversor.obterDados(json, Serie.class);
		System.out.println(serie);
	}

}