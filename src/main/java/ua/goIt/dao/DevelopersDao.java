package ua.goIt.dao;

import ua.goIt.config.PgUtil;
import ua.goIt.model.Developers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DevelopersDao extends AbstractDao<Developers> {

    @Override
    Developers mapToEntity(ResultSet resultSet) throws SQLException {
        Developers developers = new Developers();
        developers.setId(resultSet.getLong("id"));
        developers.setName(resultSet.getString("name"));
        developers.setFirst_name(resultSet.getString("first_name"));
        developers.setLast_name(resultSet.getString("last_name"));
        developers.setAge(resultSet.getInt("age"));
        developers.setBirthday(resultSet.getDate("birthday"));
        developers.setSex(resultSet.getString("sex"));
        developers.setCountry(resultSet.getString("country"));
        developers.setState_code(resultSet.getLong("state_code"));
        developers.setAddress(resultSet.getString("address"));
        developers.setStatus(resultSet.getInt("status"));
        developers.setSalary(resultSet.getBigDecimal("salary"));
        return developers;
    }


    @Override
    public Optional<Developers> create(Developers developers) {
        String sql = "INSERT INTO developers(name,first_name, last_name, age,birthday, sex,country, state_code, address, status,salary) VALUES (?,?,?,?,?,?,?,?,?,?,?)";


        PgUtil.executeWithPrepareStatement(sql, ps -> {
            ps.setString(1, developers.getName());
            ps.setString(2, developers.getFirst_name());
            ps.setString(3, developers.getLast_name());
            ps.setInt(4, developers.getAge());
            ps.setDate(5, developers.getBirthday());
            ps.setString(6, developers.getSex());
            ps.setString(7, developers.getCountry());
            ps.setLong(8, developers.getState_code());
            ps.setString(9, developers.getAddress());
            ps.setInt(10, developers.getStatus());
            ps.setBigDecimal(11, developers.getSalary());
        });
        System.out.println(" CREATED RECORDS ");
        return Optional.empty();
    }

    @Override
    public void update(Developers developers) {
        String sql = "UPDATE developers SET name = ? ,first_name= ?, last_name= ?, age= ?,birthday= ?, sex= ?,country= ?, state_code= ?, address= ?, status= ?,salary= ? WHERE id = ?";

        PgUtil.executeWithPrepareStatement(sql, ps -> {

            ps.setString(1, developers.getName());
            ps.setString(2, developers.getFirst_name());
            ps.setString(3, developers.getLast_name());
            ps.setInt(4, developers.getAge());
            ps.setDate(5, developers.getBirthday());
            ps.setString(6, developers.getSex());
            ps.setString(7, developers.getCountry());
            ps.setLong(8, developers.getState_code());
            ps.setString(9, developers.getAddress());
            ps.setInt(10, developers.getStatus());
            ps.setBigDecimal(11, developers.getSalary());
            ps.setLong(12, developers.getId());
        });
        System.out.println(" UPDATED RECORDS ");

    }

    @Override
    public void delete(Long id) {

    }


    String getTableName() {
        return " developers ";
    }


}
