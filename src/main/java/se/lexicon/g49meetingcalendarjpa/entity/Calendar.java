package se.lexicon.g49meetingcalendarjpa.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String userName;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    public void addMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
    public void removeMeeting(Meeting meeting) {
        this.meeting = null;
    }
}
