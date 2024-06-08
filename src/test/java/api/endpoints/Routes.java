package api.endpoints;

//Swagger URI ----> https://petstore.swagger.io/v2/user


//Create User(Post)  :  https://petstore.swagger.io/v2/user
//Get User (Get)  :  https://petstore.swagger.io/v2/user/{username}
//Update User (Put)  :  https://petstore.swagger.io/v2/user/{username}
//Delete User (Delete)  :  https://petstore.swagger.io/v2/user/{username}
	
public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String put_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//Store Module
	
	public static String post_url_store = base_url+"/store/order";
	public static String get_url_store = base_url+"/store/order/{orderId}";
	public static String delete_url_store = base_url+"/store/order/{orderId}";
	
	//Pet Module
	
	public static String post_url_pet = base_url+"/pet";
	public static String get_url_pet = base_url+"/pet/{petId}";
	public static String put_url_pet = base_url+"/pet/";
	public static String delete_url_pet = base_url+"/pet/{petId}";

	
}
