package com.intent.productManagement.OperationImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.intent.productManagement.Model.ProductDetails;
import com.intent.productManagement.Operation.ProductDetailsOperation;
import com.intent.productManagement.Repository.ProductDetailsRepo;
import com.intent.productManagement.Response.Response;
import com.intent.productManagent.view.ProductDetailsView;
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class ProductOperationImpl implements ProductDetailsOperation {
	
	private ProductDetailsRepo productDetailsRepo;
	private RestTemplate restTemplate;
	
	@Autowired
	public ProductOperationImpl(ProductDetailsRepo productDetailsRepo,RestTemplate restTemplate) {
		this.productDetailsRepo=productDetailsRepo;
		this.restTemplate=restTemplate;
	}

	private ProductDetails toModel(ProductDetailsView productDetailsView){
		ProductDetails productDetails=new ProductDetails();
		
		productDetails.setId(productDetailsView.getId());
		productDetails.setName(productDetailsView.getName());
		productDetails.setDescription(productDetailsView.getDescription());
		productDetails.setPrice(productDetailsView.getPrice());
		productDetails.setQuantity(productDetailsView.getQuantity());
		productDetails.setStatus(productDetailsView.getStatus());
		productDetails.setStockAvailabilty(productDetailsView.getStockAvailabilty());
		productDetails.setType(productDetailsView.getType());
		return productDetails;
	}
	private ProductDetailsView fromModel(ProductDetails ProductDetails){
		ProductDetailsView productDetailsView=new ProductDetailsView();
		
		productDetailsView.setId(ProductDetails.getId());
		productDetailsView.setName(ProductDetails.getName());
		productDetailsView.setDescription(ProductDetails.getDescription());
		productDetailsView.setPrice(ProductDetails.getPrice());
		productDetailsView.setQuantity(ProductDetails.getQuantity());
		productDetailsView.setStatus(ProductDetails.getStatus());
		productDetailsView.setStockAvailabilty(ProductDetails.getStockAvailabilty());
		productDetailsView.setType(ProductDetails.getType());
		return productDetailsView;
	}
	
	@Override
	public Response save(ProductDetailsView productDetailsView) {
	
		productDetailsRepo.save(toModel(productDetailsView));	
		return new Response(200, "saved successfully");
	}

	@Override
	public Response getProductList() {
			List<ProductDetailsView> productsDetailsViews=productDetailsRepo.findAll().stream().map(productDetail->fromModel(productDetail)).collect(Collectors.toList());
		return new Response(200, "successfully",productsDetailsViews);
	}
	

}
