package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {

	public static Response addOrder(Store payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(Routes.post_url_store);

		return response;
	}

	public static Response findOrder(int orderId) {
		Response response = given().pathParams("orderId", orderId)

				.when().get(Routes.get_url_store);

		return response;
	}

	public static Response deleteOrder(int orderId) {
		Response response = given().pathParam("orderId", orderId)

				.when().delete(Routes.delete_url_store);

		return response;
	}

}
