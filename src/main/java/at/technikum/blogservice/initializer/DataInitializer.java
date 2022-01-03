package at.technikum.blogservice.initializer;

import at.technikum.blogservice.model.Author;
import at.technikum.blogservice.model.Sight;
import at.technikum.blogservice.repository.AuthorRepository;
import at.technikum.blogservice.repository.SightRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public record DataInitializer(AuthorRepository authorRepository,
                              SightRepository sightRepository) {

  public void initialize() {
    sightRepository.saveAll(createSights());
    authorRepository.saveAll(createAuthors());
  }

  private static List<Sight> createSights() {
    return List.of(
      Sight.builder().name("Stephansdom").location("Wien").build(),
      Sight.builder().name("Schönbrunn").location("Wien").build(),
      Sight.builder().name("Hofburg").location("Wien").build(),
      Sight.builder().name("Schloss Belvedere").location("Wien").build(),
      Sight.builder().name("Festung Salzburg").location("Salzburg").build(),
      Sight.builder().name("Halstatt").location("Halstatt").build()
    );
  }

  private static List<Author> createAuthors() {
    return List.of(
      Author.builder().firstName("Max").lastName("Mustermann").build(),
      Author.builder().firstName("Hans").lastName("Huber").build(),
      Author.builder().firstName("Gerhard").lastName("Müller").build(),
      Author.builder().firstName("Andreas").lastName("Schuster").build()
    );
  }
}
