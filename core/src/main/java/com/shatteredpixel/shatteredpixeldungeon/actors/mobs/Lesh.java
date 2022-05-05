package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.sprites.RoomlessSprite;

public class Lesh extends Mob {
    {
        state = HUNTING;
        spriteClass = RoomlessSprite.class;

        HP = 5;

        maxLvl = 5;

        defenseSkill = 4;
    }

    public Lesh()
    {
        super();
        HP = 5 + Dungeon.depth * 3;
    }
}
