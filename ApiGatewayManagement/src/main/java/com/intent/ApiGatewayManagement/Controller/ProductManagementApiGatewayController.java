package com.intent.ApiGatewayManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.intent.ApiGatewayManagement.Response.Response;
import com.intent.ApiGatewayManagement.view.ProductDetailsView;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api/product/management")
public class ProductManagementApiGatewayController {
	
	private RestTemplate restTemplate;
	
	@Autowired
	public ProductManagementApiGatewayController(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	@PostMapping("/save")
	public Response saveProduct(ProductDetailsView productDetailsView) {
	
		return restTemplate.postForObject("http://product-management/product/management/save", productDetailsView, Response.class);
	}

	@GetMapping("/list")
	@HystrixCommand(fallbackMethod = "getFallBackResponse")
	public Response getproductList() {	
		return restTemplate.getForObject("http://product-management/product/management/list", Response.class);
	}
	
	public Response getFallBackResponse() {	
		return new Response(500, "some thing went wrong ");
	}
	
}	
	
	
