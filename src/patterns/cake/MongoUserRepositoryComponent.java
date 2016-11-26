package patterns.cake;

public interface MongoUserRepositoryComponent extends UserRepositoryComponent {
	default UserRepository getUserRepository() {
		return new UserRepository() {
			public String authenticate(String username, String password) {
				return "MongoAuthed";
			}
		};
	}
}
