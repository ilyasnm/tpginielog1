package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  @Test
  @DisplayName("toString Test")
  void toString_Test() {
    Item element = new Item("drg", 21, 5);
    
//    GildedRose app = new GildedRose(new Item[] {element});
//    app.updateQuality();
    assertThat(element.toString(), is("drg, 21, 5"));
  }
  @Test
  @DisplayName("Test that the quality will decrement")
  void testdecrementation() {
    Item[] items = new Item[] {
            new Item("boo", 2, 0),
            new Item("foo", 2, 6),
            new Item("boo", 1, 0),
           new Item("drg", 1, 9),
           new Item("tst", -19, 0),
           new Item("tst", -19, 9),
 
    };

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(0));
    assertThat(app.items[1].quality, is(5));
    assertThat(app.items[2].quality, is(0));
    assertThat(app.items[3].quality, is( 8));
    assertThat(app.items[4].quality, is( 0));
    assertThat(app.items[5].quality, is( 7));

  }
  /**
   *
   */
  @Test
  @DisplayName("Test  quality increases as time goes by")
  void quality_increases_in_time() {
    Item[] items = new Item[] {
            new Item(Item.AB, 19, 50),
            new Item(Item.AB, 19, 9),
            new Item(Item.BAK, 10, 49),
            new Item(Item.BAK, 10, 9),
            new Item(Item.BAK, 11, 9),
            new Item(Item.BAK, 5, 9),
            new Item(Item.BAK, 6, 9),
            new Item(Item.BAK, -1, 48),
            new Item(Item.AB, -1, 9),
            new Item(Item.AB, -1, 49),
            new Item(Item.AB, 1, 9),
            new Item(Item.SUL, -1, 9),
    };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(50));
    assertThat(app.items[1].quality, is(10));
    assertThat(app.items[2].quality, is(50));
    assertThat(app.items[3].quality, is(11));
    assertThat(app.items[4].quality, is(10));
    assertThat(app.items[5].quality, is(12));
    assertThat(app.items[6].quality, is(11));
    assertThat(app.items[7].quality, is(0));
    assertThat(app.items[8].quality, is(11));
    assertThat(app.items[9].quality, is(50));
    assertThat(app.items[10].quality, is(10));
    assertThat(app.items[11].quality, is(9));
  }
  @Test
  @DisplayName("SellIn Decrementation Test")
  void SellInDecrementationTest() {
    Item[] elements = new Item[]
            {

                    new Item("tst", 19, 9),
            };

    GildedRose app = new GildedRose(elements);
    app.updateQuality();
    assertThat(elements[0].sellIn, is( 18));



  }

}
