package org.doneta.base.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;
import org.doneta.base.dao.IBaseDAO;

/**
 * <P>BaseDAO 基本的JDBC操作封装<P>
 * <P>使用DBUtils<P>
 * @author Hypnusds
 */
public class BaseDAO implements IBaseDAO {

	protected static final Logger log = Logger.getLogger(BaseDAO.class);
	protected QueryRunner runner;
	protected BasicDataSource dataSource;

	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#setDataSource(org.apache.commons.dbcp.BasicDataSource)
	 */
	@Override
	public void setDataSource(BasicDataSource dataSource) {
		runner = new QueryRunner(dataSource);
		this.dataSource = dataSource;
	}

	/**
	 * 调试打印SQL语句
	 * @param sql
	 */
	public void showSql(String sql) {
		log.debug(sql);
	}

	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#getRunner()
	 */
	@Override
	public QueryRunner getRunner() {
		return runner;
	}

	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#queryForOList(java.lang.String, java.lang.Object[], java.lang.Class)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> queryForOList(String sql, Object[] param, Class<T> clazz) {
		showSql(sql);
		List<T> instances = null;
		try {
			instances = (List<T>) runner.query(sql, new BeanListHandler(clazz), param);
		} catch (SQLException e) {
			log.error(e);
		}
		return instances;
	}

	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#queryForOList(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> queryForOList(String sql, Object[] param) {
		return queryForOList(sql, param, getClazz());
	}
	
	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#queryForListMap(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<Map<String, Object>> queryForListMap(String sql, Object[] param) {
		showSql(sql);
		List<Map<String, Object>> maps = null;
		try {
			maps = runner.query(sql, new MapListHandler(), param);
		} catch (SQLException e) {
			log.error(e);
		}
		return maps;
	}
	
	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#queryForMap(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Map<String, Object> queryForMap(String sql, Object[] param) {
		showSql(sql);
		Map<String, Object> map = null;
		try {
			map = runner.query(sql, new MapHandler(), param);
		} catch (SQLException e) {
			log.error(e);
		}
		return map;
	}
	
	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#getAnAttr(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object getAnAttr(String sql, Object[] params) {
		showSql(sql);
		Object instance = null;
		try {
			instance = runner.query(sql, new ScalarHandler(1), params);
		} catch (SQLException e) {
			log.error(e);
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#queryForInstance(java.lang.String, java.lang.Object[], java.lang.Class)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T queryForInstance(String sql, Object param[], Class<T> clazz) {
		showSql(sql);
		T instance = null;
		try {
			instance = (T) runner.query(sql, new BeanHandler(clazz), param);
		} catch (SQLException e) {
			log.error(e);
		}
		return instance;
	}
	
	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#count(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int count(String sql, Object[] params) {
		Object num = getAnAttr(sql, params);
		if (num instanceof Number) {
			return ((Number)num).intValue();
		}
		String s = (String) num;
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#storeInfoAndGetGeneratedKey(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object storeInfoAndGetGeneratedKey(String sql, Object[] params) {
		Object pk = 0;
		Connection conn = null;
		try {
			showSql(sql);
			conn =this.dataSource.getConnection();
			runner.update(conn, sql, params);
			pk = runner.query(conn, "SELECT LAST_INSERT_ID()", new ScalarHandler(1));
		} catch (SQLException e) {
			log.error(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return pk;
	}

	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#update(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int update(String sql, Object[] param) {
		showSql(sql);
		int i = 0;
		try {
			i = runner.update(sql, param);
		} catch (SQLException e) {
			log.error(e);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see org.doneta.base.dao.IBaseDAO#getClazz()
	 */
	@Override
	public Class<?> getClazz() {
		return null;
	}
	
}
