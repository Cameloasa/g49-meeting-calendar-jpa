package se.lexicon.g49meetingcalendarjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;
    @Column(nullable = false)

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Calendar> calendars = new ArrayList<>();

    public void addCalendar(Calendar calendar) {
        calendars.add(calendar);
        calendar.setMeeting(this);
    }
    public void removeCalendar(Calendar calendar) {
        calendars.remove(calendar);
        calendar.setMeeting(null);
    }
}
