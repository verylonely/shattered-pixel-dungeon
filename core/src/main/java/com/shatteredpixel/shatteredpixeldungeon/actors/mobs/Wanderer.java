package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.levels.features.Chasm;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.WandererSprite;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class Wanderer extends Mob {

    {
        alignment = Alignment.NEUTRAL;
        spriteClass = WandererSprite.class;
        HP = HT = 10;

        loot = Generator.Category.WEP_T1;
        lootChance = 0.25f;

        maxLvl = 5;
    }

    private WandererGhost ghost;
    private int summoningPos;

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(1, 3);
    }

    @Override
    public int attackSkill(Char target) { return 7; }

    @Override
    public void die( Object cause ) {

        if (hitWithRanged){
            Statistics.thrownAssists++;
            Badges.validateHuntressUnlock();
        }

        if (cause == Chasm.class){
            //50% chance to round up, 50% to round down
            if (EXP % 2 == 1) EXP += Random.Int(2);
            EXP /= 2;
        }

        if (alignment == Alignment.ENEMY){
            rollToDropLoot();
        }

        if (Dungeon.hero.isAlive() && !Dungeon.level.heroFOV[pos]) {
            GLog.i( Messages.get(this, "died") );
        }

        makeGhost(pos);
        super.die( cause );
    }

    private int dice = Random.NormalIntRange(1, 10);

    public void makeGhost(int pos){
        if(dice == 10){
            ghost = new WandererGhost();
            summoningPos = pos;
            ghost.pos = summoningPos;
            Dungeon.level.occupyCell(ghost);
            GameScene.add(ghost);
        }
    }

}
