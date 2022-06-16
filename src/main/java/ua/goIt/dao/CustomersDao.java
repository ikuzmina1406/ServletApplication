package ua.goIt.dao;

import ua.goIt.config.PgUtil;
import ua.goIt.model.Customers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CustomersDao extends AbstractDao<Customers> {

    @Override
    Customers mapToEntity(ResultSet resultSet) throws SQLException {
        Customers customers = new Customers();
        customers.setId(resultSet.getLong("id"));
        customers.setName(resultSet.getString("name"));
        customers.setState_code(resultSet.getString("state_code"));
        customers.setCountry(resultSet.getString("country"));
        customers.setBirthday(resultSet.getDate("birthday"));
        customers.setSex(resultSet.getString("sex"));
        customers.setInfo(resultSet.getString("info"));

        return customers;
    }


    @Override
    public Optional<Customers> create(Customers customers) {
        String sql = "INSERT INTO customers (name,state_code, country, birthday, sex,info) VALUES (?,?,?,?,?,?)";


        PgUtil.executeWithPrepareStatement(sql, ps -> {
            ps.setString(1, customers.getName());
            ps.setString(2, customers.getState_code());
            ps.setString(3, customers.getCountry());
            ps.setDate(4, customers.getBirthday());
            ps.setString(5, customers.getSex());
            ps.setString(6, customers.getInfo());

        });
        System.out.println(" CREATED RECORDS ");
        return Optional.empty();
    }

    @Override
    public void update(Customers customers) {
        String sql = "UPDATE customers SET name = ?, state_code = ?,country =?, birthday = ?, sex =?, info =? WHERE id = ?";

        PgUtil.executeWithPrepareStatement(sql, ps -> {
            ps.setString(1, customers.getName());
            ps.setString(2, customers.getState_code());
            ps.setString(3, customers.getCountry());
            ps.setDate(4, customers.getBirthday());
            ps.setString(5, customers.getSex());
            ps.setString(6, customers.getInfo());
            ps.setLong(7, customers.getId());
        });
        System.out.println(" UPDATED RECORDS ");

    }

    @Override
    public void delete(Long id) {

    }


    String getTableName() {
        return " customers ";
    }
}


