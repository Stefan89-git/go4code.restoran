package go4code.restoran_menu.dto;

import go4code.restoran_menu.model.Category;
import go4code.restoran_menu.model.Menu;

public class MenuDto {
	
	private Long id;
	private String name;
	private Category category;
	private double price;
	
	public MenuDto() {
		super();
	}

	public MenuDto(Long id, String name, Category category, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public MenuDto(Menu menu) {
		this.id = menu.getId();
		this.name = menu.getName();
		this.category = menu.getCategory();
		this.price = menu.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
