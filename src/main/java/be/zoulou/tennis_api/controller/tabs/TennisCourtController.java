package be.zoulou.tennis_api.controller.tabs;


import be.zoulou.tennis_api.model.dto.TennisCourtDto;
import be.zoulou.tennis_api.model.tabs.TennisCourt;
import be.zoulou.tennis_api.service.tabs.TennisCourtService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
public class TennisCourtController {


    private final TennisCourtService tennisCourtService;

    @Autowired
    public TennisCourtController(TennisCourtService tennisCourtService) {
        this.tennisCourtService = tennisCourtService;
    }

    @GetMapping("/tennisCourts")
    public ResponseEntity<Iterable<TennisCourtDto>> getTennisCourts(){
        System.out.println("TennisCourtController.getTennisCourts");
        List<TennisCourt> tennisCourts = tennisCourtService.getTennisCourts();

        Iterable<TennisCourtDto> tennisCourtDtos = tennisCourts.stream()
                .map(TennisCourtDto::from)
                .toList();

        return ResponseEntity.ok(tennisCourtDtos);

    }

}
