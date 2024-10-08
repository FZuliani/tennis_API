package be.zoulou.tennis_api.controller.tabs;


import be.zoulou.tennis_api.exceptions.TennisCourtNotFoundException;
import be.zoulou.tennis_api.model.dto.TennisCourtDto;
import be.zoulou.tennis_api.model.tabs.TennisCourt;
import be.zoulou.tennis_api.service.tabs.TennisCourtService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tennisCourt/{id}")
    public ResponseEntity<TennisCourtDto> getTennisCourtById(@PathVariable final Long id){
        TennisCourt tennisCourt = tennisCourtService.getTennisCourtById(id);
        if(tennisCourt == null){
            throw new TennisCourtNotFoundException(id.toString());
        }
        return ResponseEntity.ok(TennisCourtDto.from(tennisCourt));
    }

    @PostMapping("/tennisCourt")
    public ResponseEntity<TennisCourtDto> addTennisCourt(@RequestBody final TennisCourtDto tennisCourtDTO){
        TennisCourt tennisCourt = tennisCourtService.addTennisCourt(TennisCourt.from(tennisCourtDTO));
        return ResponseEntity.ok(TennisCourtDto.from(tennisCourt));
    }

}
