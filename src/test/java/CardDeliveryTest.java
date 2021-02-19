import com.codeborne.selenide.Condition;
import org.jsoup.safety.Cleaner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {
     @Test
void shouldTestValidCity(){
         open("http://localhost:9999");
         $("[data-test-id=city] input").setValue("Казань");
          String date = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
         $("[data-test-id=date] input").sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
         $("[data-test-id=date] input").setValue(date);
         $("[data-test-id=name] input").setValue("Айдар");
         $("[data-test-id=phone] input").setValue("+79999999999");
         $("[data-test-id=agreement]").click();
         $(withText("Забронировать")).click();
//         $(withText("Успешно!"+"Встреча успешно забронирована на 22.02.2021")).shouldBe(visible, Duration.ofSeconds(5));
       $(" [ data-test-id=notification]").shouldBe(visible, Duration.ofMillis(15000))
                       .shouldHave(exactText("Успешно! Встреча успешно забронирована на "+ date));

     }
    @Test
    void shouldTestinValidCity(){
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Cfhfgekm");
        $("[data-test-id=date] input").setValue("25.02.2021");
        $("[data-test-id=name] input").setValue("Айдар");
        $("[data-test-id=phone] input").setValue("+79999999999");
        $("[data-test-id=agreement]").click();;
        $("button").click();
    }

}
