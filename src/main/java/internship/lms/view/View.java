package internship.lms.view;

public class View {
	public static class MainDetails { }
	
	public static class AllBookDetails extends MainDetails { }
	
	public static class UserLoginDetails { }
	
	public static class UserNameAlso extends UserLoginDetails { }
	
	public static class UserWithoutBooks extends  UserNameAlso { }
	
	public static class IssuedBooks extends MainDetails { }
}


