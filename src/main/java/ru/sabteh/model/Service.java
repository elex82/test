package ru.sabteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "service")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor



public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String title;
    @NonNull
    private boolean cost;
    @NonNull
    private int durationInSeconds;
    private String description;
    @NonNull
    private int discount;
    private String mainImagePath;
    @OneToMany (mappedBy = "serviceId")
    private Set<ClientService> clientServices;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", durationInSeconds=" + durationInSeconds +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", mainImagePath='" + mainImagePath + '\'' +
                ", clientServices=" + clientServices +
                '}';
    }
}
