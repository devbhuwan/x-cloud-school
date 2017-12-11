package x.cloud.school.profile.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import x.cloud.school.profile.model.School;
import x.cloud.school.profile.service.SchoolService;

import java.util.UUID;

@RestController
@RequestMapping("schools")
public class SchoolEndpoint {

    private SchoolService schoolService;

    @Autowired
    public SchoolEndpoint(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/{id}")
    public Mono<School> get(@PathVariable("id") UUID uuid) {
        return this.schoolService.findOne(uuid);
    }

    @PostMapping
    public Mono<ResponseEntity<School>> save(@RequestBody School school) {
        return this.schoolService.save(school)
                .map(savedSchool -> new ResponseEntity<>(savedSchool, HttpStatus.CREATED));
    }

    @GetMapping(path = "/starting-with/{letter}")
    public Flux<School> findSchoolsWithLetter(
            @PathVariable("letter") String letter) {
        return this.schoolService.findSchoolsStartingWith(letter);
    }

    @GetMapping
    public Flux<School> findSchools() {
        return this.schoolService.findAll();
    }

}
