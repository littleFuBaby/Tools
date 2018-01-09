package org.fuys.owndb.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.fuys.owndb.dao.IGoalDao;
import org.fuys.owndb.model.MyBatisSqlSessionFactory;
import org.fuys.owndb.vo.Goal;
import org.junit.Test;

import junit.framework.TestCase;

public class TestIGoalDao {
	
	private Logger logger = Logger.getLogger(TestIGoalDao.class);
	
	@Test
	public void testInsert() throws Exception {
		// add mapper
		MyBatisSqlSessionFactory.getSqlSessionFactory().getConfiguration().addMapper(IGoalDao.class);
		IGoalDao igoalDao = MyBatisSqlSessionFactory.getSqlSession().getMapper(IGoalDao.class);
		Goal goal = new Goal();
		goal.setName("JJ - " + new Random().nextInt(99));
		goal.setDescription("To be singer");
		goal.setStartTime(new Date());
		goal.setEndTime(new Date());
		int len = igoalDao.insert(goal);
		MyBatisSqlSessionFactory.getSqlSession().commit();
		MyBatisSqlSessionFactory.closeSqlSession();
		TestCase.assertEquals(len, 1);
		logger.info(String.valueOf(len));
		logger.info(goal);
	}
	
	@Test
	public void testUpdate() throws Exception {
		// add mapper
		MyBatisSqlSessionFactory.getSqlSessionFactory().getConfiguration().addMapper(IGoalDao.class);
		IGoalDao igoalDao = MyBatisSqlSessionFactory.getSqlSession().getMapper(IGoalDao.class);
		Goal goal = new Goal();
		goal.setGoalId("6");
		goal.setName("JJ - " + new Random().nextInt(99));
		goal.setDescription("To be singer");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		goal.setStartTime(sdf.parse("1988-08-22 23:23:23"));
		goal.setEndTime(sdf.parse("2099-12-12 23:56:59"));
		int len = igoalDao.update(goal);
		MyBatisSqlSessionFactory.getSqlSession().commit();
		MyBatisSqlSessionFactory.closeSqlSession();
		TestCase.assertEquals(len, 1);
		logger.info(String.valueOf(len));
		logger.info(goal);
	}
	
	@Test
	public void testDelete() throws Exception {
		// add mapper
		MyBatisSqlSessionFactory.getSqlSessionFactory().getConfiguration().addMapper(IGoalDao.class);
		IGoalDao igoalDao = MyBatisSqlSessionFactory.getSqlSession().getMapper(IGoalDao.class);
		int len = igoalDao.delete(6);
		MyBatisSqlSessionFactory.getSqlSession().commit();
		MyBatisSqlSessionFactory.closeSqlSession();
		TestCase.assertEquals(len, 1);
		logger.info(String.valueOf(len));
	}
	
	@Test
	public void testSelectOne() throws Exception {
		// add mapper
		MyBatisSqlSessionFactory.getSqlSessionFactory().getConfiguration().addMapper(IGoalDao.class);
		IGoalDao igoalDao = MyBatisSqlSessionFactory.getSqlSession().getMapper(IGoalDao.class);
		Goal goal = igoalDao.selectOne(7);
		MyBatisSqlSessionFactory.closeSqlSession();
		TestCase.assertNotNull(goal);
		logger.info(goal);
	}
	
	@Test
	public void testSelectList() throws Exception {
		// add mapper
		MyBatisSqlSessionFactory.getSqlSessionFactory().getConfiguration().addMapper(IGoalDao.class);
		IGoalDao igoalDao = MyBatisSqlSessionFactory.getSqlSession().getMapper(IGoalDao.class);
		Goal goal = new Goal();
		goal.setName("j");
		goal.setDescription("to");
		List<Goal> goalList = igoalDao.selectList(goal);
		MyBatisSqlSessionFactory.closeSqlSession();
		TestCase.assertNotNull(goalList);
		logger.info(goalList);
	}
	
	@Test
	public void testSelectSplit() throws Exception {
		// add mapper
		MyBatisSqlSessionFactory.getSqlSessionFactory().getConfiguration().addMapper(IGoalDao.class);
		IGoalDao igoalDao = MyBatisSqlSessionFactory.getSqlSession().getMapper(IGoalDao.class);
		List<Goal> goalList = igoalDao.selectSplit(1, 3, "name", "j");
		MyBatisSqlSessionFactory.closeSqlSession();
		TestCase.assertNotNull(goalList);
		logger.info(goalList);
	}
	
	@Test
	public void testSelectCount() throws Exception {
		// add mapper
		MyBatisSqlSessionFactory.getSqlSessionFactory().getConfiguration().addMapper(IGoalDao.class);
		IGoalDao igoalDao = MyBatisSqlSessionFactory.getSqlSession().getMapper(IGoalDao.class);
		int count = igoalDao.selectCount("name", "j");
		MyBatisSqlSessionFactory.closeSqlSession();
		TestCase.assertEquals(count>-1, true);
		logger.info(String.valueOf(count));
	}

}
