package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;

    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcule() {
        double tmp = dao.getData();
        double res = tmp * 540/Math.cos(tmp*Math.PI);
        return res;
    }
}
