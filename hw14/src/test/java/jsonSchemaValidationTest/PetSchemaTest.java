package jsonSchemaValidationTest;

import api.PetController;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pet.entities.Category;
import pet.entities.Pet;
import pet.entities.Status;
import pet.entities.Tag;
import utils.SchemaFactory;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PetSchemaTest {
    Pet pet;
    PetController controller;

    @BeforeEach
    public void setup(){
        this.pet = new Pet(
                3234561,
                new Category(1, "Кошки"),
                "Барсик",
                new String[]{"http://s9.pikabu.ru/post_img/2017/11/04/10/150981807218099995.jpg"},
                new Tag[]{new Tag(1, "1")},
                Status.AVAILABLE
        );
        this.controller = new PetController();

    }

    @Test
    @DisplayName("Добавление питомца")
    public void addPet(){
        Response response = controller.addNew(pet);
        response.then().body(matchesJsonSchemaInClasspath("petJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Pet responsePet = response.getBody().as(Pet.class);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(responsePet, pet);

    }

    @Test
    @DisplayName("Загрузка изображения")
    public void uploadImage(){
        File file = new File(getClass().getClassLoader().getResource("tom.png").getFile());
        Response response = controller.uploadImage(pet.getId(), file);
        response.then().body(matchesJsonSchemaInClasspath("defaultResponseJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    @DisplayName("Изменение питомца")
    public void updatePet(){
        pet.setName("Гарфилд");
        pet.setStatus(Status.SOLD);
        Response response = controller.updatePet(pet);
        response.then().body(matchesJsonSchemaInClasspath("petJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Pet responsePet = response.getBody().as(Pet.class);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(responsePet, pet);
    }

    @Test
    @DisplayName("Поиск по id")
    public void findById(){
        controller.addNew(pet);
        Response response = controller.findById(pet.getId());
        Pet responsePet = response.getBody().as(Pet.class);
        response.then().body(matchesJsonSchemaInClasspath("petJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(responsePet, pet);
    }

    @Test
    @DisplayName("Обновление имени питомца")
    public void updatePetName(){
        controller.addNew(pet);
        Response response = controller.updateById(pet.getId(),"Шарик");
        response.then().body(matchesJsonSchemaInClasspath("defaultResponseJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Response findPet = controller.findById(pet.getId());
        Pet reponsePet = findPet.getBody().as(Pet.class);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Шарик", reponsePet.getName());
        controller.deleteById(pet.getId());
    }

    @Test
    @DisplayName("Обновление статуса питомца")
    public void updatePetStatus(){
        controller.addNew(pet);
        Response response = controller.updateById(pet.getId(), Status.SOLD);
        response.then().body(matchesJsonSchemaInClasspath("defaultResponseJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Response findPet = controller.findById(pet.getId());
        Pet reponsePet = findPet.getBody().as(Pet.class);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(Status.SOLD, reponsePet.getStatus());
        controller.deleteById(pet.getId());
    }

    @Test
    @DisplayName("Удаление питомца из базы")
    public void deletePet(){
        controller.addNew(pet);
        Response response = controller.deleteById(pet.getId());
        response.then().body(matchesJsonSchemaInClasspath("defaultResponseJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Response findPet = controller.findById(pet.getId());
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(404, findPet.statusCode());
    }
}
