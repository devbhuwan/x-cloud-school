package x.cloud.school.profile.features;

import org.assertj.core.api.Assertions;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.*;

@EmbeddedCassandra
@CassandraDataSet(keyspace = "sample", value = {"dataset.cql"})
public class AbstractFeaturesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFeaturesTest.class);
    private static final Class<AbstractFeaturesTest> CLAZZ = AbstractFeaturesTest.class;
    private static boolean initialized = false;

    @BeforeClass
    public static void init() throws Exception {
        EmbeddedCassandra embeddedCassandra = Objects.requireNonNull(AnnotationUtils.findAnnotation(CLAZZ, EmbeddedCassandra.class),
                "CassandraUnitTestExecutionListener must be used with @EmbeddedCassandra on " + CLAZZ);
        if (!initialized) {
            String yamlFile = Optional.of(embeddedCassandra.configuration()).get();
            long timeout = embeddedCassandra.timeout();
            EmbeddedCassandraServerHelper.startEmbeddedCassandra(yamlFile, timeout);
            initialized = true;
        }
        CassandraDataSet cassandraDataSet = AnnotationUtils.findAnnotation(CLAZZ, CassandraDataSet.class);
        if (cassandraDataSet != null) {
            String keyspace = cassandraDataSet.keyspace();
            List<String> dataset = dataSetLocations(CLAZZ, cassandraDataSet);
            ListIterator<String> datasetIterator = dataset.listIterator();

            CQLDataLoader cqlDataLoader = new CQLDataLoader(EmbeddedCassandraServerHelper.getSession());
            while (datasetIterator.hasNext()) {
                String next = datasetIterator.next();
                boolean dropAndCreateKeyspace = datasetIterator.previousIndex() == 0;
                cqlDataLoader.load(new ClassPathCQLDataSet(next, dropAndCreateKeyspace, dropAndCreateKeyspace, keyspace));
            }
        }
    }

    private static List<String> dataSetLocations(Class<?> clazz, CassandraDataSet cassandraDataSet) {
        String[] dataset = cassandraDataSet.value();
        if (dataset.length == 0) {
            String alternativePath = alternativePath(clazz, true, cassandraDataSet.type().name());
            if (new File(alternativePath).exists()) {
                dataset = new String[]{alternativePath.replace(ResourceUtils.CLASSPATH_URL_PREFIX + "/", "")};
            } else {
                alternativePath = alternativePath(CLAZZ, false, cassandraDataSet.type().name());
                if (new File(alternativePath).exists()) {
                    dataset = new String[]{alternativePath.replace(ResourceUtils.CLASSPATH_URL_PREFIX + "/", "")};
                } else {
                    LOGGER.info("No dataset will be loaded");
                }
            }
        }
        return Arrays.asList(dataset);
    }

    @AfterClass
    public static void destroy() {
        cleanServer();
    }

    private static void cleanServer() {
        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
    }

    private static String alternativePath(Class<?> clazz, boolean includedPackageName, String extension) {
        if (includedPackageName) {
            return ResourceUtils.CLASSPATH_URL_PREFIX + "/" + ClassUtils.convertClassNameToResourcePath(clazz.getName()) + "-dataset" + "." + extension;
        } else {
            return ResourceUtils.CLASSPATH_URL_PREFIX + "/" + clazz.getSimpleName() + "-dataset" + "." + extension;
        }
    }
}