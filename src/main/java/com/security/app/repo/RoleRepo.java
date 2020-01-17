package com.security.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.app.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{
	@Query("select role from Role where user_Name=?1")
	public List<String> findByUserName(String userName);
}
