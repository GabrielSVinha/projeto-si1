package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.security.auth.Token;
import org.springframework.stereotype.Service;

public interface TokenService {

    Token createSessionToken(User user);

    Token getByKey(String tokenKey);

    boolean delete(Token token);
}
