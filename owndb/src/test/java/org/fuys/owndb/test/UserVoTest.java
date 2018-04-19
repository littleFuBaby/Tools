package org.fuys.owndb.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fuys.owndb.sqlSessionFactory.MyBatisSqlSessionFactory;
import org.fuys.owndb.vo.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class UserVoTest {

	private Logger logger = LoggerFactory.getLogger(UserVoTest.class);

	@Test
	public void testInsert() throws Exception {

		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sqlFactory.openSession();

		User user = new User();
		user.setName("ella");
		user.setSex(2);

		int len = session.insert("org.fuys.owndb.vo.mapping.User.insert", user);
		TestCase.assertEquals(len, 1);
		session.commit();
		session.close();
		is.close();
	}

	@Test
	public void testSelectAll() {
		User user = new User();
		user.setName("jay");
		List<User> userList = MyBatisSqlSessionFactory.getSqlSession()
				.selectList("org.fuys.owndb.vo.mapping.User.selectList", user);
		logger.info(userList.toString());
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setName("andy - 5");
		user.setSex(2);
		int len = MyBatisSqlSessionFactory.getSqlSession().update("org.fuys.owndb.vo.mapping.User.update", user);
		MyBatisSqlSessionFactory.getSqlSession().commit();
		logger.info(String.valueOf(len));
	}

	@Test
	public void testSelectByUidArray() {
		int[] uidArray = new int[3];
		uidArray[0] = 6;
		uidArray[1] = 7;
		uidArray[2] = 8;
		List<User> userList = MyBatisSqlSessionFactory.getSqlSession()
				.selectList("org.fuys.owndb.vo.mapping.User.selectByUidArray", uidArray);
		logger.info(userList.toString());
	}

}
