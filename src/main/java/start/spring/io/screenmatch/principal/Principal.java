package start.spring.io.screenmatch.principal;


import java.util.ArrayList;
import java.util.Scanner;
import start.spring.io.screenmatch.model.Serie;
import start.spring.io.screenmatch.model.Temporada;
import start.spring.io.screenmatch.service.ConsumoApi;
import start.spring.io.screenmatch.service.ConverteDados;

public class Principal {

private final Scanner LEITURA = new Scanner(System.in);
private final ConsumoApi CONSUMO_API = new ConsumoApi();
private final ConverteDados CONVERTE_DADOS = new ConverteDados();

private final String ENDERECO = "https://www.omdbapi.com/?t=";
private final String API_KEY = "&apikey=f73a26de";
  public void menu() {
    System.out.println("Digite o nome da serie: ");
    var nomeSerie = LEITURA.nextLine();
    var json = CONSUMO_API.obterDados(ENDERECO + nomeSerie.replaceAll(" ", "+") + API_KEY);
    Serie serie = CONVERTE_DADOS.obterDados(json, Serie.class);
    ArrayList<Temporada> temporadas = new ArrayList<>();
    for(int i =1; i<= serie.totalTemporadas(); i++) {
      var jsonTemporada = CONSUMO_API.obterDados(ENDERECO + nomeSerie.replaceAll(" ", "+") + "&season=" + i + API_KEY);
      Temporada temporada = CONVERTE_DADOS.obterDados(jsonTemporada, Temporada.class);
      temporadas.add(temporada);
    }
    temporadas.forEach(System.out::println);
  }
}