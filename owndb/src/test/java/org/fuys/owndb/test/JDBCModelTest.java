package org.fuys.owndb.test;

import org.fuys.owndb.jdbc.JDBCModel;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Testing JDBC Model class by JUnit
 * @author ys
 *
 */
public class JDBCModelTest {
	
	@Test
	public void testInsert(){
		String sql = "insert user(name,sex) values(?,?)";
		TestCase.assertEquals(JDBCModel.insert(sql, "jay","1"), 1);
	}
	
	@Test
	public void testUpdate(){
		String sql = "update user set sex=? where name=?";
		TestCase.assertTrue(JDBCModel.update(sql, "2","jolin")>0);		
	}
	
	@Test
	public void testDelete(){
		String sql = "delete from user where name=?";
		TestCase.assertTrue(JDBCModel.delete(sql, "jay")>0);
	}
	
	@Test
	public void testQuery(){
		String sql = "select * from user where name<>?";
		TestCase.assertTrue(JDBCModel.query(sql, "yunsong")>-1);
	}

}
