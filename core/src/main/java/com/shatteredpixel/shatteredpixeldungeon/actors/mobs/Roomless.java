package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.sprites.RoomlessSprite;
import com.watabou.utils.Random;

public class Roomless extends Mob {
    {
        state = HUNTING;
        spriteClass = RoomlessSprite.class;

        HP = HT = 10;
        defenseSkill = 4;

        EXP = 4;
        maxLvl = 7;

        loot = Generator.Category.FOOD;
        lootChance = 0.36f;

    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange( 2, 6 );
    }

    @Override
    public int attackSkill( Char target ) {
        return 10;
    }
}
