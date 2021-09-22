package go4code.restoran_menu.service;

import java.util.List;

import go4code.restoran_menu.dto.MenuDto;
import go4code.restoran_menu.model.Menu;

public interface MenuService {

	public List<Menu> findAll();
	
	public Menu findById(Long Id);
	
	public Menu createMenu(MenuDto newMenu, String catName);
	
	public Menu changeMenu(Long Id, MenuDto newMenu, String catName);
	
	public Menu deleteMenu(Long Id);
	
	public List<Menu> findByCategory(String catName);
}
