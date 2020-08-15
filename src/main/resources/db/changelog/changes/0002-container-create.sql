CREATE TABLE IF NOT EXISTS "containers" (
    id uuid NOT NULL,
    container_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    PRIMARY KEY (id)
);
