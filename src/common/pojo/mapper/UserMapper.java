package common.pojo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import common.pojo.User;

public interface UserMapper {

	@Select("select * from user where id=#{id}")
	User getUserById(int id);

	@Insert("insert into user(name,age) values(#{name},#{age})")
	int addUser(User user);
}
