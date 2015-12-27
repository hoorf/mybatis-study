package common.util;

import java.io.FileNotFoundException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import common.pojo.mapper.UserMapper;

public class MybatisUtil {

	public static SqlSession getSqlSession(boolean autoCommit) {
		try {
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsReader("jdbc.xml"));
			sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
			return sqlSessionFactory.openSession(autoCommit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
