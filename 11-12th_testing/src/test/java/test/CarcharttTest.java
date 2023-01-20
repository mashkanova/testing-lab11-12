package test;

import page.*;
import org.testng.annotations.Test;

public class CarcharttTest extends CommonConditions {
    @Test(description = "Найти черные носки через строку поиска в диапазоне цен 0 - 25 EUR")
    public void CarcharttTest1(){
        new HomePage(driver).openPage()
                .searchQuery("Black socks")
                .setPriceFilter();
    }
    @Test(description = "Найти зеленые мужские аксессуары")
    public void CarcharttTest2(){
        new HomePage(driver).openPage()
                .openMenPage()
                .selectJeans()
                .sortByPriceUp()
        ;
    }
    @Test(description = "Добавление куртки в корзину")
    public void CarcharttTest3(){
        new HomePage(driver).openPage()
                .searchQuery("scarf")
                .selectFirst()
                .addToBag();



    }
    @Test(description = "Тестирование функции Quick shop для покупки женской одежды с первой фотографии в Lookbook")
    public void CarcharttTest4(){
        new HomePage(driver).openPage()
                .openLookbookPage()
                .selectWomenLookbook()
                .selectlookFirst()
                .viewMore();

    }
}
