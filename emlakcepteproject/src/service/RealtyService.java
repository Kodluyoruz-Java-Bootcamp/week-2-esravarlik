package service;

import dao.RealtyDao;
import model.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RealtyService {

    // Singleton Pattern
    private static final RealtyService realtyService = new RealtyService();
    private final RealtyDao realtyDao = new RealtyDao();

    private RealtyService() {

    }

    public static RealtyService getDifferentInstance() {
        return new RealtyService();
    }

    public static RealtyService getSameInstance() {
        return realtyService;
    }

    public void createRealty(Realty realty) {

        if (UserType.INDIVIDUAL.equals(realty.getUser().getType()) && HousingType.HOUSE.equals(realty.getHousingType())) {
            if (realty.getUser().getRealtyList().size() > 3) {
                System.out.println("Individual users can post up to 3 ads.");
            } else {
                realtyDao.saveRealty(realty);
                System.out.println("createRealty :: " + realty.getTitle());
            }

        } else {
            System.out.println("Individual users can only post home type ads.");
        }

        if(!UserType.INDIVIDUAL.equals(realty.getUser().getType())){
            realtyDao.saveRealty(realty);
            System.out.println("createRealty :: " + realty.getTitle());
        }

    }


    public List<Realty> getAll() {
        return realtyDao.findAllRealty();
    }

    public void printAll(List<Realty> realtyList) {
        realtyList.forEach(realty -> System.out.println(realty));
    }

    //search by city
    public void getAllByProvince(String province) {

        getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .forEach(realty -> System.out.println(realty));

    }

    //search by district
    public void getAllByDistrict(String district) {

        getAll().stream()
                .filter(realty -> realty.getDistrict().equals(district))
                .forEach(realty -> System.out.println(realty));

    }

    public void getAllByProvinceAndByHousingType(Realty realty) {
        getAll().stream()
                .filter(re -> re.getProvince().equals(realty.getProvince()))
                .filter(re -> HousingType.HOUSE.equals(realty.getHousingType()))
                .collect(toList());


    }

    public List<Realty> getAllByUserName(User user) {
        return getAll().stream()
                .filter(realty -> realty.getUser().getMail().equals(user.getMail()))
                .collect(toList());
    }

    public Integer getAllNumberOfProvincePostings(String province) {
        return Math.toIntExact(getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .count());
    }

    public long getRealtyNumberInProvince(String provinces) {
        return getAll().stream()
                .filter(realty -> provinces.contains(realty.getProvince()))
                .count();
    }

    public void showcaseProvince(String province) {
        getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .limit(10)
                .forEach(realty -> System.out.println(realty));
    }


    public List<Realty> getActiveRealtyByUserName(User user) {

        return getAll().stream()
                .filter(realty -> realty.getUser().getName().equals(user.getName()))
                .filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
                .collect(toList());

    }
}
