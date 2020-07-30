/**
 * 
 */
package application.linc.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

/**
 * @author 258297
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	/*
	 * @GetMapping("/lookupdata") public LookupDataResponse
	 * getLookupData(@RequestParam String requestType) {
	 * 
	 * return productService.getLookupData();
	 * 
	 * LookupDataResponse response = new LookupDataResponse();
	 * 
	 * response.setStatus("success"); if(null != requestType) {
	 * if("ALL".equalsIgnoreCase(requestType)||"PRODCAT".equalsIgnoreCase(
	 * requestType)) { List<ProductCategoryMaster> productCategoryList =
	 * productService.getProductCategoryMaster();
	 * response.setProductCategoryList(productCategoryList); }
	 * 
	 * if("ALL".equalsIgnoreCase(requestType)||"ORG".equalsIgnoreCase(requestType))
	 * { List<OrgMasterVO> orgMasterList = productService.getOrgMaster();
	 * response.setOrgMasterList(orgMasterList); }
	 * 
	 * if("ALL".equalsIgnoreCase(requestType)||"STATE".equalsIgnoreCase(requestType)
	 * ) { List<StateVO> stateVOList = productService.getState();
	 * response.setStateList(stateVOList); }
	 * 
	 * if("ALL".equalsIgnoreCase(requestType)||"COUNTRY".equalsIgnoreCase(
	 * requestType)) { List<CountryVO> countyVOList = productService.getCountry();
	 * response.setCountryList(countyVOList); }
	 * 
	 * if("ALL".equalsIgnoreCase(requestType)||"STORE".equalsIgnoreCase(requestType)
	 * ) { List<StoreMasterVO> storeVOList = productService.getStore();
	 * response.setStoreMasterList(storeVOList); } }
	 * 
	 * 
	 * return response;
	 * 
	 * }
	 */

	
	@RequestMapping(value = "/lookupdata", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getLookupData(@RequestParam String requestType) {

		return productService.getLookupData();

	}

	//@RequestMapping(value = "/getProdCat", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	@RequestMapping(value = "/getProdCat", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getProdCategories(@RequestBody String prodCatRequest) {
		return productService.getProdCategories(prodCatRequest);

	}

	@RequestMapping(value = "/saveProductForSupplier", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	// @PostMapping("/saveProductForSupplier")
	public String saveProductForSupplier(@RequestBody String productSaveRequest) {
		return productService.saveProductForSupplier(productSaveRequest);

	}

	// @PostMapping("/searchStoreOrProduct")
	@RequestMapping(value = "/searchStoreOrProduct", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String searchStoreOrProduct(@RequestBody String searchRequest) {
		return productService.searchStoreOrProduct(searchRequest);

	}
	
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String saveOrder(@RequestBody String saveOrderRequest) {
		return productService.saveOrder(saveOrderRequest);

	}

	// @PostMapping("/searchStoreOrProduct")
	@RequestMapping(value = "/getOrder", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getOrder(@RequestBody String getOrderRequest) {
		return productService.getOrder(getOrderRequest);

	}
	
	@RequestMapping(value = "/getSupplier", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSupplier(@RequestBody String getSupplierRequest) {
		return productService.getSupplier(getSupplierRequest);

	}
	
	@RequestMapping(value = "/getSupplierProducts", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSupplierProducts(@RequestBody String getSuppProdRequest) {
		return productService.getSupplierProducts(getSuppProdRequest);

	}

}
