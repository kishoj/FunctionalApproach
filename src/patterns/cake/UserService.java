package patterns.cake;

public class UserService {
	private final UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    String authenticate(String username, String password) {
        return repository.authenticate(username, password);
    }
}
