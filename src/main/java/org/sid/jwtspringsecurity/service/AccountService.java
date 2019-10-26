package org.sid.jwtspringsecurity.service;

import org.sid.jwtspringsecurity.entities.AppUser;
import org.sid.jwtspringsecurity.entities.Role;

public interface AccountService {
    public AppUser saveUser(AppUser user);
    public Role saveRole(Role role);
    public void addRoleToUser(String username,String roleName);
    public AppUser findUserByUsername(String username);

}
