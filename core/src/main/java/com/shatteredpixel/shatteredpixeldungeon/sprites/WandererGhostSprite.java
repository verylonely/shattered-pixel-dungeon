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
        idle.frames( frames, 25, 26, 27, 26, 25 );

        run = new MovieClip.Animation(12, true);
        run.frames( frames, 29, 30 );

        attack = new MovieClip.Animation(8, false);
        attack.frames( frames, 33, 34, 35, 36, 35, 34, 33 );

        die = new MovieClip.Animation(3, false);
        die.frames( frames, 38, 39, 40, 41 );

        play(idle);

    }

}
