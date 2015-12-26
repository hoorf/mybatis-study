package common.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import common.pojo.User;
import common.pojo.mapper.UserMapper;

public class Test {

	public static void main(String[] args) {

		String resource = "jdbc.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		sessionFactory.getConfiguration().addMapper(UserMapper.class);

		SqlSession session = sessionFactory.openSession();
		// String statement = "mapping.userMapper.getUser";
		// User user = session.selectOne(statement, 1);
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.getUserById(1);
		System.out.println(user);
	}
}
