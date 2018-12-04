package ru.sofia.market.mvc;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.sofia.market.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class MessageController {
    private final ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(@Valid Message message, BindingResult result) throws Throwable {
        LocalDate date = message.getDate();
        if(date == null)
            return new ModelAndView("messages/form", "message", message);

        CurrencyConverter converter	= CurrencyService.getConverter(date);

        ArrayList<Correlation> values = new ArrayList<>();
        double USDRUB = converter.convertByCurrency(new Money(1, Currency.USD), Currency.RUB).getValue();
        values.add(new Correlation(Currency.USD, Currency.RUB, USDRUB));

        double EURRUB = converter.convertByCurrency(new Money(1, Currency.EUR), Currency.RUB).getValue();
        values.add(new Correlation(Currency.EUR, Currency.RUB, EURRUB));

        double USDEUR = converter.convertByCurrency(new Money(1, Currency.USD), Currency.EUR).getValue();
        values.add(new Correlation(Currency.USD, Currency.EUR, USDEUR));

        message.setValue(values);

        return new ModelAndView("messages/form", "message", message);
    }

    @Autowired
    public MessageController(ProductRepository productRepository){
        this.productRepository = productRepository;
        this.productRepository.save(new Product("Велингтон", new Money(400000, Currency.USD)));
        this.productRepository.save(new Product("efds", new Money(400000, Currency.USD)));
        this.productRepository.save(new Product("wfds", new Money(400, Currency.RUB)));

    }

    @RequestMapping("/productList")
    public ModelAndView prodList(){
        return new ModelAndView("messages/list", "products", this.productRepository.findAll());
    }

    @PostMapping("/addProduct")
    public ModelAndView create(Product product, RedirectAttributes redirectAttributes){
        this.productRepository.save(product);
        return new ModelAndView("redirect:/productList");
    }

    @RequestMapping("/addProduct")
    public String createForm(@ModelAttribute Product product){
        return "messages/formProduct";
    }
}