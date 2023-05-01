package ms.restaurant.application.controllers;


import jakarta.validation.Valid;
import ms.restaurant.application.dto.dishDTO.DishDTO;
import ms.restaurant.application.dto.dishDTO.UpdateDishDTO;
import ms.restaurant.application.dto.productDTO.ProductDTO;
import ms.restaurant.application.dto.productDTO.ProductEanDto;
import ms.restaurant.domain.facadeImpl.DishFacadeImpl;
import ms.restaurant.domain.model.IDObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dishes")
public class DishController {
    private final DishFacadeImpl dishFacadeImpl;

    @Autowired
    public DishController(DishFacadeImpl dishFacadeImpl) {this.dishFacadeImpl = dishFacadeImpl;}

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getDish(@PathVariable Long id) {
        return dishFacadeImpl.getDish(id);
    }

    @PostMapping("/add")
    public IDObject addDish(@Valid @RequestBody DishDTO dishDTO) {
        return dishFacadeImpl.add(dishDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDish(@PathVariable Long id) { dishFacadeImpl.delete(id); }

    @PutMapping("/update/{id}")
    public void updateDish(@Valid @RequestBody UpdateDishDTO updateDishDTO, @PathVariable Long id) {
        dishFacadeImpl.update(updateDishDTO, id);
    }

    @PostMapping("/add/product/{id}")
    public void addProductToDish(@Valid @RequestBody ProductDTO productDTO, @PathVariable Long id) {
        dishFacadeImpl.addProductToDish(productDTO, id);
    }

    @DeleteMapping("/delete/product/{dishId}")
    public void deleteProductFromDish(@RequestBody ProductEanDto productEanDTO, @PathVariable Long dishId) {
        dishFacadeImpl.deleteProductFromDish(productEanDTO, dishId);
    }
}
