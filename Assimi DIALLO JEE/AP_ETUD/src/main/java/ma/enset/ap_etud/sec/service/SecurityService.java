package ma.enset.ap_etud.sec.service;


import ma.enset.ap_etud.sec.entities.AppRole;
import ma.enset.ap_etud.sec.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUserName(String username);
}
