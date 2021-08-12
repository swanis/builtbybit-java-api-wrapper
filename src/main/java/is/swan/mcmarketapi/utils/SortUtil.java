package is.swan.mcmarketapi.utils;

import is.swan.mcmarketapi.request.sorting.SortOptions;

public class SortUtil {

    public static String optionsToString(SortOptions options) {
        if (options == null) {
            return "";
        }

        String string = "";

        if (options.getSortableField() != null) {
            string += "?sort=" + options.getSortableField();
        }

        if (options.getOrder() != null) {
            string += string.isEmpty() ? "?order=" + options.getOrder().getDisplayName() : "&order=" + options.getOrder().getDisplayName();
        }

        if (options.getPage() >= 1) {
            string += string.isEmpty() ? "?page=" + options.getPage() : "&page=" + options.getPage();
        }

        return string;
    }
}
