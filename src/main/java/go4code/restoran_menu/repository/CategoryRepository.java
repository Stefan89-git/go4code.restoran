package go4code.restoran_menu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import go4code.restoran_menu.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public Optional<Category> findByName(String name);
	
}
