package x.cloud.school.profile.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import x.cloud.school.profile.model.School;

import java.util.UUID;

public interface SchoolService {
    Mono<School> findOne(UUID uuid);

    Mono<School> save(School school);

    Flux<School> findSchoolsStartingWith(String letter);

    Flux<School> findAll();
}
