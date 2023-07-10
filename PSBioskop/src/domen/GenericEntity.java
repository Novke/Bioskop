package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNames();
    String getColumnNamesWithoutId();
    String getValues();

    String getInsertValues();

    void setId(long id);

    public Long getId();

    GenericEntity extractFromResultSet(ResultSet rs) throws SQLException;

    String getWhereCondition();

    String AllDetails();

}
