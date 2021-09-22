package go4code.restoran_menu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import go4code.restoran_menu.dto.MenuDto;
import go4code.restoran_menu.model.Category;
import go4code.restoran_menu.model.Menu;
import go4code.restoran_menu.repository.CategoryRepository;
import go4code.restoran_menu.repository.MenuRepository;
import go4code.restoran_menu.validation.Validation;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Override
	public List<Menu> findAll() {
		return (List<Menu>) menuRepo.findAll();
	}

	@Override
	public Menu findById(Long Id) {
		if(!menuRepo.existsById(Id)) {
			return null;
		}
		return menuRepo.findById(Id).get();
	}

	@Override
	public Menu createMenu(MenuDto newMenu, String catName) {
		Optional<Category> optionalCat = catRepo.findByName(catName);
		if(!optionalCat.isPresent()) {
			return null;
		}
		Category category = optionalCat.get();
		Menu menu = new Menu();
		menu.setName(newMenu.getName());
		menu.setCategory(category);
		menu.setPrice(newMenu.getPrice());
		return menuRepo.save(menu);
	}

	@Override
	public Menu changeMenu(Long Id, MenuDto newMenu, String catName) {
		Optional<Menu> optionalMenu = menuRepo.findById(Id);
		if(!optionalMenu.isPresent()) {
			return null;
		}
		Optional<Category> optionalCat = catRepo.findByName(catName);
		if(!optionalCat.isPresent()) {
			return null;
		}
		Category category = optionalCat.get();
		Menu menu = optionalMenu.get();
		menu.setName(Validation.setIfNotNull(menu.getName(), newMenu.getName()));
		menu.setCategory(Validation.setIfNotNull(menu.getCategory(), category));
		if(newMenu.getPrice() != 0.0) {
			menu.setPrice(newMenu.getPrice());
		}
		return menuRepo.save(menu);
	}

	@Override
	public Menu deleteMenu(Long Id) {
		Optional<Menu> optionalMenu = menuRepo.findById(Id);
		if(!optionalMenu.isPresent()) {
			return null;
		}
		Menu menu = optionalMenu.get();
		menuRepo.delete(menu);
		return menu;
	}

	@Override
	public List<Menu> findByCategory(String catName) {
		Optional<Category> optionalCat = catRepo.findByName(catName);
		if(!optionalCat.isPresent()) {
			return null;
		}
		Category category = optionalCat.get();
		List<Menu> menu = menuRepo.findByCategory(category);
		return menu;
	}

}
