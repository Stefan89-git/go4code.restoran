package go4code.restoran_menu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import go4code.restoran_menu.controller.util.RestError;
import go4code.restoran_menu.dto.MenuDto;
import go4code.restoran_menu.model.Category;
import go4code.restoran_menu.model.Menu;
import go4code.restoran_menu.repository.CategoryRepository;
import go4code.restoran_menu.repository.MenuRepository;
import go4code.restoran_menu.service.MenuService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/menu/")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@GetMapping
	public ResponseEntity<List<Menu>> findAll(){
		return new ResponseEntity<List<Menu>>(menuService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Menu> optionalMenu = menuRepo.findById(id);
		if(!optionalMenu.isPresent()) {
			return new ResponseEntity<>(new RestError("Menu with id:" + id + " doesn't exist."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(menuService.findById(id), HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> createMenu(@RequestBody MenuDto newMenu, @RequestParam String catName){
		return new ResponseEntity<>(menuService.createMenu(newMenu, catName), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "{id}")
	public ResponseEntity<?> changeMenu(@PathVariable Long id, @RequestBody MenuDto newMenu, 
										@RequestParam(required = false) String catName){
		Optional<Menu> optionalMenu = menuRepo.findById(id);
		if(!optionalMenu.isPresent()) {
			return new ResponseEntity<>(new RestError("Menu with id:" + id + " doesn't exist."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(menuService.changeMenu(id, newMenu, catName), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> deleteMenu(@PathVariable Long id){
		Optional<Menu> optionalMenu = menuRepo.findById(id);
		if(!optionalMenu.isPresent()) {
			return new ResponseEntity<>(new RestError("Menu with id:" + id + " doesn't exist."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(menuService.deleteMenu(id), HttpStatus.ACCEPTED);
	}
	

	@GetMapping(path = "categories")
	public ResponseEntity<List<Category>> getCategories (){
		List<Category> categories = (List<Category>) catRepo.findAll();
		return new ResponseEntity<List<Category>> (categories, HttpStatus.OK);
	}
	
	@GetMapping(path = "bycat")
	public ResponseEntity<List<Menu>> getAllByCat(@RequestParam String catName){
		List<Menu> menuByCat = menuService.findByCategory(catName);
		return new ResponseEntity<List<Menu>> (menuByCat, HttpStatus.OK);
	}
}
