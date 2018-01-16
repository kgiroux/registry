package com.giroux.kevin.dofustuff.persistences;

import com.giroux.kevin.dofustuff.commons.security.User;

public interface UserPersistence {

    /**
     * Allow to create/update a user
     * @param user
     */
    void createUserOrUpdateByConnexion(final User user);


    /**
     *  Retrieve a user by login
     */
    User retrieveUserByLogin(final String login);


    /**
     * Delete a user by login
     */
    void deleteUserByLogin(final String login);
}
