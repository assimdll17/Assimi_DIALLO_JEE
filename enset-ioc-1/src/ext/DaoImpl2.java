package ext;

import dao.IDao;

public class DaoImpl2 implements IDao {
    @Override
    public double getValue() {
        System.out.println("Via les capteurs : ");
        return 10;
    }
}
