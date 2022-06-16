package ua.goIt.dao;

import ua.goIt.config.PgUtil;
import ua.goIt.model.Skills;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SkillsDao extends AbstractDao<Skills> {


    @Override
    String getTableName() {
        return "skills";
    }

    @Override
    Skills mapToEntity(ResultSet resultSet) throws SQLException {
        Skills skills = new Skills();
        skills.setId(resultSet.getLong("id"));
        skills.setBranch(resultSet.getString("branch"));
        skills.setLevel(resultSet.getString("level"));

        return skills;
    }


    @Override
    public Optional<Skills> create(Skills skills) {
        String sql = "INSERT INTO skills (branch,level) VALUES (?,?)";


        PgUtil.executeWithPrepareStatement(sql, ps -> {
            ps.setString(1, skills.getBranch());
            ps.setString(2, skills.getLevel());
        });
        System.out.println(" CREATED RECORDS ");
        return Optional.empty();
    }

    @Override
    public void update(Skills skills) {
        String sql = "UPDATE skills SET branch = ?,level = ? WHERE id = ?";

        PgUtil.executeWithPrepareStatement(sql, ps -> {
            ps.setString(1, skills.getBranch());
            ps.setString(2, skills.getLevel());
            ps.setLong(3, skills.getId());
        });
        System.out.println(" UPDATED RECORDS ");
    }

    @Override
    public void delete(Long id) {

    }
}

