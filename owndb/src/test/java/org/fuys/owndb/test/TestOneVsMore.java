package org.fuys.owndb.test;

import java.util.List;

import org.fuys.owndb.sqlSessionFactory.MyBatisSqlSessionFactory;
import org.fuys.owndb.vo.Country;
import org.fuys.owndb.vo.Province;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class TestOneVsMore {
	
	private Logger logger = LoggerFactory.getLogger(TestOneVsMore.class);

	@Test
	public void testInsert() {
		
		Country country = new Country();
		country.setCountryId("CHINA");
		Province province = new Province();
		province.setProvinceId("BEIJING");
		province.setName("BeiJing");
		province.setCountry(country);
		
		int len = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Province.insert",province);
		MyBatisSqlSessionFactory.getSqlSession().commit();
		MyBatisSqlSessionFactory.closeSqlSession();
		TestCase.assertEquals(len, 1);
		logger.info("province --> " + len);
		
	}
	
	@Test
	public void testSelectOneVsMore(){
		Country country = MyBatisSqlSessionFactory.getSqlSession().selectOne("org.fuys.owndb.vo.mapping.Country.selectByCountryId","CHINA");
		TestCase.assertNotNull(country);
		logger.info(country.toString());
		
		// "1 + N" problem
		List<Country> countries = MyBatisSqlSessionFactory.getSqlSession().selectList("org.fuys.owndb.vo.mapping.Country.select");
		TestCase.assertNotNull(countries);
		logger.info(countries.toString());
		
	}
	
	@Test
	public void testSelectMoreVsOne(){
		
		Province province = MyBatisSqlSessionFactory.getSqlSession().selectOne("org.fuys.owndb.vo.mapping.Province.selectByProvinceId","GUIZHOU");
		TestCase.assertNotNull(province);
		logger.info(province.toString());
		
	}

}
