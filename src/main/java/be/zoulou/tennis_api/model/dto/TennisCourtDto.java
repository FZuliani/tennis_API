package be.zoulou.tennis_api.model.dto;

import be.zoulou.tennis_api.model.tabs.TennisCourt;
import lombok.Data;

@Data
public class TennisCourtDto {

    private Long id;
    private String name;
    private String type_court;
    private boolean isIndoor;
    private String image_profile;

    public static TennisCourtDto from(TennisCourt tennisCourt){
        if (tennisCourt == null){
            return null;
        }
        TennisCourtDto tennisCourtDto = new TennisCourtDto();
        tennisCourtDto.setId(tennisCourt.getId());
        tennisCourtDto.setName(tennisCourt.getName());
        tennisCourtDto.setType_court(tennisCourt.getType_court());
        tennisCourtDto.setIndoor(tennisCourt.isIndoor());
        tennisCourtDto.setImage_profile(tennisCourt.getImageProfile());
        return tennisCourtDto;
    }
}
