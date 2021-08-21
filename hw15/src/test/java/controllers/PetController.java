package controllers;

import api.ApiService;
import entities.Pet;
import entities.Status;
import utils.JSONMapperImpl;
import utils.PropertyReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PetController<T> {

    private final ApiService<T> rest;
    public final PropertyReader properties = new PropertyReader();
    public final JSONMapperImpl<Pet> mapper = new JSONMapperImpl<>();

    public PetController(ApiService<T> restService){
        rest = restService;
    }

    public T addNew(Pet pet) throws IOException {
        String raw = mapper.serialize(pet);
        return rest.post(properties.getValue("pet.add"), raw);
    }

//    public T uploadImage(long petId, File... image){
//        if (image.length > 0)
//            return given(requestSpecification).contentType(ContentType.MULTIPART).multiPart("file", image[0]).when().post(properties.getValue("pet.uploadImage"), petId);
//        return given(requestSpecification).post(properties.getValue("pet.uploadImage"), petId);
//    }

    public T updatePet(Pet pet) throws IOException {
        String raw = mapper.serialize(pet);
        return rest.put(properties.getValue("pet.update"), raw);
    }

    public T updateById(long id, String name) throws IOException {
        HashMap<String, String> params = new HashMap<>();
        params.put("name", name);
        return rest.post(properties.getValue("pet.get") + id, params);
    }

    public T updateById(long id, Status status) throws IOException {
        HashMap<String, String> params = new HashMap<>();
        params.put("status", status.name().toLowerCase());
        return rest.post(properties.getValue("pet.get") + id, params);
    }

    public T updateById(long id, String name, Status status) throws IOException {
        HashMap<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("status", status.name().toLowerCase());
        return rest.post(properties.getValue("pet.get") + id, params);
    }

    public T findByStatus(Status[] statuses) throws IOException {
        StringBuilder statusStringBuilder = new StringBuilder();
        for (Status s : statuses){
            statusStringBuilder.append(s.name().toLowerCase());
            statusStringBuilder.append(",");
        }
        String status = statusStringBuilder.substring(0, statusStringBuilder.length() -1 );
        return rest.get(properties.getValue("pet.findByStatus") + status);
//        return given(requestSpecification).param("status", status).get(properties.getValue("pet.findByStatus"));
    }

    public T findById(long id) throws IOException {
        return rest.get(properties.getValue("pet.get") + id);
    }

    public T deleteById(long id) throws IOException {
        return rest.delete(properties.getValue("pet.get") + id);
//        return given(requestSpecification).delete(properties.getValue("pet.deletePet"), id);
    }

    public List<Pet> deserializeList(String raw){
        return mapper.deserializeList(raw, Pet[].class);
    }
}
