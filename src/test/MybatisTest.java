package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import common.pojo.Classes;
import common.pojo.Student;
import common.pojo.User;
import common.pojo.mapper.UserMapper;
import common.util.MybatisUtil;

public class MybatisTest {

	@Test
	public void testAdd1() {
		SqlSession session = MybatisUtil.getSqlSession(true);
		User user = new User();
		user.setName("用户孤傲苍狼");
		user.setAge(20);
		int result = session.insert("mapping.userMapper.addUser", user);
		session.close();
		System.out.println(result);
	}

	@Test
	public void testAdd2() {
		SqlSession session = MybatisUtil.getSqlSession(true);
		User user = new User();
		user.setName("用户孤傲苍狼");
		user.setAge(20);
		UserMapper map = session.getMapper(UserMapper.class);
		int result = map.addUser(user);
		session.close();
		System.out.println(result);
	}

	@Test
	public void testselect() {
		SqlSession session = MybatisUtil.getSqlSession(true);

		Student st = session.selectOne("mapping.userMapper.getUser2", 2);

		session.close();
		System.out.println(st);

	}

	@Test
	public void testSearchOneToOne() {
		SqlSession session = MybatisUtil.getSqlSession(true);
		Classes st = session.selectOne("mapping.classesMapper.getClass2", 1);
		System.out.println(st);
		session.close();

	}
}
