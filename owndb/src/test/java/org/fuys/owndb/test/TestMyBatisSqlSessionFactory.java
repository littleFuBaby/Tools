package org.fuys.owndb.test;

import org.apache.ibatis.session.SqlSession;
import org.fuys.owndb.model.MyBatisSqlSessionFactory;
import org.fuys.owndb.vo.User;
import org.junit.Test;

import junit.framework.TestCase;

public class TestMyBatisSqlSessionFactory {

	@Test
	public void test() {
		User user = new User();
		user.setName("Yao Ming");
		user.setSex(1);
		
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int len = session.insert("org.fuys.owndb.vo.mapping.User.insert",user);
		session.commit();
		MyBatisSqlSessionFactory.closeSqlSession();
		TestCase.assertEquals(len, 1);
	}

}
