package org.yangjie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yangjie.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{
	
}
