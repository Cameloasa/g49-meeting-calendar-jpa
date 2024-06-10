package se.lexicon.g49meetingcalendarjpa.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
@EqualsAndHashCode


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(mappedBy = "participants")
    private List<Meeting> meetings = new ArrayList<>();


    // Method to hash the password
    public void setPassword(String password) {
        this.password = hashPassword(password);;
    }

    // Hashing the password using BCrypt
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Method to check the password
    public boolean checkPassword(String plainPassword) {
        return BCrypt.checkpw(plainPassword, this.password);
    }


    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
        meeting.getParticipants().add(this);
    }


}
