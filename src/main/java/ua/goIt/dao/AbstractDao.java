package ua.goIt.dao;

import ua.goIt.config.PgUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identity> implements Dao<T> {


    abstract String getTableName();

    abstract T mapToEntity(ResultSet resultSet) throws SQLException;


    public void delete(T entity) {
        String sql = String.format("DELETE FROM %s WHERE id = ?", getTableName());

        PgUtil.executeWithPrepareStatement(sql, ps -> {
            ps.setLong(1, entity.getId());

        });
        System.out.println(" DELETED RECORDS " + getTableName());
    }

    @Override
    public Optional<T> get(Long id) {
        String query = String.format("SELECT * FROM %s where id = ?", getTableName());

        try {
            ResultSet resultSet = PgUtil.getWithPrepareStatement(query, ps -> {
                ps.setLong(1, id);
            });
            if (resultSet.next()) {
                System.out.println(" RECORD WAS SELECTED ");
                return Optional.of(mapToEntity(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<T> read() {
        List<T> resultList = new ArrayList<>();
        String query = String.format("SELECT * FROM %s", getTableName());
        try {
            ResultSet resultSet = PgUtil.getWithPrepareStatement(query, ps -> {
            });
            while (resultSet.next()) {

                resultList.add(mapToEntity(resultSet));

            }
        } catch (SQLException e) {
            System.out.println("`READ` METHOD EXCEPTION");

        }


        return resultList;
    }


}


