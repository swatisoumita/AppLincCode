/**
 * 
 */
package application.linc.product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;


/**
 * @author 258297
 *
 */
@Repository
public class ProductDao {


	//private DataSource dataSource;

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/*
	 * @Autowired
	 * 
	 * @Override public void setDataSource(DataSource ds) { this.dataSource = ds;
	 * this.jdbcTemplateObject = new JdbcTemplate(dataSource); }
	 */

//	public LookupDataResponse getLookUpData()
//	{
//		LookupDataResponse lookupDataResponse = new LookupDataResponse();
//		try
//		{
//			List<SqlParameter> paramList = new ArrayList<SqlParameter>();
//			//paramList.add(new SqlParameter(Types.VARCHAR));
//			//paramList.add(new SqlParameter(Types.VARCHAR));
//			paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
//			paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
//			paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));
//	
//			Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {
//	
//				@Override
//				public CallableStatement createCallableStatement(Connection connection)
//						throws SQLException {
//	
//					CallableStatement callableStatement = connection.prepareCall("{call Proc_GetMasterData_R(?, ?, ?)}");
//					//callableStatement.setString(1, "FirstName");
//					//callableStatement.setString(2, " LastName");
//					callableStatement.registerOutParameter(1, Types.NVARCHAR);
//					callableStatement.registerOutParameter(2, Types.INTEGER);
//					callableStatement.registerOutParameter(3, Types.VARCHAR);
//					return callableStatement;
//	
//				}
//			}, paramList);
//	
//			System.out.println("Output -->"+resultMap);
//			String lookUpDataString = (String) resultMap.get("OutputJSON");
//			System.out.println("lookUpDataString -->"+lookUpDataString);
//			Gson gson =new Gson();
//			lookupDataResponse = gson.fromJson(lookUpDataString, LookupDataResponse.class);
//			
//			if(null != lookupDataResponse)
//			{
//				lookupDataResponse.setStatus("SUCCESS");
//			}
//			else					
//			{
//				lookupDataResponse = new LookupDataResponse();
//				lookupDataResponse.setStatus("ERROR");
//			}
//		}
//		catch(Exception ex)
//		{
//			lookupDataResponse = new LookupDataResponse();
//			lookupDataResponse.setStatus("ERROR");
//			ex.printStackTrace();
//		}
//		return lookupDataResponse;
//	}
	
	public String getLookUpData()
	{
		String response = null;
		StringBuffer sbData = new StringBuffer();
		try
		{
			List<SqlParameter> paramList = new ArrayList<SqlParameter>();
			//paramList.add(new SqlParameter(Types.VARCHAR));
			//paramList.add(new SqlParameter(Types.VARCHAR));
			paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
			paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
			paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));
	
			Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {
	
				@Override
				public CallableStatement createCallableStatement(Connection connection)
						throws SQLException {
	
					CallableStatement callableStatement = connection.prepareCall("{call Proc_GetMasterData_R(?, ?, ?)}");
					//callableStatement.setString(1, "FirstName");
					//callableStatement.setString(2, " LastName");
					callableStatement.registerOutParameter(1, Types.NVARCHAR);
					callableStatement.registerOutParameter(2, Types.INTEGER);
					callableStatement.registerOutParameter(3, Types.VARCHAR);
					return callableStatement;
	
				}
			}, paramList);
	
			
			System.out.println("Output -->"+ resultMap);
			response = (String) resultMap.get("OutputJSON");
			System.out.println("lookupResponseString -->"+response);
			Integer errorNoObj = (Integer) resultMap.get("ErrorNo");
			
			if(null != errorNoObj && 0 != errorNoObj.intValue())
			{
				sbData.append("{\"errorNo\":\"");
				sbData.append(errorNoObj);
				sbData.append("\",\"errorMessage\":\"");
				sbData.append((String) resultMap.get("ErrorMessage"));
				sbData.append("\"}");
				response = sbData.toString();
			}
			return response;
		}
		catch(Exception ex)
		{
			sbData.append("BUSINESS ERROR");
			response = sbData.toString();
			ex.printStackTrace();
		}
		return response;
	}

	public String searchStoreOrProduct(String searchRequest) {
		
		
		String response = null;
		StringBuffer sbData = new StringBuffer();
		try
		{
			if(null != searchRequest)
			{
				
				System.out.println("searchRequest-->"+searchRequest);
				List<SqlParameter> paramList = new ArrayList<SqlParameter>();
				//paramList.add(new SqlParameter(Types.VARCHAR));
				//paramList.add(new SqlParameter(Types.VARCHAR));
				paramList.add(new SqlParameter( Types.NVARCHAR));
				paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
				paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
				paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));

				Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {

					@Override
					public CallableStatement createCallableStatement(Connection connection)
							throws SQLException {

						CallableStatement callableStatement = connection.prepareCall("{call Proc_Search_R(?, ?, ?, ?)}");
						callableStatement.setString(1, searchRequest);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.registerOutParameter(3, Types.INTEGER);
						callableStatement.registerOutParameter(4, Types.VARCHAR);
						return callableStatement;

					}
				}, paramList);

				System.out.println("Output -->"+ resultMap);
				response = (String) resultMap.get("OutputJSON");
				System.out.println("loginResponseString -->"+response);
				Integer errorNoObj = (Integer) resultMap.get("ErrorNo");
				
				if(null != errorNoObj && 0 != errorNoObj.intValue())
				{
					sbData.append("{\"errorNo\":\"");
					sbData.append(errorNoObj);
					sbData.append("\",\"errorMessage\":\"");
					sbData.append((String) resultMap.get("ErrorMessage"));
					sbData.append("\"}");
					response = sbData.toString();
				}
				return response;

				
			}
		}
		catch(Exception ex)
		{	
			sbData.append("BUSINESS ERROR");
			response = sbData.toString();
			ex.printStackTrace();
		}
		return response;
	}

	public String saveProductForSupplier(String productSaveRequest) {
		// TODO Auto-generated method stub
		String response = null;
		StringBuffer sbData = new StringBuffer();
		try
		{
			if(null != productSaveRequest)
			{
				
				System.out.println("searchRequest-->"+productSaveRequest);
				List<SqlParameter> paramList = new ArrayList<SqlParameter>();
				//paramList.add(new SqlParameter(Types.VARCHAR));
				//paramList.add(new SqlParameter(Types.VARCHAR));
				paramList.add(new SqlParameter( Types.NVARCHAR));
				paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
				paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
				paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));

				Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {

					@Override
					public CallableStatement createCallableStatement(Connection connection)
							throws SQLException {

						CallableStatement callableStatement = connection.prepareCall("{call Proc_AddProducts_IU(?, ?, ?, ?)}");
						callableStatement.setString(1, productSaveRequest);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.registerOutParameter(3, Types.INTEGER);
						callableStatement.registerOutParameter(4, Types.VARCHAR);
						return callableStatement;

					}
				}, paramList);

				System.out.println("ProductSaveForSupplier Output -->"+ resultMap);
				response = (String) resultMap.get("OutputJSON");
				System.out.println("loginResponseString -->"+response);
				Integer errorNoObj = (Integer) resultMap.get("ErrorNo");
				
				if(null != errorNoObj && 0 != errorNoObj.intValue())
				{
					sbData.append("{\"errorNo\":\"");
					sbData.append(errorNoObj);
					sbData.append("\",\"errorMessage\":\"");
					sbData.append((String) resultMap.get("ErrorMessage"));
					sbData.append("\"}");
					response = sbData.toString();
				}
				

				
			}
		}
		catch(Exception ex)
		{	
			sbData.append("BUSINESS ERROR");
			response = sbData.toString();
			ex.printStackTrace();
		}
		return response;
	}

	public String getProdCategories(String request) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String response = null;
		StringBuffer sbData = new StringBuffer();
		try
		{
			if(null != request)
			{
				
				System.out.println("searchRequest-->"+request);
				List<SqlParameter> paramList = new ArrayList<SqlParameter>();
				//paramList.add(new SqlParameter(Types.VARCHAR));
				//paramList.add(new SqlParameter(Types.VARCHAR));
				paramList.add(new SqlParameter( Types.NVARCHAR));
				paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
				paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
				paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));

				Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {

					@Override
					public CallableStatement createCallableStatement(Connection connection)
							throws SQLException {

						CallableStatement callableStatement = connection.prepareCall("{call Proc_GetPrdctCat_R(?, ?, ?, ?)}");
						callableStatement.setString(1, request);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.registerOutParameter(3, Types.INTEGER);
						callableStatement.registerOutParameter(4, Types.VARCHAR);
						return callableStatement;

					}
				}, paramList);

				System.out.println("ProductSaveForSupplier Output -->"+ resultMap);
				response = (String) resultMap.get("OutputJSON");
				System.out.println("loginResponseString -->"+response);
				Integer errorNoObj = (Integer) resultMap.get("ErrorNo");
				
				if(null != errorNoObj && 0 != errorNoObj.intValue())
				{
					sbData.append("{\"errorNo\":\"");
					sbData.append(errorNoObj);
					sbData.append("\",\"errorMessage\":\"");
					sbData.append((String) resultMap.get("ErrorMessage"));
					sbData.append("\"}");
					response = sbData.toString();
				}
				

				
			}
		}
		catch(Exception ex)
		{	
			sbData.append("BUSINESS ERROR");
			response = sbData.toString();
			ex.printStackTrace();
		}
		return response;
	
	}

	public String saveOrder(String saveOrderRequest) {
		// TODO Auto-generated method stub
		String response = null;
		StringBuffer sbData = new StringBuffer();
		try
		{
			if(null != saveOrderRequest)
			{
				
				System.out.println("saveOrderRequest-->"+saveOrderRequest);
				List<SqlParameter> paramList = new ArrayList<SqlParameter>();
				//paramList.add(new SqlParameter(Types.VARCHAR));
				//paramList.add(new SqlParameter(Types.VARCHAR));
				paramList.add(new SqlParameter( Types.NVARCHAR));
				paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
				paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
				paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));

				Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {

					@Override
					public CallableStatement createCallableStatement(Connection connection)
							throws SQLException {

						CallableStatement callableStatement = connection.prepareCall("{call Proc_SaveOrder_I(?, ?, ?, ?)}");
						callableStatement.setString(1, saveOrderRequest);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.registerOutParameter(3, Types.INTEGER);
						callableStatement.registerOutParameter(4, Types.VARCHAR);
						return callableStatement;

					}
				}, paramList);

				System.out.println("saveOrder Output -->"+ resultMap);
				response = (String) resultMap.get("OutputJSON");
				System.out.println("saveOrderResponse -->"+response);
				Integer errorNoObj = (Integer) resultMap.get("ErrorNo");
				
				if(null != errorNoObj && 0 != errorNoObj.intValue())
				{
					sbData.append("{\"errorNo\":\"");
					sbData.append(errorNoObj);
					sbData.append("\",\"errorMessage\":\"");
					sbData.append((String) resultMap.get("ErrorMessage"));
					sbData.append("\"}");
					response = sbData.toString();
				}
				

				
			}
		}
		catch(Exception ex)
		{	
			sbData.append("BUSINESS ERROR");
			response = sbData.toString();
			ex.printStackTrace();
		}
		return response;
	}

	public String getOrder(String getOrderRequest) {
		// TODO Auto-generated method stub
		String response = null;
		StringBuffer sbData = new StringBuffer();
		try
		{
			if(null != getOrderRequest)
			{
				
				System.out.println("getOrderRequest-->"+getOrderRequest);
				List<SqlParameter> paramList = new ArrayList<SqlParameter>();
				//paramList.add(new SqlParameter(Types.VARCHAR));
				//paramList.add(new SqlParameter(Types.VARCHAR));
				paramList.add(new SqlParameter( Types.NVARCHAR));
				paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
				paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
				paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));

				Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {

					@Override
					public CallableStatement createCallableStatement(Connection connection)
							throws SQLException {

						CallableStatement callableStatement = connection.prepareCall("{call Proc_GetOrderDetails_R(?, ?, ?, ?)}");
						callableStatement.setString(1, getOrderRequest);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.registerOutParameter(3, Types.INTEGER);
						callableStatement.registerOutParameter(4, Types.VARCHAR);
						return callableStatement;

					}
				}, paramList);

				System.out.println("getOrderResponse Output -->"+ resultMap);
				response = (String) resultMap.get("OutputJSON");
				System.out.println("getOrderResponse -->"+response);
				Integer errorNoObj = (Integer) resultMap.get("ErrorNo");
				
				if(null != errorNoObj && 0 != errorNoObj.intValue())
				{
					sbData.append("{\"errorNo\":\"");
					sbData.append(errorNoObj);
					sbData.append("\",\"errorMessage\":\"");
					sbData.append((String) resultMap.get("ErrorMessage"));
					sbData.append("\"}");
					response = sbData.toString();
				}
				

				
			}
		}
		catch(Exception ex)
		{	
			sbData.append("BUSINESS ERROR");
			response = sbData.toString();
			ex.printStackTrace();
		}
		return response;
	}
	
	public String getSupplierList(String supplierListRequest) {
		// TODO Auto-generated method stub
		String response = null;
		StringBuffer sbData = new StringBuffer();
		try
		{
			if(null != supplierListRequest)
			{
				
				System.out.println("supplierListRequest-->"+supplierListRequest);
				List<SqlParameter> paramList = new ArrayList<SqlParameter>();
				//paramList.add(new SqlParameter(Types.VARCHAR));
				//paramList.add(new SqlParameter(Types.VARCHAR));
				paramList.add(new SqlParameter( Types.NVARCHAR));
				paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
				paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
				paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));

				Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {

					@Override
					public CallableStatement createCallableStatement(Connection connection)
							throws SQLException {

						CallableStatement callableStatement = connection.prepareCall("{call Proc_GetSupplierList_R(?, ?, ?, ?)}");
						callableStatement.setString(1, supplierListRequest);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.registerOutParameter(3, Types.INTEGER);
						callableStatement.registerOutParameter(4, Types.VARCHAR);
						return callableStatement;

					}
				}, paramList);

				System.out.println("getSupplierResponse Output -->"+ resultMap);
				response = (String) resultMap.get("OutputJSON");
				System.out.println("getSupplierResponseData -->"+response);
				Integer errorNoObj = (Integer) resultMap.get("ErrorNo");
				
				if(null != errorNoObj && 0 != errorNoObj.intValue())
				{
					sbData.append("{\"errorNo\":\"");
					sbData.append(errorNoObj);
					sbData.append("\",\"errorMessage\":\"");
					sbData.append((String) resultMap.get("ErrorMessage"));
					sbData.append("\"}");
					response = sbData.toString();
				}
				

				
			}
		}
		catch(Exception ex)
		{	
			sbData.append("BUSINESS ERROR");
			response = sbData.toString();
			ex.printStackTrace();
		}
		return response;
	}

	public String getSupplierProducts(String getSuppProdRequest) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String response = null;
				StringBuffer sbData = new StringBuffer();
				try
				{
					if(null != getSuppProdRequest)
					{
						
						System.out.println("getSuppProdRequest-->"+getSuppProdRequest);
						List<SqlParameter> paramList = new ArrayList<SqlParameter>();
						//paramList.add(new SqlParameter(Types.VARCHAR));
						//paramList.add(new SqlParameter(Types.VARCHAR));
						paramList.add(new SqlParameter( Types.NVARCHAR));
						paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
						paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
						paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));

						Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {

							@Override
							public CallableStatement createCallableStatement(Connection connection)
									throws SQLException {

								CallableStatement callableStatement = connection.prepareCall("{call Proc_GetSupplierProducts_R(?, ?, ?, ?)}");
								callableStatement.setString(1, getSuppProdRequest);
								callableStatement.registerOutParameter(2, Types.NVARCHAR);
								callableStatement.registerOutParameter(3, Types.INTEGER);
								callableStatement.registerOutParameter(4, Types.VARCHAR);
								return callableStatement;

							}
						}, paramList);

						System.out.println("getSupplierProdResponse Output -->"+ resultMap);
						response = (String) resultMap.get("OutputJSON");
						System.out.println("getSupplierProdResponse -->"+response);
						Integer errorNoObj = (Integer) resultMap.get("ErrorNo");
						
						if(null != errorNoObj && 0 != errorNoObj.intValue())
						{
							sbData.append("{\"errorNo\":\"");
							sbData.append(errorNoObj);
							sbData.append("\",\"errorMessage\":\"");
							sbData.append((String) resultMap.get("ErrorMessage"));
							sbData.append("\"}");
							response = sbData.toString();
						}
						

						
					}
				}
				catch(Exception ex)
				{	
					sbData.append("BUSINESS ERROR");
					response = sbData.toString();
					ex.printStackTrace();
				}
				return response;
	}

	

}
