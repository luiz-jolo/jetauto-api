CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE automobiles (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    model VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    car_body VARCHAR(255) NOT NULL,
    year INTEGER NOT NULL,
    kilometer_age INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT NOW()
);