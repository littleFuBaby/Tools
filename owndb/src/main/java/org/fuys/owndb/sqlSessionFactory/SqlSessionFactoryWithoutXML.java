package org.fuys.owndb.sqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * based on mybatis 3.4.7
 * @author ys
 *
 */
public class SqlSessionFactoryWithoutXML {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory fa = new SqlSessionFactoryBuilder().build(is);
			is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory fb = new SqlSessionFactoryBuilder().build(is);
			System.out.println(fa == fb);
			System.out.println(fa.equals(fb));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
