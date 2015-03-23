package com.example.thetribunal.freshstart.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class LessonsContent {

    /**
     * An array of lesson menu items.
     */
    public static List<MenuItem> ITEMS_1 = new ArrayList<MenuItem>();
    public static List<MenuItem> ITEMS_2 = new ArrayList<MenuItem>();
    public static List<MenuItem> ITEMS_3 = new ArrayList<MenuItem>();
    public static List<MenuItem> ITEMS_4 = new ArrayList<MenuItem>();
    public static List<MenuItem> ITEMS_5 = new ArrayList<MenuItem>();

    //Circuit activity menu
    public static Map<String, MenuItem> CIR_MENU_ITEM_MAP = new HashMap<String, MenuItem>();
    static {
        addItem(new MenuItem( "1.1", "1. Current(I)"), 1);
        addItem(new MenuItem( "1.2", "2. Voltage(V)"), 1);
        addItem(new MenuItem( "1.3", "3. Resistance(R)"), 1);
        addItem(new MenuItem( "1.4", "4. Capacitance(C)"), 1);
        addItem(new MenuItem( "1.5", "5. Inductance(I)"), 1);
    }
    //Embedded systems activity menu
    public static Map<String, MenuItem> ES_MENU_ITEM_MAP = new HashMap<String, MenuItem>();
    static {
        addItem(new MenuItem( "2.1", "1. Accelerometer"), 2);
        addItem(new MenuItem( "2.2", "2. Orientation"), 2);
        addItem(new MenuItem( "2.3", "3. Bluetooth"), 2);
        addItem(new MenuItem( "2.4", "4. GPS"), 2);
        addItem(new MenuItem( "2.5", "5. Wireless Local Area Network"), 2);
    }
    //Mobile development activity menu
    public static Map<String, MenuItem> MD_MENU_ITEM_MAP = new HashMap<String, MenuItem>();
    static {

        addItem(new MenuItem( "3.1", "1. Overview"), 3);
        addItem(new MenuItem( "3.2", "2. Motion Sensors"), 3);
        addItem(new MenuItem( "3.3", "3. User Interaction"), 3);
        addItem(new MenuItem( "3.4", "4. Development Environment"), 3);
    }

    //Math menu
    public static Map<String, MenuItem> MATH_MENU_ITEM_MAP = new HashMap<String, MenuItem>();
    static {
        addItem(new MenuItem( "4.1", "1. Algebra"), 4);
        addItem(new MenuItem( "4.2", "2. Calculus"), 4);
        addItem(new MenuItem( "4.3", "3. Discrete"), 4);
    }

    //Algorithms menu
    public static Map<String, MenuItem> ALG_MENU_ITEM_MAP = new HashMap<String, MenuItem>();
    static {
        addItem(new MenuItem( "5.1", "1. Big-O"), 5);
        addItem(new MenuItem( "5.2", "2. Greedy Algorithms"), 5);
        addItem(new MenuItem( "5.3", "3. Dynamic Programming"), 5);
        addItem(new MenuItem( "5.4", "4. NP-Hard Problems"), 5);
    }

    private static void addItem(MenuItem item, int pos) {
        if(pos == 1) {
            ITEMS_1.add(item);
            CIR_MENU_ITEM_MAP.put(item.id, item);
        }
        if(pos == 2) {
            ITEMS_2.add(item);
            ES_MENU_ITEM_MAP.put(item.id, item);
        }
        if(pos == 3) {
            ITEMS_3.add(item);
            MD_MENU_ITEM_MAP.put(item.id, item);
        }
        if(pos == 4) {
            ITEMS_4.add(item);
            MATH_MENU_ITEM_MAP.put(item.id, item);
        }
        if(pos == 5) {
            ITEMS_5.add(item);
            ALG_MENU_ITEM_MAP.put(item.id, item);
        }
    }

    /**
     * Menu item representation.
     */
    public static class MenuItem {
        public String id;
        public String content;

        public MenuItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
