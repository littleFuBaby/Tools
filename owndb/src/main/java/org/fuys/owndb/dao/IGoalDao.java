package org.fuys.owndb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.fuys.owndb.vo.Goal;

public interface IGoalDao {

	@Insert("INSERT INTO goal(name,description,start_time,end_time) VALUES(#{name},#{description},#{startTime},#{endTime})")
	@SelectKey(before = false, keyProperty = "goalId", resultType = java.lang.String.class, statement = "select last_insert_id()")
	public int insert(Goal goal) throws Exception;

	@Update("UPDATE goal SET name=#{name},description=#{description},start_time=#{startTime},end_time=#{endTime} WHERE goalId = #{goalId}")
	public int update(Goal goal) throws Exception;

	@Delete("DELETE FROM goal WHERE goalId = #{goalId}")
	public int delete(int goalId) throws Exception;

	@Select("SELECT goalId,name,description,start_time AS startTime,end_time AS endTime FROM goal WHERE goalId = #{goalId}")
	public Goal selectOne(int goalId) throws Exception;

	@Select("SELECT goalId,name,description,start_time AS startTime,end_time AS endTime FROM goal WHERE name like concat(concat('%',#{name}),'%') and description like concat(concat('%',#{description}),'%')")
	public List<Goal> selectList(Goal goal) throws Exception;

	@Select("SELECT goalId,name,description,start_time AS startTime,end_time AS endTime FROM goal WHERE ${column} like concat(concat('%',#{keyword}),'%') LIMIT #{start},#{linesize}")
	public List<Goal> selectSplit(@Param("start") int start, @Param("linesize") int linesize, @Param("column") String column,
			@Param("keyword") String keyword) throws Exception;

	@Select("SELECT count(goalId) FROM goal WHERE ${column} like concat(concat('%',#{keyword}),'%') ")
	public int selectCount(@Param("column") String column, @Param("keyword") String keyword) throws Exception;

}
