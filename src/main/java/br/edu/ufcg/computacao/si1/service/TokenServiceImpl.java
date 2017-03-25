package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.repository.TokenRepository;
import br.edu.ufcg.computacao.si1.security.auth.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public Token createSessionToken(User user) {
        return tokenRepository.save(new Token(user));
    }
}
