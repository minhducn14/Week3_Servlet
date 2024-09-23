package entities;

public enum Gender {
	FEMALE("Female"), MALE("Male");

	private String displayName;

	Gender(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String toString() {
		return displayName;
	}
}
