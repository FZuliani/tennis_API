package be.zoulou.tennis_api.model.tabs;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "court")
public class TennisCourt {

    @Getter
    @Setter
    @Id
    private Long id;

    @Column(nullable = false, length = 45)
    public String type_court;

    @Getter
    @Setter
    @Column(nullable = false)
    public boolean isIndoor;

    @Getter
    @Setter
    @Column(nullable = false, length = 45)
    public String name;

    @Getter
    @Setter
    @Column(nullable = false, length = 240)
    public String imageProfile;
}
