package be.zoulou.tennis_api.model.tabs;


import be.zoulou.tennis_api.model.dto.TennisCourtDto;
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

    public static TennisCourt from(TennisCourtDto tennisCourtDto){
        return TennisCourt.builder()
                .id(tennisCourtDto.getId())
                .type_court(tennisCourtDto.getType_court())
                .isIndoor(tennisCourtDto.isIndoor())
                .name(tennisCourtDto.getName())
                .imageProfile(tennisCourtDto.getImage_profile())
                .build();
    }
}
