package org.yangjie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yangjie.entity.Team;
import org.yangjie.entity.User;
import org.yangjie.repository.TeamRepository;
import org.yangjie.repository.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RepositoryTest {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	
	@Test
	public void test() {
		Team team1 = new Team();
		team1.setName("武当");
		team1 = teamRepository.save(team1);
		Team team2 = new Team();
		team2.setName("少林");
		team2 = teamRepository.save(team2);
		
		User user1 = new User();
		user1.setUsername("土豆");
		user1.setPassword("地瓜地瓜我是土豆");
		user1.setTeam(team1);
		user1 = userRepository.save(user1);
		User user2 = new User();
		user2.setUsername("地瓜");
		user2.setPassword("土豆土豆我是地瓜");
		user2.setTeam(team1);
		user2 = userRepository.save(user2);
		
		
		
		
		
		
	}

}
