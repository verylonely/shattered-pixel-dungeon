package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.MovieClip;
import com.watabou.noosa.TextureFilm;

public class WandererGhostSprite extends MobSprite {

    public WandererGhostSprite(){

        super();

        texture(Assets.WANDERER);

        TextureFilm frames = new TextureFilm(texture, 16, 16);

        idle = new Animation(3, true);
        idle.frames( frames, 24, 25, 26, 26, 25 );

        run = new MovieClip.Animation(12, true);
        run.frames( frames, 28, 29 );

        attack = new MovieClip.Animation(8, false);
        attack.frames( frames, 32, 33, 34, 35, 34, 33, 32 );

        die = new MovieClip.Animation(3, false);
        die.frames( frames, 37, 38, 39, 40 );

        play(idle);

    }

}
