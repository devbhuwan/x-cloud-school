package x.cloud.school.profile.service;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import x.cloud.school.profile.model.School;
import x.cloud.school.profile.repository.SchoolRepository;

import java.util.UUID;

@Component
public class SchoolServiceImpl implements SchoolService {

    private SchoolRepository repository;

    @Override
    public Mono<School> findOne(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public Mono<School> save(School school) {
        return repository.save(school);
    }

    @Override
    public Flux<School> findSchoolsStartingWith(String letter) {
        return repository.findAll();
    }
}
