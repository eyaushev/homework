import api.OkHttpServiceImpl;
import controllers.PetController;
import entities.Category;
import entities.Pet;
import entities.Status;
import entities.Tag;
import io.qameta.allure.Feature;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Feature("Тест Pet через OkHttp")
public class PetOkHttpTest {
    Pet pet;
    PetController<Response> controller = new PetController<>(new OkHttpServiceImpl<>());

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
    public void addPet(){
        try {
            Response response = controller.addNew(pet);
            Response getPetResponse = controller.findById(pet.getId());
            Assertions.assertEquals(200, response.code());
            Assertions.assertEquals(200, getPetResponse.code());
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    @DisplayName("Изменение питомца")
    public void updatePet() throws IOException {
        pet.setName("Гарфилд");
        pet.setStatus(Status.SOLD);
        Response response = controller.updatePet(pet);
        Assertions.assertEquals(200, response.code());
    }
}
