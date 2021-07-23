import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import pet.PetController;
import pet.entities.Category;
import pet.entities.Pet;
import pet.entities.Status;
import pet.entities.Tag;
import org.junit.jupiter.api.Assertions;
import java.io.File;
import java.util.List;

public class PetTest {

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
        Pet responsePet = response.getBody().as(Pet.class);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(responsePet, pet);
    }

    @Test
    @DisplayName("Загрузка изображения")
    public void uploadImage(){
        File file = new File("src/main/resources/tom.png");
        Response response = controller.uploadImage(pet.getId(), file);
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    @DisplayName("Загрузка не изображения не указывая файла (N)")
    public void uploadWithoutImage(){
        Response response = controller.uploadImage(pet.getId());
        Assertions.assertEquals(415, response.statusCode());
    }

    @Test
    @DisplayName("Изменение питомца")
    public void updatePet(){
        pet.setName("Гарфилд");
        pet.setStatus(Status.SOLD);
        Response response = controller.updatePet(pet);
        Pet responsePet = response.getBody().as(Pet.class);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(responsePet, pet);
    }

    @Test
    @DisplayName("Поиск по статусу")
    public void findByStatus(){
        Status[] searchStatus = {Status.AVAILABLE};
        Response response = controller.findByStatus(searchStatus);
        List<Pet> responsePets = controller.deserializeList(response.asString());

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertTrue(responsePets.stream().allMatch(pet -> pet.getStatus() == Status.AVAILABLE));
    }

    @Test
    @DisplayName("Поиск по нескольким статусам")
    public void findByMultipleStatus(){
        Status[] searchStatus = {Status.PENDING, Status.SOLD};
        Response response = controller.findByStatus(searchStatus);
        List<Pet> responsePets = controller.deserializeList(response.asString());

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertTrue(responsePets.stream().allMatch(pet -> pet.getStatus() == Status.PENDING || pet.getStatus() == Status.SOLD));
    }

    @Test
    @DisplayName("Поиск по id")
    public void findById(){
        controller.addNew(pet);
        Response response = controller.findById(pet.getId());
        Pet responsePet = response.getBody().as(Pet.class);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(responsePet, pet);
    }

    @Test
    @DisplayName("Поиск по несуществующему id")
    public void findByUnknownId(){
        controller.deleteById(pet.getId());
        Response response = controller.findById(pet.getId());
        Assertions.assertEquals(404, response.statusCode());
    }

    @Test
    @DisplayName("Обновление имени питомца")
    public void updatePetName(){
        controller.addNew(pet);
        Response response = controller.updateById(pet.getId(),"Шарик");
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
        Response findPet = controller.findById(pet.getId());
        Pet reponsePet = findPet.getBody().as(Pet.class);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(Status.SOLD, reponsePet.getStatus());
        controller.deleteById(pet.getId());
    }

    @Test
    @DisplayName("Обновление имени и статуса питомца")
    public void updatePetStatusAndName(){
        controller.addNew(pet);
        Response response = controller.updateById(pet.getId(), "Гав", Status.PENDING);
        Response findPet = controller.findById(pet.getId());
        Pet reponsePet = findPet.getBody().as(Pet.class);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(Status.PENDING, reponsePet.getStatus());
        Assertions.assertEquals("Гав", reponsePet.getName());
        controller.deleteById(pet.getId());
    }

    @Test
    @DisplayName("Удаление питомца из базы")
    public void deletePet(){
        controller.addNew(pet);
        Response response = controller.deleteById(pet.getId());
        Response findPet = controller.findById(pet.getId());
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(404, findPet.statusCode());
    }

    @Test
    @DisplayName("Удаление питомца с несуществующим id из базы")
    public void deleteUnknownPet(){
        controller.addNew(pet);
        controller.deleteById(pet.getId());
        Response repeatResponse = controller.deleteById(pet.getId());
        Assertions.assertEquals(404, repeatResponse.statusCode());
    }
}
