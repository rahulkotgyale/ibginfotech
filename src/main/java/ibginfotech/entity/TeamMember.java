package ibginfotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "team_members")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Lob
    @Column(name = "photo_bytes")
    private byte[] photo;

    private String linkedin;
    private String twitter;
}
