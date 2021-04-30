package tacos.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import tacos.Ingredient;

public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, String> {
}
