package ibginfotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String slug;

    @Lob
    @Column(name = "icon_bytes")
    private byte[] icon;
}
