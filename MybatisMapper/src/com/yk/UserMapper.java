package com.yk;

import java.util.List;

public interface UserMapper {
	User selectUser(Long id);
	List<User> allUser();
	void updateUser(User u);
	
}
