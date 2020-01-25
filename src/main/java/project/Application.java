package project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.mandalart.domain.MandalArt;
import project.mandalart.domain.MandalArtRepository;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(MandalArtRepository mandalArtRepository) throws  Exception{

        return (args) -> {
            MandalArt mandalArt = mandalArtRepository.save(
                    MandalArt.builder().build()
            );
            System.out.println(mandalArt.getUuid());
        };
    }
}