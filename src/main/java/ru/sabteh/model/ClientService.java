package ru.sabteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Setter
@Getter
@Table(name = "clientservice")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor


public class ClientService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @ManyToOne()
    @JoinColumn(name = "ClientID")
    private Client clientId;

    @NonNull
    @ManyToOne()
    @JoinColumn(name = "ServiceID")
    private Service serviceId;

    @NonNull
    private Date startTime;

    private String comment;

    @Override
    public String toString() {
        return "ClientService{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", serviceId=" + serviceId +
                ", startTime=" + startTime +
                ", comment='" + comment + '\'' +
                '}';
    }
}
