package cat.passerine.sylvia.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cat.passerine.sylvia.model.Food;

public interface FoodRepository extends CrudRepository<Food, Long> {
    List<Food> findByName(String title);
}
