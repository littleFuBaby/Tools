package org.fuys.owndb.test;

import java.util.List;

import org.fuys.owndb.sqlSessionFactory.MyBatisSqlSessionFactory;
import org.fuys.owndb.vo.Capital;
import org.fuys.owndb.vo.Country;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class TestOneVsOne {
	
	private Logger logger = LoggerFactory.getLogger(TestOneVsOne.class);

	@Test
	public void testInsert() {
		
		Country country = new Country();
		country.setCountryId("JAPAN");
		country.setName("japan");
		
		Capital capital = new Capital();
		capital.setCapitalId("TOKYO");
		capital.setCountryId("JAPAN");
		capital.setName("tokyo");
		
		int lenA = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Country.insert",country);
		TestCase.assertEquals(lenA, 1);
		logger.info("Country --> " + lenA);
		
		int lenB = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Capital.insert",capital);
		TestCase.assertEquals(lenB, 1);
		logger.info("Country --> " + lenB);
		
		MyBatisSqlSessionFactory.getSqlSession().commit();
		MyBatisSqlSessionFactory.closeSqlSession();
		
	}
	
	@Test
	public void testSelect(){
		
		Country country = new Country();
		country.setCountryId("JAPAN");
		country.setName("japan");
		
		Capital capital = new Capital();
		capital.setCapitalId("TOKYO");
		capital.setCountryId("JAPAN");
		capital.setName("tokyo");
		
		List<Country> countryList = MyBatisSqlSessionFactory.getSqlSession().selectList("org.fuys.owndb.vo.mapping.Country.select",country);
		TestCase.assertNotNull(countryList);
		logger.info(countryList.toString());
		
		List<Capital> capitalList = MyBatisSqlSessionFactory.getSqlSession().selectList("org.fuys.owndb.vo.mapping.Capital.select",capital);
		TestCase.assertNotNull(capitalList);
		logger.info(capitalList.toString());
		
	}
	
	@Test
	public void testSelectOne(){
		
		Country country = MyBatisSqlSessionFactory.getSqlSession().selectOne("org.fuys.owndb.vo.mapping.Country.selectByCountryId","JAPAN");
		TestCase.assertNotNull(country);
		logger.info(country.toString());
		
		Capital capital = MyBatisSqlSessionFactory.getSqlSession().selectOne("org.fuys.owndb.vo.mapping.Capital.selectByCountryId","JAPAN");
		TestCase.assertNotNull(capital);
		logger.info(capital.toString());
		
	}
	
	@Test
	public void testSelectOneVsOne(){
		
		Country country = MyBatisSqlSessionFactory.getSqlSession().selectOne("org.fuys.owndb.vo.mapping.Country.selectByCountryId","CHINA");
		TestCase.assertNotNull(country);
		logger.info(country.toString());
		
		country = new Country();
		country.setCountryId("CHINA");
		
		List<Country> countryList = MyBatisSqlSessionFactory.getSqlSession().selectList("org.fuys.owndb.vo.mapping.Country.select",country);
		TestCase.assertNotNull(countryList);
		logger.info(countryList.toString());
		
	}
	
}
