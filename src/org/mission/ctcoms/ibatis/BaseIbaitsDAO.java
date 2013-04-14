package org.mission.ctcoms.ibatis;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.mission.ctcoms.exception.ApplicationException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 
 * @author 黄宇强
 * @date  2011-8-5 上午09:27:06
 * @description This base class is prepared for subclass to do CRUD easily.
 */
public class  BaseIbaitsDAO extends SqlMapClientDaoSupport {
	private Logger log4j = Logger.getLogger(BaseIbaitsDAO.class);

	/**
	 * 根据条件查询对象集合
	 * 
	 * @param sqlid
	 *            对应IBATIS xml SQL_ID
	 * @param paramObj
	 *            参数对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> loadList(String sqlid, Object paramObj) {
		return (List<T>) getSqlMapClientTemplate()
				.queryForList(sqlid, paramObj);
	}

	/**
	 * 根据条件查询对象所有数据
	 * 
	 * @param <T>
	 * @param sqlid
	 *            对应IBATIS xml SQL_ID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> loadList(String sqlid) {
		return (List<T>) getSqlMapClientTemplate().queryForList(sqlid);
	}

	/**
	 * 根据ID查询ENTITY 对象
	 * 
	 * @param <T>
	 * @param sqlid 对应IBATIS
	 *            xml SQL_ID
	 * @return <T> 实体对象
	 */
	@SuppressWarnings("unchecked")
	public <T> T loadObject(String sqlid) {
		return (T) getSqlMapClientTemplate().queryForObject(sqlid);
	}

	/**
	 * 根据ID查询ENTITY 对象
	 * 
	 * @param <T>
	 * @param sqlid 对应IBATIS
	 *            xml SQL_ID
	 * @param id
	 *            实体ID
	 * @return <T> 实体对象
	 */
	@SuppressWarnings("unchecked")
	public <T> T loadObject(String sqlid, String id) {
		return (T) getSqlMapClientTemplate().queryForObject(sqlid, id);
	}

	/**
	 * 根据ID查询ENTITY 对象
	 * 
	 * @param <T>
	 * @param sqlId 对应IBATIS
	 *            xml SQL_ID
	 * @param id
	 *            实体ID
	 * @return <T> 实体对象
	 */
	@SuppressWarnings("unchecked")
	public <T> T loadObject(String sqlId, Long id) {
		return (T) getSqlMapClientTemplate().queryForObject(sqlId, id);
	}

	/**
	 * 根据条件查询对象
	 * 
	 * @param <T>
	 * @param sqlId 对应IBATIS
	 *            xml SQL_ID
	 * @param paramObj
	 *            参数
	 * @return <T> 实体对象
	 */
	@SuppressWarnings("unchecked")
	public <T> T loadObject(String sqlId, Object paramObj) {
		return (T) getSqlMapClientTemplate().queryForObject(sqlId, paramObj);
	}

	/**
	 * 保存对象
	 * 
	 * @param sqlid
	 *            对应IBATIS xml SQL_ID
	 * @param entity
	 *            保存的对象
	 */
	public void save(String sqlid, Object entity) {
		getSqlMapClientTemplate().insert(sqlid, entity);
	}

	/**
	 * 保存对象
	 * 
	 * @param sqlid
	 *            对应IBATIS xml SQL_ID
	 * @param entity
	 *            保存的对象
	 */
	public void save(String sqlid, Map<String, Object> entity) {
		getSqlMapClientTemplate().insert(sqlid, entity);
	}

	/**
	 * 更新对象
	 * 
	 * @param sqlId
	 *            对应IBATIS xml SQL_ID
	 * @param entity
	 *            修改对象
	 */
	public void update(String sqlId, Map<String, Object> entity) {
		getSqlMapClientTemplate().update(sqlId, entity);
	}

	/**
	 * 更新对象
	 * 
	 * @param sqlId
	 *            对应IBATIS xml SQL_ID
	 * @param entity
	 *            修改对象
	 */
	public void update(String sqlId, Object entity) {
		getSqlMapClientTemplate().update(sqlId, entity);
	}

	/**
	 * 删除指定的对象
	 * 
	 * @param sqlId
	 * @param object
	 *            需要删除的对象
	 */
	public void delete(String sqlId, Object object) {
		getSqlMapClientTemplate().delete(sqlId, object);
	}

	/**
	 * 查询数据总条数
	 * 
	 * @param sqlid
	 * @param object
	 * @return
	 */
	public Long loadRecordCountObject(String sqlid, Object object) {
		log4j.info("sqlid====" + sqlid);
		return (Long) getSqlMapClientTemplate().queryForObject(sqlid, object);
	}

	/**
	 * 查询数据总条数
	 * 
	 * @param sqlid
	 * @param object
	 * @return 返回Int
	 */
	public Integer loadRecordCount(String sqlid, Object object) {
		log4j.info("sqlid====" + sqlid);
		return (Integer) getSqlMapClientTemplate()
				.queryForObject(sqlid, object);
	}

	/**
	 * @Title: findTNextId
	 * @Description: 返回表中ID最大值加一
	 * @param:
	 * @param tabName
	 *            表名
	 * @return:
	 * @returnType: Long
	 * @throws
	 */
	public Long findTNextId(String tabName) {
		Long id = 0l;
		String seqName = tabName.substring(3) + "_S";
		id = (Long) getSqlMapClientTemplate().queryForObject(
				"Common.findTNextId", seqName);
		if (id == null || id.equals(0l))
			throw new ApplicationException("ID查询错误");
		return id;
	}

	public Date findOracleSysdate() {

		return (Date) getSqlMapClientTemplate().queryForObject(
				"Common.findOracleSysdate", null);
	}

}
