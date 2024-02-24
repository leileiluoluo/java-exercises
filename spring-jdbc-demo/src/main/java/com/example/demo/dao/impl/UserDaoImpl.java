package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private JdbcClient jdbcClient;

    @Override
    public Integer countAll() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Integer countByName(String name) {
        String sql = "select count(*) from user where name = :name";
        SqlParameterSource namedParameters = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
    }

    @Override
    public List<User> listAll() {
        String sql = "select id, name, age, email, created_at from user";
        return jdbcTemplate.query(sql, (rs, i) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setEmail(rs.getString("email"));
            user.setCreatedAt(rs.getDate("created_at"));
            return user;
        });
    }

    @Override
    public User getById(Integer id) {
        String sql = "select id, name, age, email, created_at from user where id = :id";
        return jdbcClient.sql(sql)
                .param("id", id)
                .query(User.class).single();
    }

    @Override
    public Integer save(User user) {
        String sql = "insert into user(name, age, email, created_at) values(?, ?, ?, now())";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getEmail());
            return ps;
        }, keyHolder);

        Number id = keyHolder.getKey();
        assert null != id;
        return id.intValue();
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?, age = ?, email = ? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail(), user.getId());
    }

    @Override
    public int[] batchUpdate(List<User> users) {
        return jdbcTemplate.batchUpdate(
                "update user set name = ?, age = ?, email = ? where id = ?",
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        User user = users.get(i);
                        ps.setString(1, user.getName());
                        ps.setInt(2, user.getAge());
                        ps.setString(3, user.getEmail());
                        ps.setInt(4, user.getId());
                    }

                    public int getBatchSize() {
                        return users.size();
                    }
                });
    }

    @Override
    public int[] batchUpdateUsingNamedParameters(List<User> users) {
        return namedParameterJdbcTemplate.batchUpdate(
                "update user set name = :name, age = :age, email = :email where id = :id",
                SqlParameterSourceUtils.createBatch(users));
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
    }

}
