import api.ApacheHttpServiceImpl;
import controllers.PetController;
import entities.Category;
import entities.Pet;
import entities.Status;
import entities.Tag;
import io.qameta.allure.Feature;
import org.apache.http.HttpResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Feature("Тест Pet через ApacheHttp")
public class PetApacheHttpTest {
    Pet pet;
    PetController<HttpResponse> controller = new PetController<>(new ApacheHttpServiceImpl<>());

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

    }

    @Test
    @DisplayName("Добавление питомца")
    public void addPet() throws IOException {
            HttpResponse response = controller.addNew(pet);
            HttpResponse getPetResponse = controller.findById(pet.getId());
            Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
            Assertions.assertEquals(200, getPetResponse.getStatusLine().getStatusCode());
    }


    @Test
    @DisplayName("Изменение питомца")
    public void updatePet() throws IOException {
        pet.setName("Гарфилд");
        pet.setStatus(Status.SOLD);
        HttpResponse response = controller.updatePet(pet);
        Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
    }
}
