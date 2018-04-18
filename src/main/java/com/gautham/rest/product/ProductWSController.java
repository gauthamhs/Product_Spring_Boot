/*Spring Controller Class for implemention REST services for create, read, update and delete 
  for Product REST API*/

package com.gautham.rest.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gautham.rest.product.dao.ProductsDAO;
import com.gautham.rest.product.dto.Product;
import com.gautham.rest.product.entity.Products;

@RestController
@RequestMapping("/productservice")
public class ProductWSController {
	
	@Autowired
	ProductsDAO productsDAO;
	
	private com.gautham.rest.product.entity.Products mapDTOtoEntity(Product product) {
		com.gautham.rest.product.entity.Products productEntity = new com.gautham.rest.product.entity.Products();
		productEntity.setCost(product.getCost());
		productEntity.setDescription(product.getDescription());
		productEntity.setId(product.getId());
		productEntity.setName(product.getName());
		return productEntity;
	}
	
	private Product mapEntitytoDTO(com.gautham.rest.product.entity.Products productEntity) {
		Product product = new Product();
		product.setCost(productEntity.getCost());
		product.setDescription(productEntity.getDescription());
		product.setId(productEntity.getId());
		product.setName(productEntity.getName());
		return product;
	}
	
	/* REST POST Operation for creating a product */
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product){
		Products productEntity = mapDTOtoEntity(product);
		productsDAO.save(productEntity);
		
	}
	
    /* REST PUT Operation for updating a product */
	@PutMapping("/products")
	public void updateProduct(@PathVariable Product product) {
		Iterable<Products> productList = productsDAO.findAll();
		for (Products productEntity : productList) {
			if(productEntity.getId()==product.getId()) {
				productEntity.setCost(product.getCost());
				productsDAO.save(productEntity);
			}
		}
	}
	
	/* REST GET Operation for fetching a product */
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		Iterable<Products> productList = productsDAO.findAll();
		for (Products productEntity : productList) {
			if(productEntity.getId()==id) {
				Product product = mapEntitytoDTO(productEntity);
				return product;
			}
		}
			return null;
	}
	
	/* REST DELETE Operation for deleting a product */		
	@DeleteMapping("/products/{id}")
	 public void deleteProduct(@PathVariable("id") Long id) {
		Iterable<Products> productList = productsDAO.findAll();
		for (Products productEntity : productList) {
			if(productEntity.getId()==id) {
				productsDAO.delete(id);
			}
		}
	}

}
