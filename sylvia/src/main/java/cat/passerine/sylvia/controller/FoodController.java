package cat.passerine.sylvia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cat.passerine.sylvia.handler.FoodIdMismatchException;
import cat.passerine.sylvia.handler.FoodNotFoundException;
import cat.passerine.sylvia.model.Food;
import cat.passerine.sylvia.repo.FoodRepository;

@RestController
@RequestMapping("/api/food")
public class FoodController {

	@Autowired
	private FoodRepository foodRepository;
	
    @GetMapping
    public Iterable findAll() {
        return foodRepository.findAll();
    }
 
    @GetMapping("/title/{foodName}")
    public List findByTitle(@PathVariable String foodName) {
        return foodRepository.findByName(foodName);
    }
 
    @GetMapping("/{id}")
    public Food findOne(@PathVariable Long id) {
        return foodRepository.findById(id)
          .orElseThrow(FoodNotFoundException::new);
    }
 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Food create(@RequestBody Food food) {
        return foodRepository.save(food);
    }
 
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	foodRepository.findById(id)
          .orElseThrow(FoodNotFoundException::new);
        foodRepository.deleteById(id);
    }
 
    @PutMapping("/{id}")
    public Food updateFood(@RequestBody Food food, @PathVariable Long id) {
        if (food.getId() != id) {
          throw new FoodIdMismatchException();
        }
        foodRepository.findById(id)
          .orElseThrow(FoodNotFoundException::new);
        return foodRepository.save(food);
    }
	
	
}
