package patterns.cake;

public interface UserServiceComponent extends UserRepositoryComponent {
	default UserService getUserService() {
        return new UserService(getUserRepository());
    }
}
