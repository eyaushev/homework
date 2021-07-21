package pet;

public final class PetEndpoints {
    public static final String addPet = "/pet";
    public static final String updatePet = "/pet";
    public static final String findByStatus = "/pet/findByStatus";
    public static final String uploadImage = "/pet/{petId}/uploadImage";
    public static final String findById = "/pet/{petId}";
    public static final String updateById = "/pet/{petId}";
    public static final String deletePet = "/pet/{petId}";
}
