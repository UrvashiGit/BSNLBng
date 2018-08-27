package com.sterlite.bsnl.repository;

import org.springframework.data.repository.CrudRepository;

import com.sterlite.bsnl.entity.User;

public interface IUserRepository extends CrudRepository<User, Integer> {
	
}
