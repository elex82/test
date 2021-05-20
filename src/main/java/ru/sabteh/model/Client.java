package ru.sabteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "client")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor


public class Client {
    @Id
    @GeneratedValue
    private int id;

    @NonNull

    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String patronymic;


    private Date birthday;

    @NonNull
    private Date registrationDate;

    @NonNull
    private String email;

    @NonNull
    private String phone;

    @ManyToOne()
    @NonNull
    @JoinColumn(name = "GenderCode")
    private Gender genderCode;


    private String photoPath;

    @OneToMany(mappedBy = "clientId")
    private Set <ClientService> clientServices;
}
