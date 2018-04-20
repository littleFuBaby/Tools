package org.fuys.owndb.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fuys.owndb.sqlSessionFactory.MyBatisSqlSessionFactory;
import org.fuys.owndb.vo.Goal;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMyBatisCache {

	private Logger logger = LoggerFactory.getLogger(TestMyBatisCache.class);

	@Test
	public void test() {
		Goal goal = new Goal();
		goal.setName("8");
		SqlSession sessionA = MyBatisSqlSessionFactory.getSqlSession();
		List<Goal> goalListA = sessionA.selectList("org.fuys.owndb.vo.mapping.Goal.selectList", goal);
		logger.info(goalListA.toString());
		logger.info("**********************************************");
		SqlSession sessionB = MyBatisSqlSessionFactory.getSqlSession();
		System.out.println(sessionA == sessionB);
		List<Goal> goalListB = sessionB.selectList("org.fuys.owndb.vo.mapping.Goal.selectList", goal);
		logger.info(goalListB.toString());
	}

	@Test
	public void testCache() throws Exception {
		Goal goal = new Goal();
		goal.setName("8");
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sessionA = factory.openSession();
		List<Goal> goalListA = sessionA.selectList("org.fuys.owndb.vo.mapping.Goal.selectList", goal);
		logger.info(goalListA.toString());
		logger.info("**********************************************");
		SqlSession sessionB = factory.openSession();
		List<Goal> goalListB = sessionB.selectList("org.fuys.owndb.vo.mapping.Goal.selectList", goal);
		logger.info(goalListB.toString());
	}

	@Test
	public void testFirstCache() throws Exception {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Goal goal = new Goal();
		goal.setName("8");
		List<Goal> goalListA = sqlSession.selectList("org.fuys.owndb.vo.mapping.Goal.selectList", goal);
		logger.info(goalListA.toString());
		sqlSession.commit();
		logger.info("*********************************************");
		List<Goal> goalListB = sqlSession.selectList("org.fuys.owndb.vo.mapping.Goal.selectList", goal);
		logger.info(goalListB.toString());
	}

	@Test
	public void testSecondCache() throws Exception {

		Map<String, Object> map = new HashMap<>();
		map.put("column", "name");
		map.put("keyword", "%8%");

		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sessionA = factory.openSession();
		int countA = sessionA.selectOne("org.fuys.owndb.vo.mapping.Goal.selectCount", map);
		sessionA.close();
		logger.info("Count = " + countA);
		logger.info("**********************************************");
		SqlSession sessionB = factory.openSession();
		int countB = sessionB.selectOne("org.fuys.owndb.vo.mapping.Goal.selectCount", map);
		logger.info("Count = " + countB);
		sessionB.close();

	}

}
