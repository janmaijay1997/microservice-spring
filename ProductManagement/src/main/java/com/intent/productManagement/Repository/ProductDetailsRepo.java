package com.intent.productManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intent.productManagement.Model.ProductDetails;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetails,Long>{

	
}
