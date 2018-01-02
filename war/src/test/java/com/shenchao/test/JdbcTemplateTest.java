package com.shenchao.test;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplateTest {
    private JdbcTemplate jdbcTemplate;
    @BeforeMethod
    public void setUp() throws Exception {
        String url = "jdbc:mysql:///test";
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url,"root","123456");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void testJDBCTemplate(){
        String sql = "select * from User";
        jdbcTemplate.query(sql, resultSet -> {
            Integer id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            String password = resultSet.getString(3);
            System.out.println(id +":"+username+":"+password);
        });
    }

    @Test
    public void testSimpleJdbcTemplate(){
        String sql = "select * from User where id = :name";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        Map map = new HashMap();
        map.put("name", 1);
        List<User> list = namedParameterJdbcTemplate.query(sql, map, new MyUserModel());
        System.out.println(list);
        KeyHolder keyHolder = new GeneratedKeyHolder();
    }

    class MyUserModel implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setName(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            return user;
        }
    }

    @Test
    public void testKeyHolder(){
        String sql = "insert into User values(null,'1111','2222')";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> con.prepareStatement(sql, new String[]{"id"}),keyHolder);
        System.out.println(keyHolder.getKey());
    }

    @Test
    public void testBatch() throws Exception {
        String sql = "insert into User values(null,'1111','2222')";
        String[] batchValues = {sql, sql, sql};
        jdbcTemplate.batchUpdate(batchValues);
        Long integers = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM User", Long.class);
        System.out.println(integers);
    }

    @Test
    public void testDao() throws Exception {

    }
}
