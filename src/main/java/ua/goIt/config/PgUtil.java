package ua.goIt.config;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PgUtil {


    public static int executeWithPrepareStatement(String sql, ParamSetter psCall) {

        Connection connection;
        try {
            connection = DataSourceHolder.getDataSource().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                psCall.set(ps);
                return ps.executeUpdate();


            } catch (SQLException throwables) {
                System.out.println("EXCEPTION while tying to execute SQL request");
                return 0;
            }
        } catch (SQLException throwables) {
            System.out.println("EXCEPTION while tying to execute SQL request");
        }
        return 0;
    }


    public static ResultSet getWithPrepareStatement(String sql, ParamSetter psCall) throws SQLException {
        Connection connection;
        connection = DataSourceHolder.getDataSource().getConnection();

        PreparedStatement ps = connection.prepareStatement(sql);
        {
            psCall.set(ps);
            return ps.executeQuery();

        }
    }


    @FunctionalInterface
    public interface ParamSetter {
        void set(PreparedStatement ps) throws SQLException;
    }
}



