package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.sprites.WandererSprite;
import com.watabou.utils.Random;

public class Wanderer extends Mob {

    {
        spriteClass = WandererSprite.class;
        HP = HT = 10;


        loot = Generator.Category.MIS_T1;
        lootChance = 0.25f;

        maxLvl = 5;
    }

    @Override
    public int damageRoll() { return Random.NormalIntRange(1, 3);
    }

}
