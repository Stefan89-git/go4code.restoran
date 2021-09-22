package go4code.restoran_menu;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import go4code.restoran_menu.model.Category;
import go4code.restoran_menu.model.Menu;
import go4code.restoran_menu.repository.CategoryRepository;
import go4code.restoran_menu.repository.MenuRepository;

@Component
public class TestData {
	
	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
//	@PostConstruct
//	public void init() {
//		
//		Category category1 = new Category("pizza");
//		catRepo.save(category1);
//		
//		Category category2 = new Category("pasta");
//		catRepo.save(category2);
//		
//		Category category3 = new Category("dessert");
//		catRepo.save(category3);
//		
//		Category category4 = new Category("vine");
//		catRepo.save(category4);
//		
//		Category category5 = new Category("coffee");
//		catRepo.save(category5);
//		
//		Menu jelo1 = new Menu("pizaa romana", category1, 5.5);
//		menuRepo.save(jelo1);
//		
//		Menu jelo2 = new Menu("panna cotta", category3, 3.5);
//		menuRepo.save(jelo2);
//		
//		Menu jelo3 = new Menu("pizaa viennese", category1, 6.0);
//		menuRepo.save(jelo3);
//		
//		Menu jelo4 = new Menu("cannelloni al forno", category2, 6.0);
//		menuRepo.save(jelo4);
//		
//		Menu jelo5 = new Menu("tireamisu", category3, 4.0);
//		menuRepo.save(jelo5);
//		
//		Menu jelo6 = new Menu("chianti conte lorenzo sormani(0.175L)", category4, 3.5);
//		menuRepo.save(jelo6);
//		
//		Menu jelo7 = new Menu("chianti conte lorenzo sormani(0.75L)", category4, 10.0);
//		menuRepo.save(jelo7);
//		
//		Menu jelo8 = new Menu("pizaa capricciosa", category1, 5.5);
//		menuRepo.save(jelo8);
//		
//		Menu jelo9 = new Menu("pizaa quattro stagioni", category1, 7.0);
//		menuRepo.save(jelo9);
//		
//		Menu jelo10 = new Menu("cappucciono", category5, 1.5);
//		menuRepo.save(jelo10);
//	}
}