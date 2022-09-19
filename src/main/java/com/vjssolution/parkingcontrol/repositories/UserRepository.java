package com.vjssolution.parkingcontrol.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vjssolution.parkingcontrol.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
	
	Optional<UserModel> findByUserName(String userName);
}
