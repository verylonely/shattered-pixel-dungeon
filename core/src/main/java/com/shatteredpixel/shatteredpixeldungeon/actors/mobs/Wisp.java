package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.sprites.WispSprite;

public class Wisp extends Mob{
    {
        state = SLEEPING;

        spriteClass = WispSprite.class;

        HP = 2;
        maxLvl = 3;

        defenseSkill = 2;
    }

    public Wisp()
    {
        super();
    }
}
