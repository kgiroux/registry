package com.giroux.kevin.dofustuff.persistences.repository;

import com.giroux.kevin.dofustuff.persistences.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<UserEntity,String>{
}
