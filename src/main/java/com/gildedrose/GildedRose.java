package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];

            if (currentItem.name.contains("Aged Brie"))
            {
                if (currentItem.quality < 50)
                {
                    currentItem.quality++;
                }

                currentItem.sellIn--;

                if (currentItem.sellIn < 0)
                {
                    if (currentItem.quality < 50)
                    {
                        currentItem.quality++;
                    }
                }
            }
            else if (items[i].name.contains("Backstage passes"))
            {
                if (currentItem.quality < 50)
                {
                    if (currentItem.sellIn > 10)
                    {
                        currentItem.quality++;
                    }
                    else if (currentItem.sellIn <= 10 && currentItem.sellIn > 5)
                    {
                        currentItem.quality += 2;
                    }
                    else
                    {
                        currentItem.quality += 3;
                    }
                }

                if (currentItem.quality > 50)
                {
                    currentItem.quality = 50;
                }

                currentItem.sellIn--;

                if (currentItem.sellIn < 0)
                {
                    currentItem.quality = 0;
                }
            }
            else if (currentItem.name.startsWith("Conjured"))
            {
                if (currentItem.quality > 0)
                {
                    currentItem.quality -= 2;
                }

                currentItem.sellIn--;

                if (currentItem.sellIn < 0)
                {
                    if (currentItem.quality > 0)
                    {
                        currentItem.quality -= 2;
                    }
                }

                if (currentItem.quality < 0)
                {
                    currentItem.quality = 0;
                }
            }
            else if (!currentItem.name.contains("Sulfuras"))
            {
                if (currentItem.quality > 0)
                {
                    currentItem.quality--;
                }

                currentItem.sellIn--;

                if (currentItem.sellIn < 0)
                {
                    if (currentItem.quality > 0)
                    {
                        currentItem.quality--;
                    }
                }
            }
        }
    }
}