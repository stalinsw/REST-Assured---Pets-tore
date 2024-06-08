package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.Pets;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to perform create, read, update, delete requests

public class PetsEndPoints {

	public static Response addPet(Pets payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(Routes.post_url_pet);

		return response;
	}

	public static Response findPet(int petId) {
		Response response = given().pathParams("petId", petId)

				.when().get(Routes.get_url_pet);

		return response;
	}

	public static Response updatePet(int petId, Pets payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().put(Routes.put_url_pet);

		return response;
	}

	public static Response deletePet(int petId) {
		Response response = given().pathParam("petId", petId)

				.when().delete(Routes.delete_url_pet);

		return response;
	}

}
