package entities;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;


public class Pet implements Serializable {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private Status status;

    public Pet(int id, Category category, String name, String[] photoUrls, Tag[] tags, Status status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Pet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Tag[] getTags() {
        return tags;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + Arrays.toString(photoUrls) +
                ", tags=" + Arrays.toString(tags) +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return id == pet.id && Objects.equals(category, pet.category) && Objects.equals(name, pet.name) && Arrays.equals(photoUrls, pet.photoUrls) && Arrays.equals(tags, pet.tags) && status == pet.status;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, category, name, status);
        result = 31 * result + Arrays.hashCode(photoUrls);
        result = 31 * result + Arrays.hashCode(tags);
        return result;
    }
}
