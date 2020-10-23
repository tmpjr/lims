CREATE TABLE IF NOT EXISTS "users" (
    id uuid NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    created_by UUID,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_by UUID,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    PRIMARY KEY (id)
);
