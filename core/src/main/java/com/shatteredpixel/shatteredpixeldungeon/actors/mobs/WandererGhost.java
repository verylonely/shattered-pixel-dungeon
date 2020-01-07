package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.sprites.WandererGhostSprite;
import com.watabou.utils.Random;

public class WandererGhost extends Mob {

    {
        spriteClass = WandererGhostSprite.class;

        HP = HT = 15;

        defenseSkill = 5;
        EXP = 10;

        maxLvl = 10;

        loot = Generator.Category.ARTIFACT;
        lootChance = 0.8f;

    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange( 2, 6 );
    }

    @Override
    public int attackSkill( Char target ) {
        return 8;
    }

}
