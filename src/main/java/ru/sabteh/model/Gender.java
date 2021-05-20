package ru.sabteh.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "gender")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

public class Gender {
    @Id
    private char code;

    @NonNull
    private String name;

    @OneToMany (mappedBy = "genderCode")
    private Set<Client> clients;

    @Override
    public String toString() {
        return "Gender{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", clients=" + clients +
                '}';
    }
}
