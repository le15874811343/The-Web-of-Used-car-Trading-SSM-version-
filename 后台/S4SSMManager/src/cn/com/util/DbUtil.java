package cn.com.util;

import java.util.*;
import java.sql.*;

import oracle.jdbc.OracleTypes;


import javax.naming.*;
import javax.sql.DataSource;
public class DbUtil {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet res = null;
	private static CallableStatement csmt = null;

	/**
	 * 获取连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		
			try {
				DbUtil.closeAll();
				Context context=new InitialContext();
			DataSource dataSource=(DataSource)context.lookup("java:comp/env/jdbc/oracle");
		con=		dataSource.getConnection();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
          return con;
	}

	/**
	 * 获取预编译命令对象
	 * 
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(String sql) {
		con = getConnection();
		try {
			psmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return psmt;
	}

	/**
	 * 获取结果集对象
	 * 
	 * @param sql
	 * @return
	 */
	public static ResultSet getResultSet(String sql) {
		psmt = getPreparedStatement(sql);
		try {
			res = psmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 获取预过程对象
	 * 
	 * @param sql
	 * @return
	 */
	public static CallableStatement getCallableStatement(String sql) {
		con = getConnection();
		try {
			csmt = con.prepareCall(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csmt;
	}

	/**
	 * 执行sql语句返回受影响的行数
	 * 
	 * @param sql
	 *            语句
	 * @param params
	 *            参数集合
	 * @return int
	 */
	public static int executeUpdate(String sql,  List<Object> params) {
		int count = 0;
		psmt = getPreparedStatement(sql);
		
		bindParams(psmt, params);
		try {
			
			count = psmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
				closeAll();
			}
		return count;

	}

	/**
	 * 执行sql语句返回结果集对象
	 * 
	 * @param sql
	 *            语句
	 * @param params
	 *            参数集合
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql, List<Object> params) {
		ResultSet rest = null;
		psmt = getPreparedStatement(sql);
		bindParams(psmt, params);
		try {
			rest = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rest;
	}
/**
 * 执行过程方法
 * @param sql
 * @param params
 * @return
 */
	public static CallableStatement executeCallable(String sql,
			Map<Integer, MyParams> params) {
		csmt = getCallableStatement(sql);
		try {
			for (Integer key : params.keySet()) {
				if (params.get(key).getType().equals("out")) {
					if (params.get(key).getValue().equals(OracleTypes.CURSOR)) {
						csmt.registerOutParameter(key, OracleTypes.CURSOR);
					}
					if(params.get(key).getValue().equals(Types.INTEGER)){
						csmt.registerOutParameter(key,Types.INTEGER);
					}
				} else {
                  csmt.setObject(key, params.get(key).getValue());
				}
			}
			
			csmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return csmt;
	}

	/**
	 * 绑定参数
	 * 
	 * @param psmt
	 *            预编译命令对象
	 * @param params
	 *            参数集合
	 */
	public static void bindParams(PreparedStatement psmt,
			List<Object> params) {
		if(params!=null){
		if (params.size() > 0) {
			for (int i=0;i<params.size();i++) {
				try {
					psmt.setObject(i+1, params.get(i));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	}
	public static void closeAll(){
		try {
			if (con != null) {

				con.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (res != null) {
				res.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
