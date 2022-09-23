package taxi.service;

import taxi.exception.AuthenticationException;
import taxi.model.Driver;

public interface AuthenticationService {
    Driver login(String login, String password) throws AuthenticationException;
}
