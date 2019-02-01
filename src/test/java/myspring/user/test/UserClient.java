package myspring.user.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/data.xml")
public class UserClient {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	UserService service;
	
	@Test
	@Ignore
	public void dataSourceTest() {
		DataSource ds = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	@Ignore
	public void insertUserTest() {
		service.insertUser(new UserVO("user2","name2","여","city2"));
		
		for(UserVO user:service.getUserList()) {
			System.out.println("아이디 = ["+user.getUserid()+"] 이름 = ["+user.getName()+"] 성별 = ["+user.getGender()+"] 도시 = ["+user.getCity()+"]");
		}
	}
	
	@Test
	@Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("user2","name2","남","city2"));
		
		for(UserVO user:service.getUserList()) {
			System.out.println("아이디 = ["+user.getUserid()+"] 이름 = ["+user.getName()+"] 성별 = ["+user.getGender()+"] 도시 = ["+user.getCity()+"]");
		}
	}
	
	@Test
	@Ignore
	public void deleteUserTest() {
		service.deleteUser("user2");
		
		for(UserVO user:service.getUserList()) {
			System.out.println("아이디 = ["+user.getUserid()+"] 이름 = ["+user.getName()+"] 성별 = ["+user.getGender()+"] 도시 = ["+user.getCity()+"]");
		}
	}
	
	@Test
	public void getUserTest() {
		UserVO user = service.getUser("user1");
		//System.out.println("아이디 = ["+user.getUserid()+"] 이름 = ["+user.getName()+"] 성별 = ["+user.getGender()+"] 도시 = ["+user.getCity()+"]");
		user.userInfo();
		assertEquals("name1",user.getName());
	}
	
}
