package cnpm.nlu.be_empolyy_assessment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    LocalDate startDate;
    LocalDate endDate;
    boolean visible;
    String description;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Criterion> criteria;
}
