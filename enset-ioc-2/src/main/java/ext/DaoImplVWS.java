package ext;

import dao.IDao;

public class DaoImplVWS implements IDao {
    @Override
    public double getValue() {
        System.out.println("Version Web Services : ");
        return 20;
    }
}
