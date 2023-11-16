package it.bvtech.boot04.model;

import java.util.ArrayList;
import java.util.List;

public class CacheContatti {

	private static List<Contatto> contatti = new ArrayList<>();
	
	static {
		contatti.add(new Contatto("mail@coontatto.it", "Andrea", "Colleoni", "2345467889"));
		contatti.add(new Contatto("mail1@coontatto.it", "Anna", "Rossi", "2345675889"));
		contatti.add(new Contatto("mail2@coontatto.it", "Mario", "Bianchi", "235635889"));
	}
	
	public static List<Contatto> all() {
		return contatti;
	}
}
