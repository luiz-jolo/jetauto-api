CREATE TABLE automobile_images (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    file_path TEXT NOT NULL,
    automobile_id UUID NOT NULL,
    uploaded_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_automobile
        FOREIGN KEY (automobile_id)
        REFERENCES automobiles(id)
        ON DELETE CASCADE
);