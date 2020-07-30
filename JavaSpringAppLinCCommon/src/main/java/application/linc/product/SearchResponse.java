/**
 * 
 */
package application.linc.product;

import java.util.List;

/**
 * @author 258297
 *
 */
public class SearchResponse {
	
	public String status;
	public List<ProductDetailsVO> productDetailsList;
	public List<StoreDetailsVO> storeDetailsList;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ProductDetailsVO> getProductDetailsList() {
		return productDetailsList;
	}
	public void setProductDetailsList(List<ProductDetailsVO> productDetailsList) {
		this.productDetailsList = productDetailsList;
	}
	public List<StoreDetailsVO> getStoreDetailsList() {
		return storeDetailsList;
	}
	public void setStoreDetailsList(List<StoreDetailsVO> storeDetailsList) {
		this.storeDetailsList = storeDetailsList;
	}
	
	
	


}
