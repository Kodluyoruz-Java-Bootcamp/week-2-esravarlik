package dao;

import model.Realty;

import java.util.ArrayList;
import java.util.List;

public class RealtyDao {

    private static final List<Realty> realtyList = new ArrayList<>();

    public void saveRealty(Realty realty) {
        realtyList.add(realty);
    }

    public List<Realty> findAllRealty() {
        return realtyList;
    }
}
