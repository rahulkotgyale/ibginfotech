package ibginfotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "portfolio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;
    private String clientName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    @Column(name = "image_bytes")
    private byte[] image;

    private String techStack;
    private String projectUrl;
}
