package org.fuys.owndb.test;

import java.util.ArrayList;
import java.util.List;

import org.fuys.owndb.model.MyBatisSqlSessionFactory;
import org.fuys.owndb.vo.Groups;
import org.fuys.owndb.vo.Role;
import org.fuys.owndb.vo.RoleGroups;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMoreVsMore {
	
	private Logger logger = LoggerFactory.getLogger(TestMoreVsMore.class);

	@Test
	public void testInsert() throws Exception {
		
		Role role = new Role();
		role.setName("family");
		
		int lenR = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Role.insert", role);
		logger.info("role --> " + role.toString() + " --> " + lenR);
		
		List<Integer> groupses = new ArrayList<>();
		Groups groups = new Groups();
		groups.setName("life");
		int lenG = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Groups.insert",groups);
		logger.info("groups --> " + groups.toString() + " --> " + lenG);
		groupses.add(groups.getGid());
		
		groups.setName("gift");
		lenG = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Groups.insert",groups);
		logger.info("groups --> " + groups.toString() + " --> " + lenG);
		groupses.add(groups.getGid());
		
		RoleGroups roleGroups = new RoleGroups();
		for(int x=0;x<groupses.size();x++){
			roleGroups.setRid(role.getRid());
			roleGroups.setGid(groupses.get(x));
			int lenRG = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Role.insertRoleGroups",roleGroups);
			logger.info("groups --> " + roleGroups + " --> " + lenRG);
		}
		
		MyBatisSqlSessionFactory.getSqlSession().commit();
		MyBatisSqlSessionFactory.closeSqlSession();
	}
	
	@Test
	public void testUpdate(){
		Role role = new Role();
		role.setRid(1);
		role.setName("better friend");
		int len = MyBatisSqlSessionFactory.getSqlSession().update("org.fuys.owndb.vo.mapping.Role.updateByRid", role);
		logger.info("role --> " + len);
		
		int delRG = MyBatisSqlSessionFactory.getSqlSession().delete("org.fuys.owndb.vo.mapping.Role.deleteRoleGroupsByRid", 1);
		logger.info("roleGroups --> " + delRG);		
		
		List<Integer> groupses = new ArrayList<>();
		groupses.add(1);
		groupses.add(2);
		
		RoleGroups roleGroups = new RoleGroups();
		for(int x=0;x<groupses.size();x++){
			roleGroups.setRid(role.getRid());
			roleGroups.setGid(groupses.get(x));
			int lenRG = MyBatisSqlSessionFactory.getSqlSession().insert("org.fuys.owndb.vo.mapping.Role.insertRoleGroups",roleGroups);
			logger.info("groups --> " + roleGroups + " --> " + lenRG);
		}
		
		MyBatisSqlSessionFactory.getSqlSession().commit();
		MyBatisSqlSessionFactory.closeSqlSession();
	}
	
	@Test
	public void testMoreVsMore(){
		
		Role role = MyBatisSqlSessionFactory.getSqlSession().selectOne("org.fuys.owndb.vo.mapping.Role.selectByRid",1);
		logger.info(role.toString());
		
	}
}
