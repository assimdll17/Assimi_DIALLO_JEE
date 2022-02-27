package dao;

public class DaoImpl implements IDao{
    @Override
    public double getValue() {
        System.out.println("Via la base de données : ");
        return 5;
    }
}
