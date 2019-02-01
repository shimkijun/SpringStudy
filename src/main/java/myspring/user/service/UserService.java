package myspring.user.service;

import java.util.List;

import myspring.user.vo.UserVO;

public interface UserService {
	int insertUser(UserVO user);
	List<UserVO> getUserList();
	int deleteUser(String id);
	UserVO getUser(String id);
	int updateUser(UserVO user);
}
