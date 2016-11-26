package patterns.cake;

public interface LocalUserRepositoryComponent extends UserRepositoryComponent {
	default UserRepository getUserRepository() {
		return new UserRepository() {
			public String authenticate(String username, String password) {
				return "LocalAuthed";
			}
		};
	}
}
