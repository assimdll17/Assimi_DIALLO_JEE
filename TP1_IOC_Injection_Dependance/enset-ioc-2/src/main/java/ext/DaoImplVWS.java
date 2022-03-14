package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("daoVWS")
public class DaoImplVWS implements IDao {
    @Override
    public double getValue() {
        System.out.println("Version Web Services : ");
        return 20;
    }
}
