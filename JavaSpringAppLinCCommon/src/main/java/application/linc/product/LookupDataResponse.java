/**
 * 
 */
package application.linc.product;

import java.util.List;

/**
 * @author 258297
 *
 */
public class LookupDataResponse {

	public String status;
	List<ProductCategoryMaster> productCategoryList;
	List<OrgMasterVO> orgMasterList;
	List<StateVO> stateList;
	List<CountryVO> countryList;
	List<StoreMasterVO> storeMasterList;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ProductCategoryMaster> getProductCategoryList() {
		return productCategoryList;
	}

	public void setProductCategoryList(List<ProductCategoryMaster> productCategoryList) {
		this.productCategoryList = productCategoryList;
	}

	public List<OrgMasterVO> getOrgMasterList() {
		return orgMasterList;
	}

	public void setOrgMasterList(List<OrgMasterVO> orgMasterList) {
		this.orgMasterList = orgMasterList;
	}

	public List<StateVO> getStateList() {
		return stateList;
	}

	public void setStateList(List<StateVO> stateList) {
		this.stateList = stateList;
	}

	public List<CountryVO> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<CountryVO> countryList) {
		this.countryList = countryList;
	}

	public List<StoreMasterVO> getStoreMasterList() {
		return storeMasterList;
	}

	public void setStoreMasterList(List<StoreMasterVO> storeMasterList) {
		this.storeMasterList = storeMasterList;
	}
	
	
	
	
	
	
}
