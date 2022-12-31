import model.*;
import service.RealtyService;
import service.UserService;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User userAlp = prepareUser("Alp", "alp@gmail.com", "Alp123");

        User userEsra = prepareUser("Esra", "esra@gmail.com", "Esra123");

        UserService userService = UserService.getSameInstance();
        userService.createUser(userAlp);
        userService.createUser(userEsra);

        System.out.println("----------------------------------------------------------");

        userService.printAllUser();

        System.out.println("----------------------------------------------------------");

        Realty realty = Realty.getDifferentInstance();
        realty.setNo(123L);
        realty.setStatus(RealtyType.ACTIVE);
        realty.setTitle("ZekariyaKöy' de 1200 M2 Satılık VİLLA");
        realty.setPublishedDate(LocalDateTime.now());
        realty.setUser(userAlp);
        realty.setProvince("İstanbul");
        realty.setDistrict("ZekariyaKöy");
        realty.setHousingType(HousingType.HOUSE);

        Realty realty1 = Realty.getDifferentInstance();
        realty1.setNo(124L);
        realty1.setTitle("Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA");
        realty1.setStatus(RealtyType.ACTIVE);
        realty1.setPublishedDate(LocalDateTime.now());
        realty1.setUser(userEsra);
        realty1.setProvince("Ankara");
        realty1.setDistrict("Büyükdere");
        realty1.setHousingType(HousingType.HOUSE);

        Realty realty2 = Realty.getDifferentInstance();
        realty2.setNo(135L);
        realty2.setTitle("Kartal Hürriyet Mahallesi Satılık 3+1 Daire");
        realty2.setStatus(RealtyType.ACTIVE);
        realty2.setPublishedDate(LocalDateTime.now());
        realty2.setUser(userEsra);
        realty2.setProvince("İstanbul");
        realty2.setDistrict("Kartal");
        realty2.setHousingType(HousingType.HOUSE);

        Realty realty3 = Realty.getDifferentInstance();
        realty3.setNo(802L);
        realty3.setTitle("Folkart Vega");
        realty3.setStatus(RealtyType.ACTIVE);
        realty3.setPublishedDate(LocalDateTime.now());
        realty3.setUser(userAlp);
        realty3.setProvince("İzmir");
        realty3.setDistrict("Konak");
        realty3.setHousingType(HousingType.HOUSE);

        RealtyService realtyService = RealtyService.getSameInstance();
        realtyService.createRealty(realty);
        realtyService.createRealty(realty1);
        realtyService.createRealty(realty2);
        realtyService.createRealty(realty3);

        userEsra.setRealtyList(List.of(realty1, realty2));
        userAlp.setRealtyList(List.of(realty, realty3));

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
        System.out.println("----------------------------------------------------------");

        realtyService.showcaseProvince("İstanbul");

        System.out.println("----------------------------------------------------------");

        System.out.println(realtyService.getRealtyNumberInProvince("İstanbul"));

        Message message = new Message("acil dönüş", "ilan ile ilgili bilgilendirme verebilir misiniz?", userAlp,
                userEsra);

        userEsra.setMessages(List.of(message));
        userAlp.setMessages(List.of(message));

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


