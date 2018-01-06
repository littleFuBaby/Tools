package org.fuys.owndb.model;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1,get SqlSessionFactory and SqlSession object<br>
 * 2,close SqlSession connection<br>
 * 3,rebuild SqlSessionFactory
 * @author ys
 *
 */
public class MyBatisSqlSessionFactory {
	
	/**
	 * Define logger
	 */
	private static Logger logger = LoggerFactory.getLogger(MyBatisSqlSessionFactory.class);
	
	/**
	 * Define MyBatis-config.xml path
	 * JVM read from classPath
	 */
	private static String MYBATIS_CONFIG = "mybatis-config.xml";
	
	/**
	 * Define inputStream to read mybatis-config.xml file
	 */
	private static InputStream is = null;
	
	/**
	 * Define sqlSessionFactory object
	 */
	private static SqlSessionFactory sqlSessionFactory = null;
	
	/**
	 * Ensure sqlSessionFacoty object is not null
	 */
	static{
		rebuildSqlSessionFactory();
	}
	
	/**
	 * Define local thread to save SqlSession object
	 */
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
	
	/**
	 * Rebuild sqlSessionFactory object
	 */
	public static void rebuildSqlSessionFactory(){
		try {
			if(sqlSessionFactory==null){
				is = Resources.getResourceAsStream(MYBATIS_CONFIG);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			}
		} catch (Exception e) {
			logger.error("rebuild SqlSessionFactory Exception", e);
		}finally{
			try {
				is.close();
			} catch (Exception e2) {
				logger.error("close inputStream", e2);
			}
		}
	}
	
	/**
	 * Get sqlSessionFactory object
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
	
	/**
	 * Get sqlSession object
	 * @return
	 */
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession==null){
			if(sqlSessionFactory==null){
				rebuildSqlSessionFactory();
			}
			sqlSession = sqlSessionFactory.openSession();
		}
		return sqlSession;
	}
	
	/**
	 * Close SqlSession object
	 */
	public static void closeSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession!=null){
			sqlSession.close();
			threadLocal.remove();
		}
	}
	
}