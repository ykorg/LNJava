package com.yk;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	
	@Select("SELECT * FROM t_user WHERE ID = #{id}")
	@Results(id="resultsmap",value = {
			@Result(column = "id",property = "uid"),
			@Result(column = "name",property = "uname"),
			@Result(column = "salary",property = "usalary")

	})
	User selectUser(Long id);
	@Select(" SELECT * FROM t_user")
	@ResultMap("resultsmap")
	List<User> allUser();
	void updateUser(User u);
	
}
