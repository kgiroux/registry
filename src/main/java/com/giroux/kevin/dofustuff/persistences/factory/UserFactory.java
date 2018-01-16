package com.giroux.kevin.dofustuff.persistences.factory;

import com.giroux.kevin.dofustuff.commons.security.User;
import com.giroux.kevin.dofustuff.commons.utils.Factory;
import com.giroux.kevin.dofustuff.persistences.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserFactory implements Factory<UserEntity,User> {

    @Override
    public User entityToDto(UserEntity entity) {
        return null;
    }

    @Override
    public UserEntity dtoToEntity(User dto) {
        return null;
    }
}
