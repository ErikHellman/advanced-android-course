package se.hellsoft.userinterface.rv;

import java.util.ArrayList;
import java.util.List;

public class Item {
    public Long id;
    public String title;
    public String description;

    public static List<Item> generateItems(int count) {
        ArrayList<Item> items = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Item item = new Item();
            item.id = Long.valueOf(i);
            item.title = "Title " + (i + 1);
            item.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque venenatis tristique vestibulum. Praesent a mi et dui consequat efficitur quis sit amet arcu. Ut placerat elit non scelerisque gravida. Curabitur tincidunt, neque sollicitudin bibendum aliquet, eros dolor mattis massa, lacinia ultricies nulla diam fringilla metus. Nunc in faucibus enim, ac molestie mi. Morbi ullamcorper magna vel efficitur porttitor.";
            items.add(item);
        }
        return items;
    }
}
