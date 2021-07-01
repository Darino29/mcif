package model;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		Database db = new Database();

		Produit prod = new Produit("'fory'", 1.52 , "'minono ftsn zany'" );
		System.out.println(prod.createTable());
		db.addProduit(prod);
		db.updateProduit(prod,"'makorelina'");
		List<Produit> prods = db.getAllProd();
		for (Produit vt : prods) {
			System.out.println(vt.toString());
		}
	}
	
	
	

}
