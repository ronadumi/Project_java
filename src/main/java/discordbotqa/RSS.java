package discordbotqa;

import com.rometools.rome.feed.synd.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RSS {

    public RSS() {
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_1.0");
        feed.setTitle("Intrebari Algoritmi");
        feed.setLink("http://www.algoritmi.ro");
        feed.setDescription("Intrebari despre algoritmi");
        //Entry
        SyndEntry entry = new SyndEntryImpl();
        entry.setTitle("Titlu");
        entry.setLink("http://www.algoritmi.ro");

        feed.setEntries(Arrays.asList(entry));
        //Description
        SyndContent description = new SyndContentImpl();
        description.setType("text/html");
        description.setValue("First entry");

        entry.setDescription(description);

        List<SyndCategory> categories = new ArrayList<>();
        SyndCategory category = new SyndCategoryImpl();
        category.setName("Algoritmi");
        categories.add(category);

        entry.setCategories(categories);
    }
}
