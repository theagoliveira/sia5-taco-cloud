package tacos;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.security.crypto.password.PasswordEncoder;

import tacos.Ingredient.Type;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;
import tacos.data.UserRepository;
import tacos.web.api.TacoEntityModel;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository,
                                        UserRepository userRepository,
                                        PasswordEncoder passwordEncoder,
                                        TacoRepository tacoRepository) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
                Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);
                Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
                Ingredient carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);
                Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
                Ingredient lettuce = new Ingredient("LETC", "Lettuce", Type.VEGGIES);
                Ingredient cheddar = new Ingredient("CHED", "Cheddar", Type.CHEESE);
                Ingredient jack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);
                Ingredient salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
                Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);

                ingredientRepository.save(flourTortilla);
                ingredientRepository.save(cornTortilla);
                ingredientRepository.save(groundBeef);
                ingredientRepository.save(carnitas);
                ingredientRepository.save(tomatoes);
                ingredientRepository.save(lettuce);
                ingredientRepository.save(cheddar);
                ingredientRepository.save(jack);
                ingredientRepository.save(salsa);
                ingredientRepository.save(sourCream);

                userRepository.save(
                    new User(
                            "thiago",
                            passwordEncoder.encode("1234"),
                            "Thiago",
                            "Rua X",
                            "Cidade Y",
                            "AL",
                            "12345678",
                            "999999999"
                    )
                );

                Taco taco1 = new Taco();
                taco1.setName("Carnivore");
                taco1.setIngredients(
                    Arrays.asList(flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar)
                );
                tacoRepository.save(taco1);

                Taco taco2 = new Taco();
                taco2.setName("Bovine Bounty");
                taco2.setIngredients(
                    Arrays.asList(cornTortilla, groundBeef, cheddar, jack, sourCream)
                );
                tacoRepository.save(taco2);

                Taco taco3 = new Taco();
                taco3.setName("Veg-Out");
                taco3.setIngredients(
                    Arrays.asList(flourTortilla, cornTortilla, tomatoes, lettuce, salsa)
                );
                tacoRepository.save(taco3);
            }

        };
    }

    @Bean
    public RepresentationModelProcessor<PagedModel<TacoEntityModel>> tacoProcessor(EntityLinks links) {
        return new RepresentationModelProcessor<PagedModel<TacoEntityModel>>() {

            @Override
            public PagedModel<TacoEntityModel> process(PagedModel<TacoEntityModel> model) {
                model.add(links.linkFor(Taco.class).slash("recent").withRel("recents"));
                return model;
            }

        };
    }

}
