package go4code.restoran_menu.dto;

import go4code.restoran_menu.model.Category;

public class CategoryDto {

	private Long id;
	private String name;
	
	public CategoryDto() {
		super();
	}

	public CategoryDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public CategoryDto(Category category) {
		super();
		this.id = category.getId();
		this.name = category.getName();
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
	
	
}
