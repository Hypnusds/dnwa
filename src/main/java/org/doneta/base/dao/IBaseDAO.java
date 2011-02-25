package org.doneta.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * 所有DAO对象需要集成该基类
 * @author Hypnusds
 */
public interface IBaseDAO {

	public abstract void setDataSource(BasicDataSource dataSource);

	/**
	 * 获取QueryRunner对象 用于自定义事务或者复杂查询
	 * @return QueryRunner对象
	 */
	public abstract QueryRunner getRunner();

	/**
	 * 查询返回列表
	 * @param <T> 输入的Clazz类型
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return List
	 */
	public abstract <T> List<T> queryForOList(String sql, Object[] param, Class<T> clazz);

	/**
	 * 查询返回列表
	 * @param sql
	 * @param param
	 * @return List
	 */
	public abstract List<?> queryForOList(String sql, Object[] param);

	/**
	 * 查均返回一个都是Map的List集合集合
	 * @param sql
	 * @param param
	 * @return List<Map>
	 */
	public abstract List<Map<String, Object>> queryForListMap(String sql, Object[] param);

	/**
	 * 查询返回一个Map集合 首行数据
	 * @param sql
	 * @param param
	 * @return Map
	 */
	public abstract Map<String, Object> queryForMap(String sql, Object[] param);

	/**
	 * 获得第一个查询第一行第一列
	 * @param sql
	 * @param params
	 * @return Object
	 */
	public abstract Object getAnAttr(String sql, Object[] params);

	/**
	 * 获得第一个查询第一行
	 * @param <T>
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return T
	 */
	public abstract <T> T queryForInstance(String sql, Object param[],
			Class<T> clazz);

	/**
	 * 返回count
	 * @param sql
	 * @param params
	 * @return int
	 */
	public abstract int count(String sql, Object[] params);

	/**
	 * 插入数据返回主键
	 * @param sql
	 * @param params
	 * @return Object
	 */
	public abstract Object storeInfoAndGetGeneratedKey(String sql, Object[] params);

	/**
	 * 更新方法
	 * @param sql
	 * @param param
	 * @return 影响行数
	 */
	public abstract int update(String sql, Object[] param);

	/**
	 * 获取Clazz方法
	 * @return Class
	 */
	public abstract Class<?> getClazz();

}