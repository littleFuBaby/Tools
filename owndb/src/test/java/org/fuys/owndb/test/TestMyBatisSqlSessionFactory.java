package org.fuys.owndb.test;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.fuys.owndb.model.MyBatisSqlSessionFactory;
import org.fuys.owndb.vo.Goal;
import org.fuys.owndb.vo.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class TestMyBatisSqlSessionFactory {
	
	private Logger logger = LoggerFactory.getLogger(TestMyBatisSqlSessionFactory.class);

	@Test
	public void test() {
		User user = new User();
		user.setName("jay " + new Random().nextInt(99));
		user.setSex(1);
		
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int len = session.insert("org.fuys.owndb.vo.mapping.User.insert",user);
		session.commit();
		MyBatisSqlSessionFactory.closeSqlSession();
		TestCase.assertEquals(len, 1);
	}
	
	@Test
	public void testInsertGoal() throws Exception{
		Goal goal = new Goal();
		goal.setName("Executor" + new Random().nextInt(9999));
		goal.setDescription("This is the most important goals in the world.");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		goal.setStartTime(sdf.parse("2018-01-01 00:00:00"));
		goal.setEndTime(sdf.parse("2099-12-30 23:59:59"));
		
		int len = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Goal.insert", goal);
		MyBatisSqlSessionFactory.getSqlSession().commit();
		MyBatisSqlSessionFactory.closeSqlSession();
		logger.info("Goal vo is " + goal);
		TestCase.assertEquals(len, 1);
	}
	
	@Test
	public void testSelectByGoalId(){
		Goal goal = MyBatisSqlSessionFactory.getSqlSession().selectOne("org.fuys.owndb.vo.mapping.Goal.selectByGoalId",3);
		TestCase.assertNotNull(goal);
		logger.info(goal.toString());
	}
	
	@Test
	public void testSelectAll(){
		List<Goal> goalList = MyBatisSqlSessionFactory.getSqlSession().selectList("org.fuys.owndb.vo.mapping.Goal.selectAll");
		TestCase.assertNotNull(goalList);
		logger.info(String.valueOf(goalList.size()));
		logger.info(goalList.toString());
	}
	
	@Test
	public void testSelectSplit(){
		Map<String, Object> map = new HashMap<>();
		map.put("column", "name");
		map.put("keyword", "%%");
		int count = MyBatisSqlSessionFactory.getSqlSession().selectOne("org.fuys.owndb.vo.mapping.Goal.selectCount",map);
		TestCase.assertTrue(count>-1);
		logger.info(String.valueOf(count));
		
		map.put("start", 3);
		map.put("linesize", 2);
		List<Goal> goalList = MyBatisSqlSessionFactory.getSqlSession().selectList("org.fuys.owndb.vo.mapping.Goal.selectSplit",map);
		TestCase.assertNotNull(goalList);
		logger.info(String.valueOf(goalList.size()));
		logger.info(goalList.toString());
	}

}
