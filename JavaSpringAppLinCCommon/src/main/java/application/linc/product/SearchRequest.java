/**
 * 
 */
package application.linc.product;

/**
 * @author 258297
 *
 */
public class SearchRequest {
	
	public String searchText;
	public double lattitude;
	public double longitude;
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public double getLattitude() {
		return lattitude;
	}
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	

}
