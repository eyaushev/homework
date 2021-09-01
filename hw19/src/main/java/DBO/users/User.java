package DBO.users;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate birthdate;
    private String city;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(String name, LocalDate birthdate, String city, String phone) {
        this.name = name;
        this.birthdate = birthdate;
        this.city = city;
        this.phone = phone;
    }

    public User(Integer id, String name, LocalDate birthdate, String city, String phone) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.city = city;
        this.phone = phone;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
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
