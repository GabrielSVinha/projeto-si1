package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.security.auth.Token;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    Token createSessionToken(User user);
}
