package com.intent.productManagement.Operation;

import com.intent.productManagement.Response.Response;
import com.intent.productManagent.view.ProductDetailsView;

public interface ProductDetailsOperation {

	Response save(ProductDetailsView productDetailsView);
	Response getProductList();
}
