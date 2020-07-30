
/**
 * 
 */
package application.linc.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class UserDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/*
	 * @Autowired
	 * 
	 * @Override public void setDataSource(DataSource ds) { this.dataSource = ds;
	 * this.jdbcTemplateObject = new JdbcTemplate(dataSource); }
	 */

	/*
	 * public LoginResponse getUser(LoginRequest request) { LoginResponse
	 * loginResponse = new LoginResponse(); Gson gson =new Gson(); try { if(null !=
	 * request) { String requestStr = gson.toJson(request);
	 * System.out.println("Login requestStr-->"+requestStr); List<SqlParameter>
	 * paramList = new ArrayList<SqlParameter>();
	 * 
	 * paramList.add(new SqlParameter( Types.NVARCHAR)); paramList.add(new
	 * SqlOutParameter("OutputJSON", Types.NVARCHAR)); paramList.add(new
	 * SqlOutParameter("ErrorNo", Types.INTEGER)); paramList.add(new
	 * SqlOutParameter("ErrorMessage", Types.VARCHAR));
	 * 
	 * Map<String, Object> resultMap = jdbcTemplate.call(new
	 * CallableStatementCreator() {
	 * 
	 * @Override public CallableStatement createCallableStatement(Connection
	 * connection) throws SQLException {
	 * 
	 * CallableStatement callableStatement =
	 * connection.prepareCall("{call Proc_SaveUsr_IU(?, ?, ?, ?)}");
	 * callableStatement.setString(1, requestStr);
	 * callableStatement.registerOutParameter(2, Types.NVARCHAR);
	 * callableStatement.registerOutParameter(3, Types.INTEGER);
	 * callableStatement.registerOutParameter(4, Types.VARCHAR); return
	 * callableStatement;
	 * 
	 * } }, paramList);
	 * 
	 * System.out.println("Output -->"+resultMap); String loginResponseString =
	 * (String) resultMap.get("OutputJSON");
	 * System.out.println("loginResponseString -->"+loginResponseString);
	 * 
	 * loginResponse = gson.fromJson(loginResponseString, LoginResponse.class);
	 * if(null != loginResponse) { loginResponse.setStatus("SUCCESS"); } else {
	 * loginResponse = new LoginResponse(); loginResponse.setStatus("ERROR"); } } }
	 * catch(Exception ex) { loginResponse = new LoginResponse();
	 * loginResponse.setStatus("ERROR"); ex.printStackTrace(); } return
	 * loginResponse; }
	 * 
	 * 
	 * public UserRegistrationResponse registerUser(UserRegistrationRequest request)
	 * { UserRegistrationResponse userRegistrationResponse = new
	 * UserRegistrationResponse(); Gson gson =new Gson(); try { if(null != request)
	 * { String requestStr = gson.toJson(request); List<SqlParameter> paramList =
	 * new ArrayList<SqlParameter>();
	 * 
	 * paramList.add(new SqlParameter( Types.NVARCHAR)); paramList.add(new
	 * SqlOutParameter("OutputJSON", Types.NVARCHAR)); paramList.add(new
	 * SqlOutParameter("ErrorNo", Types.INTEGER)); paramList.add(new
	 * SqlOutParameter("ErrorMessage", Types.VARCHAR));
	 * 
	 * Map<String, Object> resultMap = jdbcTemplate.call(new
	 * CallableStatementCreator() {
	 * 
	 * @Override public CallableStatement createCallableStatement(Connection
	 * connection) throws SQLException {
	 * 
	 * CallableStatement callableStatement =
	 * connection.prepareCall("{call Proc_SaveUsr_IU(?, ?, ?, ?)}");
	 * callableStatement.setString(1, requestStr);
	 * callableStatement.registerOutParameter(2, Types.NVARCHAR);
	 * callableStatement.registerOutParameter(3, Types.INTEGER);
	 * callableStatement.registerOutParameter(4, Types.VARCHAR); return
	 * callableStatement;
	 * 
	 * } }, paramList);
	 * 
	 * System.out.println("Output -->"+resultMap); String userRegResponseString =
	 * (String) resultMap.get("OutputJSON");
	 * System.out.println("userRegResponseString -->"+userRegResponseString);
	 * 
	 * userRegistrationResponse = gson.fromJson(userRegResponseString,
	 * UserRegistrationResponse.class);
	 * 
	 * if(null != userRegistrationResponse) {
	 * userRegistrationResponse.setStatus("SUCCESS"); } else {
	 * userRegistrationResponse = new UserRegistrationResponse();
	 * userRegistrationResponse.setStatus("ERROR"); } } } catch(Exception ex) {
	 * userRegistrationResponse = new UserRegistrationResponse();
	 * userRegistrationResponse.setStatus("ERROR"); ex.printStackTrace(); } return
	 * userRegistrationResponse; }
	 */
	
	
	public String getUser(String request)
	{
		
		String response = null;
		StringBuffer sbData = new StringBuffer();
		try
		{
			if(null != request)
			{
				System.out.println("Login requestStr-->"+request);
				List<SqlParameter> paramList = new ArrayList<SqlParameter>();
				
				paramList.add(new SqlParameter( Types.NVARCHAR));
				paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
				paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
				paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));

				Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {

					@Override
					public CallableStatement createCallableStatement(Connection connection)
							throws SQLException {

						CallableStatement callableStatement = connection.prepareCall("{call Proc_GetUsrData_R(?, ?, ?, ?)}");
						callableStatement.setString(1, request);
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


	public String registerUser(String request)
	{
		String response = null;
		StringBuffer sbData = new StringBuffer();
		try
		{
			if(null != request)
			{
				List<SqlParameter> paramList = new ArrayList<SqlParameter>();
				
				paramList.add(new SqlParameter( Types.NVARCHAR));
				paramList.add(new SqlOutParameter("OutputJSON", Types.NVARCHAR));
				paramList.add(new SqlOutParameter("ErrorNo", Types.INTEGER));
				paramList.add(new SqlOutParameter("ErrorMessage", Types.VARCHAR));

				Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {

					@Override
					public CallableStatement createCallableStatement(Connection connection)
							throws SQLException {

						CallableStatement callableStatement = connection.prepareCall("{call Proc_SaveUsr_IU(?, ?, ?, ?)}");
						callableStatement.setString(1, request);
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

}
