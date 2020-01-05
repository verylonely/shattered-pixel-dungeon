package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

import java.util.Random;

public class Chopper extends MeleeWeapon {

    Random rnd = new Random();

    {
        image = ItemSpriteSheet.CHOPPER;

        tier = rnd.nextInt(3);
    }
}
