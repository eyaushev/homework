package pet;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import pet.entities.Pet;
import pet.entities.Status;
import utils.JSONMapperImpl;
import java.io.File;
import java.util.List;

public class PetController {
    private final RequestSpecification requestSpecification;
    private final JSONMapperImpl<Pet> mapper;

    public PetController() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://petstore.swagger.io/v2");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
        this.mapper = new JSONMapperImpl<>();
    }

    public Response addNew(Pet pet){
        String raw = mapper.serialize(pet);
        return given(requestSpecification).body(raw).post(PetEndpoints.addPet);
    }

    public Response uploadImage(long petId, File... image){
        if (image.length > 0)
            return given(requestSpecification).contentType(ContentType.MULTIPART).multiPart("file", image[0]).when().post(PetEndpoints.uploadImage, petId);
        return given(requestSpecification).post(PetEndpoints.uploadImage, petId);
    }

    public Response updatePet(Pet pet){
        String raw = mapper.serialize(pet);
        return given(requestSpecification).body(raw).put(PetEndpoints.updatePet);
    }

    public Response updateById(long id, String name){
        return given(requestSpecification).contentType(ContentType.URLENC).queryParam("name", name).post(PetEndpoints.updateById, id);
    }

    public Response updateById(long id, Status status){
        return given(requestSpecification).contentType(ContentType.URLENC).queryParam("status", status.name().toLowerCase()).post(PetEndpoints.updateById, id);
    }

    public Response updateById(long id, String name, Status status){
        return given(requestSpecification).contentType(ContentType.URLENC).queryParam("name", name).queryParam("status", status.name().toLowerCase()).post(PetEndpoints.updateById, id);
    }

    public Response findByStatus(Status[] statuses){
        StringBuilder statusStringBuilder = new StringBuilder();
        for (Status s : statuses){
            statusStringBuilder.append(s.name().toLowerCase());
            statusStringBuilder.append(",");
        }
        String status = statusStringBuilder.substring(0, statusStringBuilder.length() -1 );
        return given(requestSpecification).param("status", status).get(PetEndpoints.findByStatus);
    }

    public Response findById(long id){
        return given(requestSpecification).get(PetEndpoints.findById, id);
    }

    public Response deleteById(long id){
        return given(requestSpecification).delete(PetEndpoints.deletePet, id);
    }

    public List<Pet> deserializeList(String raw){
        return mapper.deserializeList(raw, Pet[].class);
    }


}
