package x.cloud.school.profile.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import x.cloud.school.profile.model.School;

import java.util.UUID;

public interface SchoolRepository extends ReactiveCrudRepository<School, UUID> {

}
