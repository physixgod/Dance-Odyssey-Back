package devnatic.danceodyssey.DAO.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import devnatic.danceodyssey.DAO.ENUM.DanceStyle;
import devnatic.danceodyssey.DAO.ENUM.ExperienceLevel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Set;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int dancerId;
    String firstName;
    String lastName;
    String Password;
    int points;
    @Enumerated(EnumType.STRING)
    DanceStyle danceStyle;
    @Enumerated(EnumType.STRING)
    ExperienceLevel experienceLevel;
    String email;
    String telNum;
    boolean gameplayed;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Event> eventsAttendedByDancers;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore()
    private Set<Event> eventsCreatedByDancers;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore()
    private Set<Group> createdGroups;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore()
    private Set<Group> joinedGroups;
    /*  @JsonIgnore()
      @ManyToMany(cascade = CascadeType.ALL)
      private Set<DanceCourses> dancecourses;*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore()
    private Set<DanceCourses> dancecourses;
    @OneToMany(mappedBy = "dancerParticipated", cascade = CascadeType.ALL) // corrected
    @JsonIgnore()
    private Set<Participate> participates;


    @OneToMany(cascade = CascadeType.ALL , mappedBy = "hoster")
    @JsonIgnore()
    Set<Accommodation> hosterAccommodations;
    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "residents")
    @JsonIgnore()
    Set<Accommodation> residentsAcoomadtions;
    @OneToMany(mappedBy = "dancerRec", cascade = CascadeType.ALL)
    @JsonIgnore()
    private Set<Reclamation> DancersReclamation;
    @OneToMany(mappedBy = "dancerfeed", cascade = CascadeType.ALL)
    @JsonIgnore()
    private Set<Feedback> DancersFeedback;





}