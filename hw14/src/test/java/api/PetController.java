package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pet.entities.Pet;
import pet.entities.Status;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetController extends ApiController<Pet> {

    public Response addNew(Pet pet){
        String raw = mapper.serialize(pet);
        return given(requestSpecification).body(raw).post(properties.getValue("pet.add"));
    }

    public Response uploadImage(long petId, File... image){
        if (image.length > 0)
            return given(requestSpecification).contentType(ContentType.MULTIPART).multiPart("file", image[0]).when().post(properties.getValue("pet.uploadImage"), petId);
        return given(requestSpecification).post(properties.getValue("pet.uploadImage"), petId);
    }

    public Response updatePet(Pet pet){
        String raw = mapper.serialize(pet);
        return given(requestSpecification).body(raw).put(properties.getValue("pet.update"));
    }

    public Response updateById(long id, String name){
        return given(requestSpecification).contentType(ContentType.URLENC).queryParam("name", name).post(properties.getValue("pet.updateById"), id);
    }

    public Response updateById(long id, Status status){
        return given(requestSpecification).contentType(ContentType.URLENC).queryParam("status", status.name().toLowerCase()).post(properties.getValue("pet.updateById"), id);
    }

    public Response updateById(long id, String name, Status status){
        return given(requestSpecification).contentType(ContentType.URLENC).queryParam("name", name).queryParam("status", status.name().toLowerCase()).post(properties.getValue("pet.updateById"), id);
    }

    public Response findByStatus(Status[] statuses){
        StringBuilder statusStringBuilder = new StringBuilder();
        for (Status s : statuses){
            statusStringBuilder.append(s.name().toLowerCase());
            statusStringBuilder.append(",");
        }
        String status = statusStringBuilder.substring(0, statusStringBuilder.length() -1 );
        return given(requestSpecification).param("status", status).get(properties.getValue("pet.findByStatus"));
    }

    public Response findById(long id){
        return given(requestSpecification).get(properties.getValue("pet.findById"), id);
    }

    public Response deleteById(long id){
        return given(requestSpecification).delete(properties.getValue("pet.deletePet"), id);
    }

    public List<Pet> deserializeList(String raw){
        return mapper.deserializeList(raw, Pet[].class);
    }


}
