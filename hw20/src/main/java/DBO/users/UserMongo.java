package DBO.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.bson.types.ObjectId;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;


public class UserMongo implements Serializable {
    @JsonProperty("_id")
    private Id id;
    private String name;
    private LocalDate birthdate;
    private String city;
    private String phone;

    public UserMongo(String name, LocalDate birthdate, String city, String phone) {
        this.id = new Id();
        this.name = name;
        this.birthdate = birthdate;
        this.city = city;
        this.phone = phone;
    }

    public class Id {
        @JsonProperty("$oid")
        private String oid;

        public Id(String oid) {
            this.oid = oid;
        }

        public Id() {
            this.oid = new ObjectId().toString();
        }

        public String getOid() {
            return oid;
        }

        @Override
        public String toString() {
            return "Id{" +
                    "oid='" + oid + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;
            Id id = (Id) o;
            return Objects.equals(oid, id.oid);
        }

        @Override
        public int hashCode() {
            return Objects.hash(oid);
        }
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public UserMongo() {
        this.id = new Id();
        this.name = RandomStringUtils.randomAlphanumeric(5);
        this.birthdate = LocalDate.now();
        this.city = "Kazan";
        this.phone = RandomStringUtils.randomNumeric(10);
    }
//
//    public UserMongo(Id id, String name, LocalDate birthdate, String city, String phone) {
//        this.id = id;
//        this.name = name;
//        this.birthdate = birthdate;
//        this.city = city;
//        this.phone = phone;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserMongo)) return false;
        UserMongo user = (UserMongo) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(birthdate, user.birthdate) && Objects.equals(city, user.city) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthdate, city, phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
