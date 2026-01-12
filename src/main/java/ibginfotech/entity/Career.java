package ibginfotech.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "careers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String position;
    private String experience;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Lob
    @Column(name = "resume_bytes")
    private byte[] resume;

    private LocalDateTime appliedAt;
}
