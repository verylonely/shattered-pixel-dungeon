package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.TextureFilm;

public class WispSprite extends MobSprite{

    public WispSprite()
    {
        super();

        texture(Assets.WISP);

        TextureFilm frames = new TextureFilm(texture, 16, 16);

        idle = new Animation(2, true);
        idle.frames(frames,0,1);

        run = new Animation(2, true);
        run.frames(frames,0,1);

        attack = new Animation(5, false);
        attack.frames(frames,0,1);

        die = new Animation(2, false);
        die.frames(frames,2,3);

        play(idle);
    }

}
