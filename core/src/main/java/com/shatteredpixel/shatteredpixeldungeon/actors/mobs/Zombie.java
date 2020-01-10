package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ZombieSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Zombie extends Mob {

    {
        spriteClass = ZombieSprite.class;

        HP = HT = 20;
        defenseSkill = 5;
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(1, 6);
    }

    @Override
    public int attackSkill(Char target) { return 10; }

    protected boolean canAttack( Char enemy ) {
        Sample.INSTANCE.play(Assets.SND_ZOMBIE_VOICE);
        return Dungeon.level.adjacent( pos, enemy.pos );
    }

}
