package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	Faker faker;
	Store storePayload;

	int id;
	int petId;
	int quantity;
	String status;
	Boolean complete;
	@BeforeClass
	public void setupData() {

		faker = new Faker();
		storePayload = new Store();

		storePayload.setId(faker.idNumber().hashCode()); // To get unique id
		storePayload.setPetId(faker.idNumber().hashCode()); // To get unique id
		storePayload.setQuantity(2);
		storePayload.setStatus("available");
		storePayload.setComplete(true);

	}

	@Test(priority = 1)
	public void testPostOrder() {
		Response response = StoreEndPoints.addOrder(storePayload);
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 2)
	public void testFindOrder() {
		Response response = StoreEndPoints.findOrder(this.storePayload.getId()); // we need id that was used in
																				// the post request
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 3)
	public void testDeleteOrder() {
		Response response = StoreEndPoints.deleteOrder(this.storePayload.getId());
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
	}
}
