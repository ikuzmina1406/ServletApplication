package ua.goIt.dao;

import ua.goIt.config.PgUtil;
import ua.goIt.model.Companies;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CompaniesDao extends AbstractDao<Companies> {

    @Override
    Companies mapToEntity(ResultSet resultSet) throws SQLException {
        Companies companies = new Companies();
        companies.setId(resultSet.getLong("id"));
        companies.setName(resultSet.getString("name"));
        companies.setState_code(resultSet.getString("state_code"));
        companies.setCountry(resultSet.getString("country"));
        companies.setInfo(resultSet.getString("info"));

        return companies;
    }

    @Override
    public Optional<Companies> create(Companies companies) {

        String sql = "INSERT INTO companies(name, state_code, country, info) VALUES (?,?,?,?)";


        PgUtil.executeWithPrepareStatement(sql, ps -> {
            ps.setString(1, companies.getName());
            ps.setString(2, companies.getState_code());
            ps.setString(3, companies.getCountry());
            ps.setString(4, companies.getInfo());

        });
        System.out.println(" CREATED RECORDS ");
        return Optional.empty();
    }

    @Override
    public void update(Companies companies) {
        String sql = "UPDATE companies SET name = ?, state_code =? , country = ?, info =? WHERE id = ?";

        PgUtil.executeWithPrepareStatement(sql, ps -> {
            ps.setString(1, companies.getName());
            ps.setString(2, companies.getState_code());
            ps.setString(3, companies.getCountry());
            ps.setString(4, companies.getInfo());
            ps.setLong(5, companies.getId());
        });
        System.out.println(" UPDATED RECORDS ");
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    String getTableName() {
        return "companies";
    }


}
