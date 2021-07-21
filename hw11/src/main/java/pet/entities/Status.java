package pet.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public enum Status {
    @SerializedName("available")
    @JsonProperty("available")
    AVAILABLE,
    @SerializedName("pending")
    @JsonProperty("pending")
    PENDING,
    @SerializedName("sold")
    @JsonProperty("sold")
    SOLD;

    Status() {
    }
}
