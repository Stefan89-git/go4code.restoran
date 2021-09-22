package go4code.restoran_menu.validation;

public class Validation {

	public static <T> T setIfNotNull(T oldProperty, T newProperty) {
		return newProperty == null ? oldProperty : newProperty;
	}
	
}
