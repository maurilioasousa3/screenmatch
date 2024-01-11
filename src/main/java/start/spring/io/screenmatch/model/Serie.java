package start.spring.io.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

  public record Serie(@JsonAlias("Title") String titulo,
                      @JsonAlias("totalSeasons") Integer totalTemporadas,
                      @JsonAlias("imdbRating") String avaliacao) {

  }