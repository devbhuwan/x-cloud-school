CREATE KEYSPACE IF NOT EXISTS sample WITH replication = {'class' : 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;
DROP TABLE IF EXISTS sample.schools;
CREATE TABLE IF NOT EXISTS  sample.schools (
    id UUID,
    name varchar,
    primary key(id)
);