package com.yicj.mybatis.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yicj.mybatis.pojo.User;


/**
 * Dao
 * @author lx
 *
 */
public class UserDaoImpl implements UserDao {

	//注入
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	//通过用户ID查询一个用户
	public User selectUserById(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("com.yicj.mybatis.mapper.UserMapper.findUserById", id);
	}
	//通过用户名称模糊查询
	public List<User> selectUserByUsername(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("com.yicj.mybatis.mapper.UserMapper.findUserById", id);
	}
	
}
