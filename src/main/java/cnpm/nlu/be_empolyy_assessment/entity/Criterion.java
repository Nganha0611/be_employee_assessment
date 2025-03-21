package cnpm.nlu.be_empolyy_assessment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "criteries")
public class Criterion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    CriterionType criterionType;

    String description;
    int maxScore;
}
