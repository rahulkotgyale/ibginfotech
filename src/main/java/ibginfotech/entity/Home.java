package ibginfotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "home")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bannerTitle;

    @Column(columnDefinition = "TEXT")
    private String bannerSubtitle;

    private String buttonText;

    private String buttonLink;

    @Lob
    @Column(name = "banner_image_bytes")
    private byte[] bannerImage;
}
