/**
 * 
 */
package application.linc.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 258297
 *
 */
@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public String getLookupData()
	{
		return productDao.getLookUpData();
	}
	
	/*
	 * public LookupDataResponse getLookupData() { LookupDataResponse
	 * lookupDataResponse = productDao.getLookUpData(); return lookupDataResponse; }
	 */
	
	public List<ProductCategoryMaster> getProductCategoryMaster()
	{
		productDao.getLookUpData();
		List<ProductCategoryMaster> productCatMasterList = new ArrayList<ProductCategoryMaster>();
		ProductCategoryMaster productCatMaster = new ProductCategoryMaster();
		productCatMaster.setDispaySeq(1);
		productCatMaster.setProductCategoryId(1);
		productCatMaster.setProductTypeId(1);
		productCatMaster.setProductCategoryCode("FLRATA");
		productCatMaster.setProductCategoryName("Flour | Atta");
		productCatMasterList.add(productCatMaster);
		
		productCatMaster = new ProductCategoryMaster();
		productCatMaster.setDispaySeq(1);
		productCatMaster.setProductCategoryId(2);
		productCatMaster.setProductTypeId(1);
		productCatMaster.setProductCategoryCode("RCCRLS");
		productCatMaster.setProductCategoryName("Rice & Cereals");
		productCatMasterList.add(productCatMaster);
		
		
		return productCatMasterList;
	}
	
	public List<OrgMasterVO> getOrgMaster()
	{
		List<OrgMasterVO> orgMasterList = new ArrayList<OrgMasterVO>();
		OrgMasterVO orgMasterVO = new OrgMasterVO();
		orgMasterVO.setOrgCode("SPNCRS");
		orgMasterVO.setOrgDescription("Spencers Retail Supply Chain & Super Market");
		orgMasterVO.setOrgId(1);
		orgMasterVO.setOrgName("Spencers Retail");
		orgMasterVO.setOrgTypeMasterId(1);
		orgMasterList.add(orgMasterVO);
		
		orgMasterVO = new OrgMasterVO();
		orgMasterVO.setOrgCode("MOREFDM");
		orgMasterVO.setOrgDescription("MORE Super market & Foodmart");
		orgMasterVO.setOrgId(1);
		orgMasterVO.setOrgName("MORE foodmart");
		orgMasterVO.setOrgTypeMasterId(1);
		orgMasterList.add(orgMasterVO);
		
		
		return orgMasterList;
	}
	
	public List<StoreMasterVO> getStore()
	{
		List<StoreMasterVO> storeList = new ArrayList<StoreMasterVO>();
		StoreMasterVO storeVO = new StoreMasterVO();
		storeVO.setOrgId(1);
		storeVO.setStoreId(1);
		storeVO.setStoreCode("SPNCHNPRK");
		storeVO.setStoreName("Spencers Chinar Park");
		storeList.add(storeVO);
		
		storeVO = new StoreMasterVO();
		storeVO.setOrgId(2);
		storeVO.setStoreId(2);
		storeVO.setStoreCode("MOREKLPR");
		storeVO.setStoreName("More Kalikapur");
		storeList.add(storeVO);
		
		
		return storeList;
	}
	
	
	public List<StateVO> getState()
	{
		List<StateVO> stateList = new ArrayList<StateVO>();
		StateVO stateVO = new StateVO();
		stateVO.setStateCode("WB");
		stateVO.setStateName("WestBengal");
		stateList.add(stateVO);
		
		stateVO = new StateVO();
		stateVO.setStateCode("TN");
		stateVO.setStateName("TamilNadu");
		stateList.add(stateVO);
		
		
		return stateList;
	}
	
	public List<CountryVO> getCountry()
	{
		List<CountryVO> countryList = new ArrayList<CountryVO>();
		CountryVO countryVO = new CountryVO();
		countryVO.setCountryCode("IND");
		countryVO.setCountryName("India");
		countryList.add(countryVO);
		
		countryVO = new CountryVO();
		countryVO.setCountryCode("CN");
		countryVO.setCountryName("China");
		countryList.add(countryVO);
		
		
		return countryList;
	}

	/*
	 * public SearchResponse searchStoreOrProduct(SearchRequest searchRequest) { //
	 * TODO Auto-generated method stub
	 * 
	 * SearchResponse response = new SearchResponse();
	 * response.setStatus("success"); return response; }
	 * 
	 * public ProductSaveResponse saveProductForSupplier(ProductSaveRequest
	 * productSaveRequest) { // TODO Auto-generated method stub return null; }
	 * 
	 * 
	 */
	
	public String getProdCategories(String searchRequest) {
		// TODO Auto-generated method stub
		
		
		return productDao.getProdCategories(searchRequest);
	}
	public String searchStoreOrProduct(String searchRequest) {
		// TODO Auto-generated method stub
		
		
		return productDao.searchStoreOrProduct(searchRequest);
	}

	public String saveProductForSupplier(String productSaveRequest) {
		// TODO Auto-generated method stub
		return productDao.saveProductForSupplier(productSaveRequest);
	}

	public String saveOrder(String saveOrderRequest) {
		// TODO Auto-generated method stub
		return productDao.saveOrder(saveOrderRequest);

	}

	public String getOrder(String getOrderRequest) {
		// TODO Auto-generated method stub
		return productDao.getOrder(getOrderRequest);

	}

	public String getSupplier(String getSupplierRequest) {
		// TODO Auto-generated method stub
		return productDao.getSupplierList(getSupplierRequest);
	}

	public String getSupplierProducts(String getSuppProdRequest) {
		// TODO Auto-generated method stub
		return productDao.getSupplierProducts(getSuppProdRequest);
	}
	
	
	

}
