package com.gildedrose;
//réalise par ilyas NAIMA ET YACINE IFRADEN
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateQuality();

        }

    }
}