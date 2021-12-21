package com.csf.zagreba.demo;

import com.csf.zagreba.hashmaprealization.OwnHashMapRealization;

import java.util.Map;

public class Main {

    private static Map<String, String> map = new OwnHashMapRealization<String, String>();

    public static void putElementsInMap() {
        map.put("1", "First");
        map.put("2", "Second");
        map.put("3", "Third");
        map.put("4", "Fourth");;
    }

    public static void clearMap() {
        map.clear();
    }

    public static void printElements() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

    public static void removeOne() {
        map.remove("4");
    }

    public static void main(String[] args) {
        System.out.println("================= PUT ===================");
        putElementsInMap();
        printElements();
        System.out.println("================= END ===================");

        System.out.println("=============== REMOVE ONE ==============");
        removeOne();
        printElements();
        System.out.println("================= END ===================");

        System.out.println("================== CLEAR ================");
        clearMap();
        printElements();
        System.out.println("================== END ================");

    }
}
