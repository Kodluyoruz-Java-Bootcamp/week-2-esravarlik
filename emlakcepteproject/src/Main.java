import model.*;
import service.RealtyService;
import service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User userPelin = prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
        User userEsra = prepareUser("Esra", "esra@gmai.com", "Esra123");


        UserService userService = UserService.getDifferentInstance();
        userService.createUser(userPelin);
        userService.createUser(userEsra);

        userService.printAllUser();

        System.out.println("----------------------------------------------------------");

        RealtyService realtyService = RealtyService.getDifferentInstance();
        Realty realty = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA",
                LocalDateTime.now(), userPelin,
                RealtyType.ACTIVE);
        realty.setProvince("İstanbul");
        realty.setDistrict("ZekariyaKöy");
        realty.setHousingType(HousingType.RESIDENTIAL);

        realtyService.createRealty(realty);

        Realty realty1 = new Realty();
        realty1.setNo(124L);
        realty1.setTitle("Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA");
        realty1.setStatus(RealtyType.ACTIVE);
        realty1.setUser(userEsra);
        realty1.setProvince("Ankara");
        realty1.setDistrict("Büyükdere");
        realty.setHousingType(HousingType.PLAZA);

        realtyService.createRealty(realty1);

        realty.setUser(userEsra);
        userEsra.setRealtyList(List.of(realty, realty1));

        System.out.println("----------------------------------------------------------");

        System.out.println("Bütün ilanlar");

        realtyService.printAll(realtyService.getAll());

        System.out.println("----------------------------------------------------------");

        System.out.println("Ankara'daki ilanlar");

        realtyService.getAllByProvince("Ankara");

        System.out.println("----------------------------------------------------------");
        System.out.println("Büyükdere'deki ilanlar");

        realtyService.getAllByDistrict("Büyükdere");

        System.out.println("----------------------------------------------------------");

        System.out.println("Number of advertisements in İstanbul: " + realtyService.getAllNumberOfProvincePostings("İstanbul"));
        System.out.println("Number of advertisements in Ankara: " + realtyService.getAllNumberOfProvincePostings("Ankara"));
        System.out.println("Number  of advertisements in İzmir: " + realtyService.getAllNumberOfProvincePostings("İzmir"));
        realtyService.getAllByProvinceAndByHousingType(realty1);

        Message message = new Message("acil dönüş", "ilan ile ilgili bilgilendirme verebilir misiniz?", userPelin,
                userEsra);

        userEsra.setMessages(List.of(message));
        userPelin.setMessages(List.of(message));

        userEsra.getMessages();

    }
    private static User prepareUser(String name, String email, String password) {
        User user = User.getDifferentInstance();
        user.setName(name);
        user.setMail(email);
        user.setPassword(password);
        user.setType(UserType.INDIVIDUAL);
        user.setCreateDate(LocalDateTime.now());
        return user;
    }

}


