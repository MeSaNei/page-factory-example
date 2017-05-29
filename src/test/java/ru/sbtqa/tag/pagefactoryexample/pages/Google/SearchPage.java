package ru.sbtqa.tag.pagefactoryexample.pages.Google;


import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.WebElementsPage;
import ru.sbtqa.tag.pagefactory.maven_artefacts.module_pagefactory_api.Page;
import ru.sbtqa.tag.pagefactory.maven_artefacts.module_pagefactory_api.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.maven_artefacts.module_pagefactory_api.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.maven_artefacts.module_pagefactory_api.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.maven_artefacts.module_pagefactory_api.annotations.RedirectsTo;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Image;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by sbt-svetlakov-av on 02.05.17.
 */
@PageEntry(title = "Главная страница")
public class SearchPage extends WebElementsPage {

    @ElementTitle("Найти")
    @FindBy(id = "lst-ib")
    public TextInput search;

    @ElementTitle("Логотип")
    @FindBy(id = "hplogo")
    public Image logo;

    @ElementTitle("Поиск в Google")
    @FindBy(name = "btnK")
    public Button searchAtGoogle;

    @ElementTitle("Поиск")
    @FindBy(name = "btnG")
    @RedirectsTo(page = ResultsPage.class)
    public Button searchLoupe;

    public SearchPage(){
        PageFactory.initElements(new HtmlElementDecorator(
                new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }

    @ActionTitle("ищет")
    public void startSearching(String searchText){
        search.sendKeys(searchText);
        search.sendKeys(Keys.ENTER);
    }
}