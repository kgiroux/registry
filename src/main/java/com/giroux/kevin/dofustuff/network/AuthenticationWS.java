package com.giroux.kevin.dofustuff.network;

import com.giroux.kevin.dofustuff.commons.security.User;
import com.giroux.kevin.dofustuff.security.JwtTokenGenerator;
import com.giroux.kevin.dofustuff.security.exceptions.UnauthorizedException;
import com.giroux.kevin.dofustuff.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.time.Instant;

/**
 * WS de gestion de la connexion d'un utilisateur
 *
 * @author kgiroux
 *
 */
@RestController
@RequestMapping("/authenticate")
@CrossOrigin("*")
public class AuthenticationWS {

    private final Logger LOG = LoggerFactory.getLogger(AuthenticationWS.class);

    /**
     * Type d'authentification
     */
    private static String AUTHENTICATION_TYPE = "Basic ";

    /**
     * Générateur du token JWT
     */
    @Autowired
    private JwtTokenGenerator tokenGenerator;

    @Autowired
    private UserService userService;

    /**
     * Service permettant d'authentifier un utilisateur avec une
     * authentification Basic (user/pwd) et de fournir le token JWT associé à
     * l'utilisateur
     *
     * @param credentials
     *            User/pwd inclus dans le header endodé en B64
     * @return token JWT du user
     */
    @RequestMapping(method = RequestMethod.GET)
    public String authorize(@RequestHeader(value = "Authorization", required = false) String credentials) {
        System.out.println("Request token for authentication");
        Long startSecond = Instant.now().getEpochSecond();

        if (StringUtils.isEmpty(credentials) || !credentials.startsWith(AUTHENTICATION_TYPE)) {
            throw new UnauthorizedException();
        }

        UsernamePasswordCredentials cr = getCredentials(credentials);
        if (cr == null) {
            throw new UnauthorizedException();
        }

        // Récupère l'utilisateur tentant de se connecter
        User user = userService.retrieveUserByLogin(cr.getUserName());
        System.out.println("Retrieve user in: "+(Instant.now().getEpochSecond()-startSecond)+" seconds.");

        startSecond = Instant.now().getEpochSecond();
        if (user == null) {
            throw new UnauthorizedException();
        }

        // Check si les éléments d'authentification (pwd) sont corrects
        if (!isAuthorized(user, cr.getPassword())) {
            throw new UnauthorizedException();
        }
        System.out.println("Control password in: "+(Instant.now().getEpochSecond()-startSecond)+" seconds.");

        // Génère le token JWT
        startSecond = Instant.now().getEpochSecond();
        String token = tokenGenerator.generateToken(user);
        System.out.println("Generate token in: "+(Instant.now().getEpochSecond()-startSecond)+" seconds.");
        if(StringUtils.isEmpty(token)){
            throw new UnauthorizedException();
        }

        return token;
    }

    /**
     * Méthode permettant d'extraire les crédentials du Header
     *
     * @param credentials
     * @return
     */
    private UsernamePasswordCredentials getCredentials(final String credentials) {
        UsernamePasswordCredentials cr = null;
        try {
            String out = new String(Base64.decodeBase64(credentials.substring(AUTHENTICATION_TYPE.length())), "UTF-8");
            String[] tabCredential = out.split(":", 2);
            cr = new UsernamePasswordCredentials(tabCredential[0], tabCredential[1]);
        } catch (UnsupportedEncodingException e) {

        }

        return cr;
    }

    /**
     * Méthode permettant de vérifier les credentials d'un utilisateur
     *
     * @return true si le pwd est correct pour le user, false sinon
     */
    private boolean isAuthorized(final User user, final String givenPassword) {
        return user != null && !StringUtils.isEmpty(user.getToken());
    }
}
