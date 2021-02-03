package com.intent.productManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intent.productManagement.Operation.ProductDetailsOperation;
import com.intent.productManagement.Response.Response;
import com.intent.productManagent.view.ProductDetailsView;



@RestController
@RequestMapping("/product/management")
public class ProductManagementController {
	
	private ProductDetailsOperation productDetailsOperation;
	
	@Autowired
	public ProductManagementController(ProductDetailsOperation productDetailsOperation) {
		this.productDetailsOperation=productDetailsOperation;
	
	}
	@PostMapping("/save")
	public Response saveProduct(@RequestBody ProductDetailsView productDetailsView) {	
		return productDetailsOperation.save(productDetailsView);
}
	
	@GetMapping("/list")
	public Response getproductList() {	
		return productDetailsOperation.getProductList();
}

}
