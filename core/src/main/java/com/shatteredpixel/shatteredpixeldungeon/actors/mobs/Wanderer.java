package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.StrongKunai;
import com.shatteredpixel.shatteredpixeldungeon.levels.features.Chasm;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.WandererSprite;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Wanderer extends Mob {

    {
        state = WANDERING;
        alignment = Alignment.NEUTRAL;
        spriteClass = WandererSprite.class;
        HP = HT = 10;

        loot = StrongKunai.class;
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

        int dice = Random.Int(5);
        makeGhost(pos, dice);
        super.die( cause );
    }


    private void makeGhost(int pos, int dice){
        if(dice == 1){
            ghost = new WandererGhost();
            summoningPos = pos;
            ghost.pos = summoningPos;
            Dungeon.level.occupyCell(ghost);
            GameScene.add(ghost);
            Sample.INSTANCE.play(Assets.SND_WANDERER_GHOST);
        }
    }

}
