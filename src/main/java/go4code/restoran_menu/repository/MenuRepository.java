package go4code.restoran_menu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import go4code.restoran_menu.model.Category;
import go4code.restoran_menu.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	List<Menu> findByCategory(Category category);
}
