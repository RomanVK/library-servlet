package ua.lib.model.dao.mappers;

import ua.lib.model.entity.RoleType;
import ua.lib.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User>{
    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setRole(RoleType.valueOf(rs.getString("role")));
        user.setPassword(rs.getString("password"));//TODO make encrypted password
        user.setBlocked(rs.getBoolean("blocked"));
        return user;
    }

    @Override
    public User makeUnique(Map<Long, User> cache, User user) {
        cache.putIfAbsent(user.getId(), user);
        return cache.get(user.getId());
    }
}
