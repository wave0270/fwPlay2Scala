package controllers;

import java.util.ArrayList;
import java.util.List;
import models.AttributeProduct;
import models.Catalog;
import models.Entertaiment;
import models.Product;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class ProductController extends Controller{
	private List<Product> listProduct = new ArrayList<>();
	private List<AttributeProduct> listAtt = new ArrayList<>();
	public Result addProduct(){		
		return ok();
	}
	
	public Result redirectProductPage(){
		System.out.println("done");
		return redirect("");
	}
	//init to showProduct
	public Result showProduct(){
		// model separate
		Entertaiment entertaiment = new Entertaiment(1, "Music", "Music", 1);
		Entertaiment entertaiment1 = new Entertaiment(2, "Music 1 ", "Music",2 );
		Entertaiment entertaiment2 = new Entertaiment(3, "Music 2 ", "Music", 3);
		Entertaiment entertaiment3 = new Entertaiment(4, "Music 3 ", "Music", 4);
		List<Entertaiment> listEntertaiment = new ArrayList<>();
		listEntertaiment.add(entertaiment);listEntertaiment.add(entertaiment1);
		listEntertaiment.add(entertaiment2);listEntertaiment.add(entertaiment3);
		Catalog cat1 = new Catalog(1, "TabA", "Table A");
		Catalog cat2 = new Catalog(2, "ChairA", "Chair A");
		List<Catalog> listCata = new ArrayList<>();
		listCata.add(cat1);listCata.add(cat2);
		AttributeProduct ap1 = new AttributeProduct(1, "Red", "Wood", "New");
		AttributeProduct ap2 = new AttributeProduct(2, "Red", "Iron", "Old");
		List<AttributeProduct> listAp = new ArrayList<>();
		listAp.add(ap1);
		listAp.add(ap2);
		listAtt.addAll(listAp);
		AttributeProduct ap3 = new AttributeProduct(3, "Black", "Air", "New");
		AttributeProduct ap4 = new AttributeProduct(4, "Yellow", "Steel", "Old");
		List<AttributeProduct> listAp1 = new ArrayList<>();		
		listAp1.add(ap3);
		listAp1.add(ap4);
		listAtt.addAll(listAp1);		
		Product prod = new Product(1, "Tab1", "Table", "Table A.1", cat1, listAp);
		Product prod1 = new Product(2, "Chair1", "Chair", "Chair A.1", cat2, listAp1);		
		listProduct.add(prod);
		listProduct.add(prod1);	
		Logger.info("Result=" + prod.codeProd);
		// return value with multiple parameters
		return ok(product.render(listCata,listProduct,listEntertaiment));
	}
	
	//show one Product Selected through href 
	public Result productSelected(Integer prodID){
		for(Product prod : listProduct){
			if(prod.idProd.equals(prodID)){
				return ok(productShow.render(prod));
			}
		}
		return redirect("");
	}
	
	//show one Product Selected and one attribute follow. 
		public Result productSelectedAtt(Integer prodID,Integer attrID){
			Product prodSelected = new Product();
			AttributeProduct ap = new AttributeProduct();
			for(Product prod : listProduct){
				if(prod.idProd.equals(prodID)){
					prodSelected = prod;					
				}
			}
			
			for(AttributeProduct att : listAtt){
				if(att.idAttr.equals(attrID)){
					ap = att;
				}
			}
			return ok(productNattributeShow.render(prodSelected,ap));
			
		}
	
}
