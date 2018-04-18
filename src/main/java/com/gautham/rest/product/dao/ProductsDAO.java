/*Spring JPA support for CRUD Operations */

package com.gautham.rest.product.dao;

import org.springframework.data.repository.CrudRepository;

import com.gautham.rest.product.entity.Products;

public interface ProductsDAO  extends CrudRepository<Products, Long>{

}
