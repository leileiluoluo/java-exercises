DELIMITER //

CREATE TRIGGER USER_INSERT_TRIGGER
AFTER INSERT ON user
FOR EACH ROW
BEGIN
    INSERT INTO operation_log (
        entity,
        entity_id,
        operation,
        operated_at
    ) VALUES (
        'User',
        NEW.ID,
        'INSERT',
        NOW()
    );
END//

CREATE TRIGGER USER_UPDATE_TRIGGER
AFTER UPDATE ON user
FOR EACH ROW
BEGIN
    INSERT INTO operation_log (
        entity,
        entity_id,
        operation,
        operated_at
    ) VALUES (
        'User',
        NEW.ID,
        'UPDATE',
        NOW()
    );
END//

CREATE TRIGGER USER_DELETE_TRIGGER
AFTER DELETE ON user
FOR EACH ROW
BEGIN
    INSERT INTO operation_log (
        entity,
        entity_id,
        operation,
        operated_at
    ) VALUES (
        'User',
        OLD.ID,
        'DELETE',
        NOW()
    );
END//

DELIMITER ;