package com.giroux.kevin.dofustuff.services.impl;

import com.giroux.kevin.dofustuff.commons.security.RefreshToken;
import com.giroux.kevin.dofustuff.graphql.GraphQLClient;
import com.giroux.kevin.dofustuff.services.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphQLServiceImpl implements GraphQLService{

    @Autowired
    private GraphQLClient graphQLClient;

    public RefreshToken performeAuth(final String login){
        return this.graphQLClient.executeGet(login);
    }
}
