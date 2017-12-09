package x.cloud.school.profile;

import org.cassandraunit.spring.CassandraDataSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cloud School Profile Service Application")
@CassandraDataSet(keyspace = "sample", value = {"dataset.cql"})
public class CloudSchoolProfileServiceApplicationTest extends AbstractCassandraEmbeddedTest {

    @Test
    @DisplayName("")
    public void name() {
    }

}