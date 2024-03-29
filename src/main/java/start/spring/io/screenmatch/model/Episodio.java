package start.spring.io.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Episodio(@JsonAlias("Title") String titulo,
                      @JsonAlias("Episode") Integer numero,
                      @JsonAlias("imdbRating") String avaliacao,
                      @JsonAlias("Released") String dataLancamento) {
}
