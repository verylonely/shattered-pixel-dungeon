package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.RoomlessSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Roomless extends Mob {
    {
        state = HUNTING;
        spriteClass = RoomlessSprite.class;

        HP = HT = 10;
        defenseSkill = 4;

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

    @Override
    public void destroy() {

        super.destroy();

        Dungeon.level.mobs.remove( this );

        if (Dungeon.hero.isAlive()) {

            if (alignment == Alignment.ENEMY) {
                Statistics.enemiesSlain++;
                Badges.validateMonstersSlain();
                Statistics.qualifiedForNoKilling = false;

                int exp = Dungeon.hero.lvl <= maxLvl ? EXP : 0;
                if (exp > 0) {
                    Dungeon.hero.sprite.showStatus(CharSprite.POSITIVE, Messages.get(this, "exp", exp));
                }
                Dungeon.hero.earnExp(exp, getClass());
            }
        }

        Sample.INSTANCE.play( Assets.SND_ROOMLESS_DIES );
    }
}
