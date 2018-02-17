package x.cloud.school.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import x.cloud.school.profile.model.School;
import x.cloud.school.profile.repository.SchoolRepository;

import java.util.UUID;

@Component
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository repository;

    @Override
    public Mono<School> findOne(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public Mono<School> save(School school) {
        school.setId(UUID.randomUUID());
        return repository.save(school);
    }

    @Override
    public Flux<School> findSchoolsStartingWith(String letter) {
        return repository.findAll();
    }

    @Override
    public Flux<School> findAll() {
        return repository.findAll();
    }
}
