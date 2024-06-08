package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetsEndPoints;
import api.payload.Pets;
import io.restassured.response.Response;

public class PetsTests {

	Faker faker;
	Pets petPayload;

	@BeforeClass
	public void setupData() {

		faker = new Faker();
		petPayload = new Pets();

		petPayload.setId(faker.idNumber().hashCode()); // To get unique id
		petPayload.setName(faker.name().firstName());
		petPayload.setStatus("available");
		
	}

	@Test(priority = 1)
	public void testPostPet() {
		Response response = PetsEndPoints.addPet(petPayload);
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 2)
	public void findPets() {
		Response response = PetsEndPoints.findPet(this.petPayload.getId()); // we need id that was used in
																					// the post request
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 3)
	public void testUpdatePet() {
		
		//updating the data
		petPayload.setName(faker.name().firstName());
		petPayload.setStatus("unavailable");
		Response response = PetsEndPoints.updatePet(this.petPayload.getId(), petPayload);
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
		
		//testing with updated data
		Response responseafterUpdate = PetsEndPoints.findPet(this.petPayload.getId()); 
		responseafterUpdate.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 4)
	public void testDeletePet() {
		Response response = PetsEndPoints.deletePet(this.petPayload.getId());
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
	}
}
