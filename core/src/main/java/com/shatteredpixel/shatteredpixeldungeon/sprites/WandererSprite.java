package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.MovieClip;
import com.watabou.noosa.TextureFilm;

public class WandererSprite extends MobSprite {

    public WandererSprite(){

        super();

        texture( Assets.WANDERER );

        TextureFilm frames = new TextureFilm(texture, 16, 16);

        idle = new Animation(2, true);
        idle.frames(frames, 0, 1, 2, 1, 0, 3);

        run = new MovieClip.Animation(15, true);
        run.frames(frames, 4, 5);

        attack = new MovieClip.Animation(12, false);
        attack.frames(frames, 9, 8, 9);

        die = new MovieClip.Animation(5, false);
        die.frames(frames, 10, 11, 12);

        play(idle);
    }

}
