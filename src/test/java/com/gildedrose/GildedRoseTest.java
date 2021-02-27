package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void ToString_WillDisplayItemInformation_WhenCalled()
    {
        Item item = new Item("Computer", 10, 10);
        assertEquals("Computer, 10, 10", item.toString());
    }

    @Test
    void UpdateQuality_WillDecreaseSellInValueByOne_WhenCalledOneTime() {
        Item[] items = new Item[] { new Item("Computer", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void UpdateQuality_WillDecreaseQualityValueByOne_WhenCalledOneTime() {
        Item[] items = new Item[] { new Item("Computer", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillNotDecreaseQualityValue_WhenTheQualityIsZero(){
        Item[] items = new Item[] { new Item("Computer", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillIncreaseQualityValueByOne_WhenTheItemIsAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillNotIncreaseQualityValueBeyondFifty_WhenTheItemIsAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillIncreaseQualityValueByTwo_WhenItemIsAgedBrieAndSellInIsLessThanZeroAndQualityLessThanFifty(){
        Item[] items = new Item[] { new Item("Aged Brie", -1, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillIncreaseQualityValueByOne_WhenTheItemIsBackstagePassesAndSellInValueIsMoreThanTenDays(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillIncreaseQualityValueByTwo_WhenTheItemIsBackstagePassesAndSellInValueIsBetweenTenAndFiveDays(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillIncreaseQualityValueByThree_WhenTheItemIsBackstagePassesAndSellInValueIsLessThanFiveDays(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillSetQualityToZero_WhenTheItemIsBackstagePassesAndSellInValueIsLessThanZeroDays(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillNotIncreaseQualityValueBeyondFifty_WhenTheItemIsBackstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillDecreaseTheQualityValueByTwo_WhenTheSellInValueIsLessThanZero(){
        Item[] items = new Item[] { new Item("Computer", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillNotChangeQualityOrSellInValues_WhenTheItemIsSulfuras(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 100) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(100, app.items[0].quality);
    }

    @Test
    void UpdateQuality_WillChangeQualityValueProperly_WhenMultipleItemsAreSpecified(){
        Item[] items = new Item[]
        {
                new Item("Computer", 10, 10),
                new Item("Cell Phone", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 35),
                new Item("Sulfuras, Hand of Ragnaros", 0, 100),
                new Item("Aged Brie", 10, 40),
                new Item("Monitor", -1, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(19, app.items[1].quality);
        assertEquals(38, app.items[2].quality);
        assertEquals(100, app.items[3].quality);
        assertEquals(41, app.items[4].quality);
        assertEquals(8, app.items[5].quality);
    }

}
