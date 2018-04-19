package org.fuys.owndb.test;

import java.util.List;
import java.util.Random;

import org.fuys.owndb.sqlSessionFactory.MyBatisSqlSessionFactory;
import org.fuys.owndb.vo.Gift;
import org.fuys.owndb.vo.GiftBook;
import org.fuys.owndb.vo.GiftSouvenir;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class TestDiscriminator {
	
	private Logger logger = LoggerFactory.getLogger(TestDiscriminator.class);

	@Test
	public void testInsert() {
		
		GiftBook book = new GiftBook();
		book.setName("zero to one " + new Random().nextInt(99));
		book.setDescription("It's about company.");
		book.setCost(79.4);
		book.setFlag("book");
		book.setAuthor("Peter Thiel");
		
		int lenA = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Gift.insertGiftBook", book);
		MyBatisSqlSessionFactory.getSqlSession().commit();
		TestCase.assertEquals(lenA, 1);
		logger.info(String.valueOf(lenA));
		logger.info(book.toString());
		
		GiftSouvenir souvenir = new GiftSouvenir();
		souvenir.setName("mask " + new Random().nextInt(99));
		souvenir.setDescription("represent peace");
		souvenir.setCost(23.4);
		souvenir.setFlag("souvenir");
		souvenir.setOrigin("tibet");
		
		int lenB = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Gift.insertGiftBookSouvenir", souvenir);
		MyBatisSqlSessionFactory.getSqlSession().commit();
		TestCase.assertEquals(lenB, 1);
		logger.info(String.valueOf(lenB));
		logger.info(souvenir.toString());
	}
	
	@Test
	public void testSelectList() {
		
		GiftBook book = new GiftBook();
		book.setAuthor("Peter Thiel");
		
		List<GiftBook> bookList = MyBatisSqlSessionFactory.getSqlSession().selectList("org.fuys.owndb.vo.mapping.Gift.selectGiftBookList", book);
		TestCase.assertNotNull(bookList);
		for(int x=0;x<bookList.size();x++){
			Gift gift = bookList.get(x);
			if(gift instanceof Gift){
				logger.info("gift --> " + x);
			}
			if(gift instanceof GiftBook){
				logger.info("giftBook --> " + x);
			}
			if(gift instanceof GiftSouvenir){
				logger.info("giftSouvenir --> " + x);
			}
		}
		logger.info(bookList.toString());
		
		GiftSouvenir souvenir = new GiftSouvenir();
		souvenir.setName("mask");
		souvenir.setDescription("represent peace");
		souvenir.setCost(23.4);
		souvenir.setFlag("souvenir");
		
		List<GiftSouvenir> souvenirList = MyBatisSqlSessionFactory.getSqlSession().selectList("org.fuys.owndb.vo.mapping.Gift.selectGiftSouvenirList", souvenir);
		TestCase.assertNotNull(souvenirList);
		logger.info(souvenirList.toString());
	}

}
