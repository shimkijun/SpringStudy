package myspring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myspring.user.vo.UserVO;

@Repository("userDao")
public class UserDaoImplMapper implements UserDao{
	
	@Autowired
	private UserMapper userMapper;

	public int insert(UserVO user) {
		int result = 0;
		result = userMapper.insertUser(user);
		System.out.println("등록된 UserId = " + user.getUserid() + " Name = " + user.getName());
		return result;
	}

	public List<UserVO> readAll() {
		List<UserVO> userList = userMapper.selectUserList();
		return userList;
	}
	
	public int delete(String id) {
		int result = 0;
		result = userMapper.deleteUser(id);
		return result;
	}

	public int update(UserVO user) {
		int result = 0;
		result = userMapper.updateUser(user);
		return result;
	}

	public UserVO read(String id) {
		UserVO user = userMapper.selectUserById(id);
		return user;
	}

}
